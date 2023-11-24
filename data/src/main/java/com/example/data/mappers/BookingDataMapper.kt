package com.example.data.mappers

import com.example.data.models.booking.BookingData
import com.example.domain.models.booking.BookingDomain

fun BookingDomain.toData() : BookingData = BookingData(
    id, hotel_name, hotel_address, horating, rating_name, departure, arrival_country, tour_date_start, tour_date_stop, number_of_nights, room, nutrition, tour_price, fuel_charge, service_charge
)