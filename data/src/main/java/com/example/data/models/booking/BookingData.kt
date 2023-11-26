package com.example.data.models.booking

import com.example.domain.models.booking.BookingDomain
import com.google.gson.annotations.SerializedName

data class BookingData(
    @SerializedName("id")
    override val id: Int = 0,
    @SerializedName("hotel_name")
    override val hotel_name: String = "",
    @SerializedName("hotel_adress")
    override val hotel_address: String = "",
    @SerializedName("horating")
    override val horating: Int = 0,
    @SerializedName("rating_name")
    override val rating_name: String = "",
    @SerializedName("departure")
    override val departure: String = "",
    @SerializedName("arrival_country")
    override val arrival_country: String = "",
    @SerializedName("tour_date_start")
    override val tour_date_start: String = "",
    @SerializedName("tour_date_stop")
    override val tour_date_stop: String = "",
    @SerializedName("number_of_nights")
    override val number_of_nights: Int = 0,
    @SerializedName("room")
    override val room: String = "",
    @SerializedName("nutrition")
    override val nutrition: String = "",
    @SerializedName("tour_price")
    override val tour_price: Int = 0,
    @SerializedName("fuel_charge")
    override val fuel_charge: Int = 0,
    @SerializedName("service_charge")
    override val service_charge: Int = 0
) : BookingDomain
