package cu.wilb3r.musalaweatherapp.data.models.onecall

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Minutely(
    val dt: Int,
    val precipitation: Float
): Parcelable