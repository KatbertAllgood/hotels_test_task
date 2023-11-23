package com.example.data.models.hotel

import com.example.domain.models.hotel.HotelInfoDomain

data class HotelInfoData(
    override val id: Int = 0,
    override val name: String = "",
    override val address: String = "",
    override val minimal_price: Int = 0,
    override val price_for_it: String = "",
    override val rating: Int = 0,
    override val rating_name: String = "",
    override val image_urls: List<String> = listOf(),
    override val about_the_hotel: AboutHotelData = AboutHotelData()
) : HotelInfoDomain
