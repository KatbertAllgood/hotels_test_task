package com.example.hotels_test_task.screens.booking

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.booking.GetBookingInfoUseCase
import com.example.hotels_test_task.mappers.toPresentation
import com.example.hotels_test_task.models.booking.BookingPresentation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookingVM @Inject constructor(
    private val getBookingInfoUseCase: GetBookingInfoUseCase
) : ViewModel() {

    private val TAG = BookingVM::class.simpleName

    private var bookingInfoLiveData = MutableLiveData<BookingPresentation>()
    val getBookingInfo : LiveData<BookingPresentation>
        get() = bookingInfoLiveData

    init {
        getBookingInfo()
    }

    private fun getBookingInfo() {
        viewModelScope.launch {
            getBookingInfoUseCase().flowOn(Dispatchers.IO).catch {
                Log.d(TAG, it.message.toString())
            }.map {
                it.toPresentation()
            }.collect {
                bookingInfoLiveData.postValue(it)
            }
        }
    }
}