package com.example.data.mappers

import com.example.data.models.rooms.AllRoomsData
import com.example.data.models.rooms.RoomData
import com.example.domain.models.rooms.AllRoomsDomain
import com.example.domain.models.rooms.RoomDomain

fun RoomDomain.toData() : RoomData = RoomData(
    id, name, price, price_per, peculiarities, image_urls
)

fun AllRoomsDomain.toData() : AllRoomsData = AllRoomsData(
    rooms.map { it.toData() }
)