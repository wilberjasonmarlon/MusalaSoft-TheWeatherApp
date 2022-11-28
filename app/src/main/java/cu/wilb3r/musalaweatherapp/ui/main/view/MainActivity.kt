package cu.wilb3r.musalaweatherapp.ui.main.view

import android.content.DialogInterface
import android.location.Location
import androidx.activity.result.ActivityResult
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import cu.wilb3r.musalaweatherapp.R
import cu.wilb3r.musalaweatherapp.data.models.onecall.OneCallResponse
import cu.wilb3r.musalaweatherapp.databinding.ActivityMainBinding
import cu.wilb3r.musalaweatherapp.ef.hide
import cu.wilb3r.musalaweatherapp.ef.setVisible
import cu.wilb3r.musalaweatherapp.ef.show
import cu.wilb3r.musalaweatherapp.ef.toCelsius
import cu.wilb3r.musalaweatherapp.ui.adapter.ForecastAdapter
import cu.wilb3r.musalaweatherapp.ui.adapter.HourAdapter
import cu.wilb3r.musalaweatherapp.ui.annotations.MainActivityStateType.Companion.ERROR
import cu.wilb3r.musalaweatherapp.ui.annotations.MainActivityStateType.Companion.ERROR_WITH_DATA
import cu.wilb3r.musalaweatherapp.ui.annotations.MainActivityStateType.Companion.REQUESTING
import cu.wilb3r.musalaweatherapp.ui.annotations.MainActivityStateType.Companion.STARTING
import cu.wilb3r.musalaweatherapp.ui.annotations.MainActivityStateType.Companion.SUCCESS
import cu.wilb3r.musalaweatherapp.ui.base.BaseActivity
import cu.wilb3r.musalaweatherapp.ui.main.viewModel.WeatherViewModel
import cu.wilb3r.musalaweatherapp.utils.Api.IMG_4F
import cu.wilb3r.musalaweatherapp.utils.Api.MEDIAURL
import cu.wilb3r.musalaweatherapp.utils.ConnectivityLiveData
import cu.wilb3r.musalaweatherapp.utils.Logger
import cu.wilb3r.musalaweatherapp.utils.WatchDogGps
import cu.wilb3r.musalaweatherapp.utils.WatchDogGps.Companion.REQUEST_CHECK_SETTINGS
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import pub.devrel.easypermissions.AfterPermissionGranted
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity @Inject constructor() : BaseActivity<ActivityMainBinding>(),
    EasyPermissions.PermissionCallbacks,
    EasyPermissions.RationaleCallbacks {

    @Inject
    lateinit var forecastAdapter: ForecastAdapter

    @Inject
    lateinit var hourAdapter: HourAdapter

    @Inject
    lateinit var connectivityLiveData: ConnectivityLiveData

    @Inject
    lateinit var logger: Logger

    @Inject
    lateinit var whatchDogGps: WatchDogGps

    private var searchJob: Job? = null
    private var reverseJob: Job? = null
    private val inHere = this

    private val listener = object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String?): Boolean {
            query?.let {
                if (it.length > 3) {
                    getReverse(it)
                    return true
                }
            }
            return false
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            return false
        }
    }

    override fun getViewModel() = viewModels<WeatherViewModel>().value

    override fun getBindingView() = ActivityMainBinding.inflate(layoutInflater)

    override fun initView() {
        super.initView()
        logger.setTag(TAG)
        setupRecyclerView()
        subscribeObservers()
        getViewModel().setState(STARTING)
        with(binding) {
            searchField.apply {
                isIconified = false
                setOnQueryTextListener(listener)
            }
        }
        getCurrentLocation()
        hideKeyboard()
    }

    private fun setupRecyclerView() {
        with(binding) {
            recyclerForecast.apply {
                layoutManager =
                    LinearLayoutManager(inHere, LinearLayoutManager.VERTICAL, false)
                adapter = forecastAdapter
            }
            recyclerForecastHourly.apply {
                layoutManager =
                    LinearLayoutManager(inHere, LinearLayoutManager.HORIZONTAL, false)
                adapter = hourAdapter
            }
        }
    }

    @AfterPermissionGranted(REQUESTING_LOCATION_PERMISSION_CODE)
    private fun getCurrentLocation() {
        if (hasLocationPermissions(this)) {
            if (WatchDogGps(this).isGpsEnabled()) {
                getViewModel().getCurrentLocation()
            } else {
                turnOnGps()
            }
        } else {
            requestPermissions(this)
        }
    }

    private fun subscribeObservers() {
        getViewModel().apply {
            loading.observe(inHere) {
                it?.let { binding.progressBar.setVisible(it) }
            }
            error.observe(inHere) {
                it?.let {
                    binding.constraintLayout.hide()
                    binding.errorLyl.root.setVisible(
                        !binding.constraintLayout.isVisible
                    )
                }
            }
            reverseResult.observe(inHere) { data ->
                data?.let { event ->
                    event.getContentIfNotHandled()?.let {
                        if (it.isNotEmpty()) {
                            binding.errorLyl.root.hide()
                            binding.noDataLyl.root.hide()
                            binding.searchField.setQuery(it.firstOrNull()?.name, false)
                            if (needOneCall.value == true) {
                                oneCallFor(
                                    Location("").apply {
                                        latitude = it.firstOrNull()?.lat ?: 0.0
                                        longitude = it.firstOrNull()?.lon ?: 0.0
                                    }
                                )
                            }
                        } else {
                            binding.noDataLyl.root.show()
                        }
                        hideKeyboard()
                    }
                }
            }
            oneCallResult.observe(inHere) { data ->
                data?.let { event ->
                    event.peekContent().let {
                        logger.log("oneCallResult: $it")
                        setState(SUCCESS)
                        paintState(it)
                        forecastAdapter.apply {
                            setCurrent(it.current.temp)
                            submitList(it.daily)
                        }
                        hourAdapter.apply {
                            submitList(it.hourly)
                        }
                        hideKeyboard()
                    }
                }
            }
            locationResult.observe(inHere) { data ->
                data?.let {
                    logger.log(">>> Location: $data")
                    oneCallFor(it)
                    getReverse(it)
                }
            }
            state.observe(inHere) { state ->
                with(binding) {
                    when (state) {
                        STARTING -> {
                            progressBar.show()
                        }
                        REQUESTING -> {
                            progressBar.show()
                            constraintLayout.hide()
                        }
                        SUCCESS -> {
                            progressBar.hide()
                            errorLyl.root.hide()
                            constraintLayout.show()
                        }
                        ERROR -> {
                            progressBar.hide()
                            errorLyl.root.show()
                            constraintLayout.hide()
                        }
                        ERROR_WITH_DATA -> {}
                    }
                }
            }
        }
    }

    private fun oneCallFor(location: Location) {
        searchJob?.cancel()
        searchJob = lifecycleScope.launch {
            getViewModel().getOneCall(location)
        }
    }

    private fun getReverse(any: Any) {
        binding.noDataLyl.root.hide()
        binding.errorLyl.root.hide()
        reverseJob?.cancel()
        reverseJob = lifecycleScope.launch {
            getViewModel().getReverse(any)
        }
    }

    override fun onPause() {
        super.onPause()
        searchJob?.cancel()
        reverseJob?.cancel()
    }

    override fun onResume() {
        super.onResume()
        setupConnectivityCheck()
    }

    private fun setupConnectivityCheck() {
        connectivityLiveData.observe(inHere) {
            binding.partial.noConnection.setVisible(!it)
            if (!it) binding.progressBar.hide()
        }
    }

    private fun paintState(data: OneCallResponse) {
        binding.weatheIcon.load(MEDIAURL + data.current.weather[0].icon + IMG_4F)
        binding.weatherDescription.text = data.current.weather[0].description
        binding.mainTemp.text =
            data.current.temp.toCelsius()
        binding.mainFeel.text =
            getString(R.string.feel_formated, data.current.feels_like.toCelsius())
        binding.timeZone.text = data.timezone
    }

    override fun onActivityResult(result: ActivityResult, actionId: Int) {
        super.onActivityResult(result, actionId)
        if (actionId == AppSettingsDialog.DEFAULT_SETTINGS_REQ_CODE) {
            getCurrentLocation()
        }
        if (actionId == REQUEST_CHECK_SETTINGS)
            if (result.resultCode == RESULT_OK) {
                getCurrentLocation()
            } else {
                turnOnGps()
            }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        logger.log(">> onRequestPermissionsResult:$requestCode: $permissions $grantResults")
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {
        logger.log(">> onPermissionsGranted:$requestCode:$perms")
    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        logger.log(">> onPermissionsDenied:$requestCode:$perms")
        logger.log(
            ">> EasyPermissions.somePermissionPermanentlyDenied(this, perms) = ${
                EasyPermissions.somePermissionPermanentlyDenied(
                    this,
                    perms
                )
            }"
        )
        if (requestCode == REQUESTING_LOCATION_PERMISSION_CODE) {
            AlertDialog.Builder(this)
                .setMessage("This app may not work correctly without the requested permissions. Open the app setting screen to modify app permissions")
                .setCancelable(false)
                .setPositiveButton("Proceed", DialogInterface.OnClickListener { dialog, id ->
                    openAppSetting()
                })
                .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, id ->
                    getCurrentLocation()
                })
                .create().apply { setTitle("Permissions Required") }
                .show()
        }
    }

    override fun onRationaleAccepted(requestCode: Int) {
        logger.log(">> onRationaleAccepted:$requestCode")

    }

    override fun onRationaleDenied(requestCode: Int) {
        logger.log(">> onRationaleDenied:$requestCode")

    }

    override fun getTag(): String? {
        return inHere.javaClass.canonicalName
    }

    companion object {
        const val APP = "app"
    }


}