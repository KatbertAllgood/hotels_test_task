package com.example.hotels_test_task.models.booking

import com.example.domain.models.booking.BookingDomain

data class BookingPresentation(
    override val id: Int = 0,
    override val hotel_name: String = "",
    override val hotel_address: String = "",
    override val horating: Int = 0,
    override val rating_name: String = "",
    override val departure: String = "",
    override val arrival_country: String = "",
    override val tour_date_start: String = "",
    override val tour_date_stop: String = "",
    override val number_of_nights: Int = 0,
    override val room: String = "",
    override val nutrition: String = "",
    override val tour_price: Int = 0,
    override val fuel_charge: Int = 0,
    override val service_charge: Int = 0
) : BookingDomain
