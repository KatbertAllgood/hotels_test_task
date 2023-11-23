package com.example.hotels_test_task.models.rooms

import com.example.domain.models.rooms.AllRoomsDomain

data class AllRoomsPresentation(
    override val rooms: List<RoomPresentation> = listOf()
) : AllRoomsDomain