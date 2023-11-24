package com.example.data.mappers

import com.example.data.models.hotel.AboutHotelData
import com.example.data.models.hotel.HotelInfoData
import com.example.domain.models.hotel.AboutHotelDomain
import com.example.domain.models.hotel.HotelInfoDomain

fun AboutHotelDomain.toData(): AboutHotelData = AboutHotelData(
    description, peculiarities
)

fun HotelInfoDomain.toData(): HotelInfoData = HotelInfoData(
    id, name, address, minimal_price, price_for_it, rating, rating_name, image_urls,
    about_the_hotel.toData()
)