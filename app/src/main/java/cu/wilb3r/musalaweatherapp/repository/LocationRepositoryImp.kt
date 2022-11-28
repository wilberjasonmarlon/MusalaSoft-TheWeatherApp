package cu.wilb3r.musalaweatherapp.repository

import android.location.Location
import cu.wilb3r.musalaweatherapp.domain.LocationRepository
import cu.wilb3r.musalaweatherapp.utils.LocationApi
import javax.inject.Inject

class LocationRepositoryImp @Inject constructor(
    private val api: LocationApi
) : LocationRepository {

    override suspend fun getCurrentLocation(): Location? {
        return api.getCurrentLocation()
    }


}