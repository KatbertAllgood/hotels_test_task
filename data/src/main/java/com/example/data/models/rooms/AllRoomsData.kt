package com.example.data.models.rooms

import com.example.domain.models.rooms.AllRoomsDomain
import com.example.domain.models.rooms.RoomDomain
import com.google.gson.annotations.SerializedName

data class AllRoomsData(
    @SerializedName("rooms")
    override val rooms: List<RoomData> = listOf()
) : AllRoomsDomain
