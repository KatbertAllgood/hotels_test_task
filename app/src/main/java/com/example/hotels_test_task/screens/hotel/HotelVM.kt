package com.example.hotels_test_task.screens.hotel

import androidx.lifecycle.ViewModel
import com.example.domain.usecase.hotel.GetHotelInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HotelVM @Inject constructor(
    private val getHotelInfoUseCase: GetHotelInfoUseCase
) : ViewModel() {

}