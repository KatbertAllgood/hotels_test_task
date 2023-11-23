package com.example.hotels_test_task.models.rooms

import com.example.domain.models.rooms.RoomDomain

data class RoomPresentation(
    override val id: Int = 0,
    override val name: String = "",
    override val price: Int = 0,
    override val price_per: String = "",
    override val peculiarities: List<String> = listOf(),
    override val image_urls: List<String> = listOf()
) : RoomDomain