package cu.wilb3r.musalaweatherapp.data.models.onecall

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class OneCallResponse(
    val current: Current,
    val daily: List<Daily>,
    val hourly: List<Hourly>,
    val lat: Double,
    val lon: Double,
    val minutely: List<Minutely>,
    val timezone: String,
    val timezone_offset: Int
): Parcelable