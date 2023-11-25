package com.example.hotels_test_task.screens.hotel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.hotel.GetHotelInfoUseCase
import com.example.hotels_test_task.mappers.toPresentation
import com.example.hotels_test_task.models.hotel.HotelInfoPresentation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HotelVM @Inject constructor(
    private val getHotelInfoUseCase: GetHotelInfoUseCase
) : ViewModel() {

    private val TAG = HotelVM::class.simpleName

    private var hotelInfoLiveData = MutableLiveData<HotelInfoPresentation>()
    val getHotelInfo: LiveData<HotelInfoPresentation>
        get() = hotelInfoLiveData

    private var hotelName : String = ""
    val getHotelName : String
        get() = hotelName

    init {
        getHotelInfo()
    }

    private fun getHotelInfo() {
        viewModelScope.launch {
            getHotelInfoUseCase().flowOn(Dispatchers.IO).catch {
                Log.d(TAG, it.message.toString())
            }.map {
                it.toPresentation()
            }.collect {
                hotelInfoLiveData.postValue(it)
                hotelName = it.name
            }
        }
    }
}