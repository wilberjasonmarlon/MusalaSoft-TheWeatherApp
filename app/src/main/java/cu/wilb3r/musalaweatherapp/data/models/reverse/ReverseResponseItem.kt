package cu.wilb3r.musalaweatherapp.data.models.reverse

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ReverseResponseItem(
    val name: String,
    val lat: Double? = null,
    val lon: Double? = null
): Parcelable