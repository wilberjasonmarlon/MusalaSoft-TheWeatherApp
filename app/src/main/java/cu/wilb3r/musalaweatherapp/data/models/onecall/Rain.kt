package cu.wilb3r.musalaweatherapp.data.models.onecall

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Rain(
    val `1h`: Double
): Parcelable