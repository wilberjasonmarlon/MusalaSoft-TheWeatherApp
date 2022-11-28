package cu.wilb3r.musalaweatherapp.domain

import android.location.Location

interface LocationRepository {
    suspend fun getCurrentLocation(): Location?
}