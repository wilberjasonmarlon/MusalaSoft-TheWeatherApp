package cu.wilb3r.musalaweatherapp.domain

import android.content.Context
import android.location.Location
import cu.wilb3r.musalaweatherapp.R
import cu.wilb3r.musalaweatherapp.data.models.Resource
import cu.wilb3r.musalaweatherapp.data.models.onecall.OneCallResponse
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetForecastOneCallUseCase @Inject constructor(
    private val repository: WeatherRepository,
    @ApplicationContext val context: Context
) {
    operator fun invoke(location: Location): Flow<Resource<OneCallResponse>> = flow {
        try {
            emit(Resource.Loading())
            val response = repository.getOneCall(location)
            if (response.isSuccessful) {
                response.body()?.let {
                    emit(Resource.Success(it))
                }
            }
        } catch (ex: HttpException) {
            emit(
                Resource.Error(ex.localizedMessage ?: context.getString(R.string.unexpected_error))
            )
        } catch (ex: IOException) {
            emit(
                Resource.Error(context.resources.getString(R.string.no_internet))
            )
        }
    }
}