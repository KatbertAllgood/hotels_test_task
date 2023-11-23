package com.example.hotels_test_task.models.hotel

import com.example.domain.models.hotel.AboutHotelDomain

data class AboutHotelPresentation(
    override val description: String = "",
    override val peculiarities: List<String> = listOf()
) : AboutHotelDomain
