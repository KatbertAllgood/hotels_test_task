package com.example.data.models.rooms

import com.example.domain.models.rooms.RoomDomain
import com.google.gson.annotations.SerializedName

data class RoomData(
    @SerializedName("id")
    override val id: Int = 0,
    @SerializedName("name")
    override val name: String = "",
    @SerializedName("price")
    override val price: Int = 0,
    @SerializedName("price_per")
    override val price_per: String = "",
    @SerializedName("peculiarities")
    override val peculiarities: List<String> = listOf(),
    @SerializedName("image_urls")
    override val image_urls: List<String> = listOf()
) : RoomDomain
