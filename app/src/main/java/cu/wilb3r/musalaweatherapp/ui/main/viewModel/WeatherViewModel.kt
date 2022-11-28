package cu.wilb3r.musalaweatherapp.ui.main.viewModel

import android.location.Location
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import cu.wilb3r.musalaweatherapp.data.models.Resource
import cu.wilb3r.musalaweatherapp.data.models.onecall.OneCallResponse
import cu.wilb3r.musalaweatherapp.data.models.reverse.ReverseResponse
import cu.wilb3r.musalaweatherapp.domain.GetCurrentLocationUseCase
import cu.wilb3r.musalaweatherapp.domain.GetDirectOrReverseUseCase
import cu.wilb3r.musalaweatherapp.domain.GetForecastOneCallUseCase
import cu.wilb3r.musalaweatherapp.ui.annotations.MainActivityStateType
import cu.wilb3r.musalaweatherapp.ui.annotations.MainActivityStateType.Companion.REQUESTING
import cu.wilb3r.musalaweatherapp.ui.base.BaseViewModel
import cu.wilb3r.musalaweatherapp.utils.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val oneCall: GetForecastOneCallUseCase,
    private val rodUseCase: GetDirectOrReverseUseCase,
    private val locationUseCase: GetCurrentLocationUseCase
) : BaseViewModel() {

    private val _oneCallResult = MutableLiveData<Event<OneCallResponse>>()
    val oneCallResult: LiveData<Event<OneCallResponse>>
        get() = _oneCallResult

    private val _reverseResult = MutableLiveData<Event<ReverseResponse>>()
    val reverseResult: LiveData<Event<ReverseResponse>>
        get() = _reverseResult

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean>
        get() = _loading

    private val _error = MutableLiveData<String>()
    val error: LiveData<String>
        get() = _error

    private val _needOneCall = MutableLiveData<Boolean>()
    val needOneCall: LiveData<Boolean>
        get() = _needOneCall

    private val _locationResult = MutableLiveData<Location?>()
    val locationResult: LiveData<Location?>
        get() = _locationResult

    private val _state = MutableLiveData<Int>()
    val state: LiveData<Int>
        get() = _state

    fun getOneCall(location: Location) = viewModelScope.launch {
        _loading.postValue(true)
        oneCall(location).collectLatest { it ->
            when (it) {
                is Resource.Success -> {
                    it.data?.let {
                        _oneCallResult.postValue(Event(it))
                    }
                    _loading.postValue(false)
                }

                is Resource.Loading -> _loading.postValue(true)
                is Resource.Error -> {
                    _loading.postValue(false)
                    it.message?.let {
                        _error.postValue(it)
                    }
                }
            }
        }
    }

    fun getReverse(any: Any) = viewModelScope.launch {
        setState(REQUESTING)
        _needOneCall.postValue(false)
        _loading.postValue(true)
        rodUseCase(any).collectLatest { it ->
            if (any is String)
                _needOneCall.postValue(true)
            when (it) {
                is Resource.Success -> {
                    it.data?.let {
                        _reverseResult.postValue(Event(it))
                    }
                    _loading.postValue(false)
                }

                is Resource.Loading -> _loading.postValue(true)
                is Resource.Error -> {
                    _loading.postValue(false)
                    it.message?.let {
                        _error.postValue(it)
                    }
                }
            }
        }
    }

    fun getCurrentLocation() {
        _loading.postValue(true)
        viewModelScope.launch {
            _locationResult.postValue(locationUseCase())
        }
    }

    fun setState(@MainActivityStateType state: Int) = _state.postValue(state)


}