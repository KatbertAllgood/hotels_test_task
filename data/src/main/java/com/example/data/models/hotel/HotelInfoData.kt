package com.example.data.models.hotel

import com.example.domain.models.hotel.HotelInfoDomain
import com.google.gson.annotations.SerializedName

data class HotelInfoData(
    @SerializedName("id")
    override val id: Int = 0,
    @SerializedName("name")
    override val name: String = "",
    @SerializedName("adress")
    override val address: String = "",
    @SerializedName("minimal_price")
    override val minimal_price: Int = 0,
    @SerializedName("price_for_it")
    override val price_for_it: String = "",
    @SerializedName("rating")
    override val rating: Int = 0,
    @SerializedName("rating_name")
    override val rating_name: String = "",
    @SerializedName("image_urls")
    override val image_urls: List<String> = listOf(),
    @SerializedName("about_the_hotel")
    override val about_the_hotel: AboutHotelData = AboutHotelData()
) : HotelInfoDomain
