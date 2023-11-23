package com.example.data.models.rooms

import com.example.domain.models.rooms.AllRoomsDomain
import com.example.domain.models.rooms.RoomDomain

data class AllRoomsData(
    override val rooms: List<RoomData> = listOf()
) : AllRoomsDomain
