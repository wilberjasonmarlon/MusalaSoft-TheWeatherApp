package cu.wilb3r.musalaweatherapp.utils

import android.app.Activity
import android.content.Context
import android.content.IntentSender.SendIntentException
import android.location.LocationManager
import androidx.activity.result.IntentSenderRequest
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.*
import com.google.android.gms.tasks.Task
import cu.wilb3r.musalaweatherapp.ui.base.BaseActivity
import javax.inject.Inject


class WatchDogGps @Inject constructor(val context: Activity) {
    private var dialog: Boolean = true
    private val locationManager =
        context.getSystemService(Context.LOCATION_SERVICE) as LocationManager

    fun isGpsEnabled() = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)

    private val locationRequest: LocationRequest = LocationRequest.create().apply {
        interval = 10000
        fastestInterval = 5000
        priority = LocationRequest.PRIORITY_HIGH_ACCURACY
    }

    @Synchronized
    fun isEnabled() {

        if (!isGpsEnabled()) {
            val builder: LocationSettingsRequest.Builder = LocationSettingsRequest.Builder()
                .addLocationRequest(locationRequest).setAlwaysShow(dialog)

            val task: Task<LocationSettingsResponse> =
                LocationServices.getSettingsClient(context).checkLocationSettings(builder.build())

            task.addOnCompleteListener {
                try {
                    task.getResult(ApiException::class.java)
                } catch (e: ApiException) {
                    when (e.statusCode) {
                        LocationSettingsStatusCodes.RESOLUTION_REQUIRED -> {
                            try {
                                // Cast to a resolvable exception.
                                val resolvable = e as ResolvableApiException
                                // Show the dialog by calling startResolutionForResult(),
                                // and check the result in onActivityResult().
//                                resolvable.startResolutionForResult(
//                                    context,
//                                    Companion.REQUEST_CHECK_SETTINGS
//                                )
                                (context as BaseActivity<*>).intentSenderResultLauncher.launch(
                                    IntentSenderRequest.Builder(resolvable.resolution).build()
                                )
                            } catch (e: SendIntentException) {
                                // Ignore the error.
                            } catch (e: java.lang.ClassCastException) {
                                // Ignore, should be an impossible error.
                            }
                        }
                    }
                }
            }
        } else {
            println("GPS is already Enabled!")
        }
    }

    companion object {
        const val REQUEST_CHECK_SETTINGS = 222
    }


}