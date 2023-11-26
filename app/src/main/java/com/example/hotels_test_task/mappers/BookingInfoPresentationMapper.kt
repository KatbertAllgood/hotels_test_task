package com.example.hotels_test_task.mappers

import com.example.data.models.booking.BookingData
import com.example.domain.models.booking.BookingDomain
import com.example.hotels_test_task.models.booking.BookingPresentation

fun BookingDomain.toPresentation() : BookingPresentation = BookingPresentation(
    id, hotel_name, hotel_address, horating, rating_name, departure, arrival_country, tour_date_start, tour_date_stop, number_of_nights, room, nutrition, tour_price, fuel_charge, service_charge
)