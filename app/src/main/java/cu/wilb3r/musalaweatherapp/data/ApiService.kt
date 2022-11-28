package cu.wilb3r.musalaweatherapp.data

import cu.wilb3r.musalaweatherapp.data.models.onecall.OneCallResponse
import cu.wilb3r.musalaweatherapp.data.models.reverse.ReverseResponse
import cu.wilb3r.musalaweatherapp.utils.Api
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ApiService {

    @GET(Api.ONECALL)
    suspend fun getOneCall(
        @QueryMap params: Map<String, String>,
    ): Response<OneCallResponse>

    @GET(Api.REVERSE)
    suspend fun getReverse(
        @QueryMap params: Map<String, String>,
    ): Response<ReverseResponse>

    @GET(Api.DIRECT)
    suspend fun getDirect(
        @QueryMap params: Map<String, String>,
    ): Response<ReverseResponse>
}