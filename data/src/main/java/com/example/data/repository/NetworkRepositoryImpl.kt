package com.example.data.repository

import com.example.data.network.NetworkService
import com.example.data.utils.Constants
import com.example.domain.models.booking.BookingDomain
import com.example.domain.models.hotel.HotelInfoDomain
import com.example.domain.models.rooms.AllRoomsDomain
import com.example.domain.repository.NetworkRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NetworkRepositoryImpl : NetworkRepository {

    private val retrofitService = NetworkService.getRetrofitService(Constants.BASE_URL)

    override fun getHotelInfo(): Flow<HotelInfoDomain> = flow {
        emit(retrofitService.getHotelInfo())
    }

    override fun getAllRooms(): Flow<AllRoomsDomain> = flow {
        emit(retrofitService.getAllRooms())
    }

    override fun getBookingInfo(): Flow<BookingDomain> = flow {
        emit(retrofitService.getBookingInfo())
    }
}