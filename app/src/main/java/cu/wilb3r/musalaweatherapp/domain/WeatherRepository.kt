package cu.wilb3r.musalaweatherapp.domain

import android.location.Location
import cu.wilb3r.musalaweatherapp.data.models.onecall.OneCallResponse
import cu.wilb3r.musalaweatherapp.data.models.reverse.ReverseResponse
import retrofit2.Response

interface WeatherRepository {
    suspend fun getOneCall(location: Location): Response<OneCallResponse>
    suspend fun getDirectOrReverse(any: Any): Response<ReverseResponse>
}