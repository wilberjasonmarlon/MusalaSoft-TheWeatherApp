package cu.wilb3r.musalaweatherapp.di

import cu.wilb3r.musalaweatherapp.data.ApiService
import cu.wilb3r.musalaweatherapp.domain.LocationRepository
import cu.wilb3r.musalaweatherapp.domain.WeatherRepository
import cu.wilb3r.musalaweatherapp.repository.LocationRepositoryImp
import cu.wilb3r.musalaweatherapp.repository.WeatherRepositoryImp
import cu.wilb3r.musalaweatherapp.utils.LocationApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideWeatherRepository(
        api: ApiService
    ): WeatherRepository = WeatherRepositoryImp(api)

    @Provides
    fun provideLocationRepository(
        api: LocationApi
    ): LocationRepository = LocationRepositoryImp(api)

}