package cu.wilb3r.musalaweatherapp.domain

import android.content.Context
import android.location.Location
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetCurrentLocationUseCaseTest {

    @RelaxedMockK
    private lateinit var locationRepository: LocationRepository
    private val mContextMock = mockk<Context>()
    private lateinit var getCurrentLocationUseCase: GetCurrentLocationUseCase
    private val latitude = -8.838333
    private val longitude = 13.234444
    private val mockLocation = mockk<Location>()

    @Before
    fun onBefore() {
        MockKAnnotations.init(this)
        getCurrentLocationUseCase = GetCurrentLocationUseCase(locationRepository, mContextMock)
    }

    @Test
    fun `when the api doesn't return anything`() = runBlocking {
        //Given
        coEvery { locationRepository.getCurrentLocation() } returns null
        coEvery { mockLocation.latitude } returns latitude
        coEvery { mockLocation.longitude } returns longitude

        //when
        val location = getCurrentLocationUseCase()

        //then
        coEvery { locationRepository.getCurrentLocation() }
        assert(null == location)
    }

    @Test
    fun `when the api return location`() = runBlocking {
        //Given
        coEvery { locationRepository.getCurrentLocation() } returns mockLocation
        coEvery { mockLocation.latitude } returns latitude
        coEvery { mockLocation.longitude } returns longitude

        //when
        val location = getCurrentLocationUseCase()

        //then
        coEvery { locationRepository.getCurrentLocation() }
        assert(mockLocation == location)
    }

}