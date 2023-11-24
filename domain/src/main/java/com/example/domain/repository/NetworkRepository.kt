package com.example.domain.repository

import com.example.domain.models.booking.BookingDomain
import com.example.domain.models.hotel.HotelInfoDomain
import com.example.domain.models.rooms.AllRoomsDomain
import kotlinx.coroutines.flow.Flow

interface NetworkRepository {

    fun getHotelInfo() : Flow<HotelInfoDomain>

    fun getAllRooms() : Flow<AllRoomsDomain>

    fun getBookingInfo() : Flow<BookingDomain>

}