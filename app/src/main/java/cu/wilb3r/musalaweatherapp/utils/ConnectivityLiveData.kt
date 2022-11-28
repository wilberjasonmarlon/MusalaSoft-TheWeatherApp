package cu.wilb3r.musalaweatherapp.utils

import android.app.Application
import android.content.Context
import android.net.*
import android.os.Build
import androidx.annotation.RequiresPermission
import androidx.lifecycle.LiveData
import cu.wilb3r.musalaweatherapp.utils.Generic.goo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ConnectivityLiveData @Inject constructor(private val connectivityManager: ConnectivityManager) :
    LiveData<Boolean>() {


    @RequiresPermission(android.Manifest.permission.ACCESS_NETWORK_STATE)
    constructor(application: Application) : this(
        connectivityManager = application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    )

    private val networkCallback = object : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {
            postData(isInternetOn())
        }

        override fun onLost(network: Network) {
            postData(false)
        }
    }

    override fun onActive() {
        super.onActive()
        postData(isNetworkIsAvailable())

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            connectivityManager.registerDefaultNetworkCallback(networkCallback)
        } else {
            val builder = NetworkRequest.Builder()
                .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
                .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
            connectivityManager.registerNetworkCallback(builder.build(), networkCallback)
        }
    }

    override fun onInactive() {
        super.onInactive()
        connectivityManager.unregisterNetworkCallback(networkCallback)
    }

    fun isNetworkIsAvailable(): Boolean {
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        return activeNetwork?.isConnected == true
    }

    fun isInternetOn(): Boolean {
        if (isNetworkIsAvailable()) {
            try {
                val p = Runtime.getRuntime().exec("ping -c 3 $goo")
                val value = p.waitFor()
                return value == 0

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return false
    }

    private fun postData(b: Boolean) {
        CoroutineScope(Dispatchers.IO).launch {
            postValue(b)
        }
    }
}