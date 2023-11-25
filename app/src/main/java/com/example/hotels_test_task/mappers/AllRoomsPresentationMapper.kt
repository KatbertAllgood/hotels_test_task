package com.example.hotels_test_task.mappers

import com.example.domain.models.rooms.AllRoomsDomain
import com.example.domain.models.rooms.RoomDomain
import com.example.hotels_test_task.models.rooms.AllRoomsPresentation
import com.example.hotels_test_task.models.rooms.RoomPresentation

fun RoomDomain.toPresentation() : RoomPresentation = RoomPresentation(
    id, name, price, price_per, peculiarities, image_urls
)

fun AllRoomsDomain.toPresentation() : AllRoomsPresentation = AllRoomsPresentation(
    rooms.map { it.toPresentation() }
)