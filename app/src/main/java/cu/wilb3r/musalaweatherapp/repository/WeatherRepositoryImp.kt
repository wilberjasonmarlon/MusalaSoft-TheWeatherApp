package cu.wilb3r.musalaweatherapp.repository

import android.location.Location
import cu.wilb3r.musalaweatherapp.BuildConfig
import cu.wilb3r.musalaweatherapp.data.ApiService
import cu.wilb3r.musalaweatherapp.data.mock.onecallResponse
import cu.wilb3r.musalaweatherapp.data.mock.reverseResponse
import cu.wilb3r.musalaweatherapp.data.models.onecall.OneCallResponse
import cu.wilb3r.musalaweatherapp.data.models.reverse.ReverseResponse
import cu.wilb3r.musalaweatherapp.domain.WeatherRepository
import cu.wilb3r.musalaweatherapp.utils.Api
import retrofit2.Response
import javax.inject.Inject

class WeatherRepositoryImp @Inject constructor(
    private val api: ApiService
) : WeatherRepository {

    override suspend fun getOneCall(location: Location): Response<OneCallResponse> {
        val params = HashMap<String, String>().apply {
            put(Api.API_KEY, BuildConfig.API_KEY)
            put(Api.LAT, location.latitude.toString())
            put(Api.LON, location.longitude.toString())
        }
 //       return onecallResponse
        return api.getOneCall(params)
    }

    override suspend fun getDirectOrReverse(any: Any): Response<ReverseResponse> {
        HashMap<String, String>().apply {
            put(Api.API_KEY, BuildConfig.API_KEY)
            return when (any) {
                is Location -> {
                    put(Api.LAT, any.latitude.toString())
                    put(Api.LON, any.longitude.toString())
                    //reverseResponse
                    api.getReverse(this)
                }
                else -> {
                    put(Api.QUERY, any.toString())
                    //reverseResponse
                    api.getDirect(this)
                }
            }
        }
    }


}