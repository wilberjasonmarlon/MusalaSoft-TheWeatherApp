package cu.wilb3r.musalaweatherapp.ui.base

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.viewbinding.ViewBinding
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.material.snackbar.Snackbar
import cu.wilb3r.musalaweatherapp.R
import cu.wilb3r.musalaweatherapp.utils.WatchDogGps
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions
import javax.inject.Inject


abstract class BaseActivity<T : ViewBinding> : AppCompatActivity() {

    lateinit var binding: T

    lateinit var TAG: String

    @Inject
    lateinit var inputMethodManager: InputMethodManager

    abstract fun getViewModel(): BaseViewModel

    abstract fun getTag(): String?

    private var baseViewModel: BaseViewModel? = null

    protected val locationPermissions = arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )

    protected var actionId = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getBindingView()
        themeMode()
        setOwnTheme()
        setContentView(binding.root)
        baseViewModel = getViewModel()
        baseViewModel?.onCreate()
        TAG = getTag() ?: ""
        initView()
        setUp(intent.extras)
        doConfigHeader()
    }

    private fun themeMode() {
        when (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
            Configuration.UI_MODE_NIGHT_YES -> {
                /* si esta activo el modo oscuro lo desactiva */
                AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_NO
                )
            }
            Configuration.UI_MODE_NIGHT_NO ->
                AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_NO
                )
        }
    }

    abstract fun getBindingView(): T

    protected open fun setUp(extras: Bundle?) {}

    protected open fun initView() {}

    protected open fun setOwnTheme() {}

    open fun doConfigHeader() {
    }

    override fun onStart() {
        super.onStart()
        baseViewModel?.onStar()
    }

    override fun onPause() {
        super.onPause()
        baseViewModel?.onPause()
    }

    override fun onResume() {
        super.onResume()
        baseViewModel?.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        baseViewModel?.onDestroy()
    }

    override fun onStop() {
        super.onStop()
        baseViewModel?.onStop()
    }

    fun turnOnGps() {
        this.actionId = WatchDogGps.REQUEST_CHECK_SETTINGS
        WatchDogGps(this).isEnabled()
    }

    fun openNetworkSetting(actionId: Int) {
        this.actionId = actionId
        val intent = Intent(Settings.ACTION_WIRELESS_SETTINGS)
        activityResultLauncher.launch(intent)
    }

    fun openAppSetting() {
        this.actionId = AppSettingsDialog.DEFAULT_SETTINGS_REQ_CODE
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
        intent.data = Uri.fromParts("package", packageName, null)
        activityResultLauncher.launch(intent)
    }

    open fun onActivityResult(result: ActivityResult, actionId: Int) = Unit

    private var activityResultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            onActivityResult(result, actionId)
        }

    var intentSenderResultLauncher =
        registerForActivityResult(ActivityResultContracts.StartIntentSenderForResult()) { result ->
            onActivityResult(result, actionId)
        }


    fun hideKeyboard() {
        inputMethodManager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }

    protected open fun requestPermissions(host: Activity) {
        if (hasLocationPermissions(host)) {
            return
        }
        EasyPermissions.requestPermissions(
            host,
            getString(R.string.permissions_access_location),
            REQUESTING_LOCATION_PERMISSION_CODE,
            *locationPermissions
        )
    }

    protected open fun hasLocationPermissions(context: Context) =
        EasyPermissions.hasPermissions(context, *locationPermissions)

    protected open fun showSnackError(message: String?, isIndefinite: Boolean = false, overView: View? = null) {
        val actualMessage = message ?: getString(R.string.msg_error)
        val over = overView ?: window.decorView.rootView
        Snackbar.make(
            over,
            actualMessage,
            if (!isIndefinite) Snackbar.LENGTH_LONG else Snackbar.LENGTH_INDEFINITE
        ).show()
    }

    companion object {
        const val REQUESTING_LOCATION_PERMISSION_CODE = 2
        const val REQUESTING_APP_SETTINGS_CODE = 3
    }

}