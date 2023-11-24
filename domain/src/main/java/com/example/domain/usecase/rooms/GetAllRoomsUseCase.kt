package com.example.domain.usecase.rooms

import com.example.domain.repository.NetworkRepository

class GetAllRoomsUseCase(
    private val networkRepository: NetworkRepository
) {
    operator fun invoke() = networkRepository.getAllRooms()
}