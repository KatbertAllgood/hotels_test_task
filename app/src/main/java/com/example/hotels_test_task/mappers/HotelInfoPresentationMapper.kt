package com.example.hotels_test_task.mappers

import com.example.data.models.hotel.AboutHotelData
import com.example.data.models.hotel.HotelInfoData
import com.example.domain.models.hotel.AboutHotelDomain
import com.example.domain.models.hotel.HotelInfoDomain
import com.example.hotels_test_task.models.hotel.AboutHotelPresentation
import com.example.hotels_test_task.models.hotel.HotelInfoPresentation

fun AboutHotelDomain.toPresentation(): AboutHotelPresentation = AboutHotelPresentation(
    description, peculiarities
)

fun HotelInfoDomain.toPresentation(): HotelInfoPresentation = HotelInfoPresentation(
    id, name, address, minimal_price, price_for_it, rating, rating_name, image_urls,
    about_the_hotel.toPresentation()
)