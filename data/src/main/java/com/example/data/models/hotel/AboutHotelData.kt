package com.example.data.models.hotel

import com.example.domain.models.hotel.AboutHotelDomain

data class AboutHotelData(
    override val description: String = "",
    override val peculiarities: List<String> = listOf()
) : AboutHotelDomain