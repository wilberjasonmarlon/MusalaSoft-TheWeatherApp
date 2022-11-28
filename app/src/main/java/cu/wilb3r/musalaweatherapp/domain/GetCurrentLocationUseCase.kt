package cu.wilb3r.musalaweatherapp.domain

import android.content.Context
import android.location.Location
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetCurrentLocationUseCase @Inject constructor(
    private val repository: LocationRepository,
    @ApplicationContext val context: Context
) {
    suspend operator fun invoke(): Location?  {
        return repository.getCurrentLocation()
    }
}
