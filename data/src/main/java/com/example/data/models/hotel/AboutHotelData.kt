package com.example.data.models.hotel

import com.example.domain.models.hotel.AboutHotelDomain
import com.google.gson.annotations.SerializedName

data class AboutHotelData(
    @SerializedName("description")
    override val description: String = "",
    @SerializedName("peculiarities")
    override val peculiarities: List<String> = listOf()
) : AboutHotelDomain