package cu.wilb3r.musalaweatherapp.domain

import android.content.Context
import cu.wilb3r.musalaweatherapp.R
import cu.wilb3r.musalaweatherapp.data.models.Resource
import cu.wilb3r.musalaweatherapp.data.models.reverse.ReverseResponse
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetDirectOrReverseUseCase @Inject constructor(
    private val repository: WeatherRepository,
    @ApplicationContext val context: Context
) {
    operator fun invoke(any: Any): Flow<Resource<ReverseResponse>> = flow {
        try {
            emit(Resource.Loading())
            val response = repository.getDirectOrReverse(any)
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