package com.example.domain.usecase.hotel

import com.example.domain.repository.NetworkRepository

class GetHotelInfoUseCase(
    private val networkRepository: NetworkRepository
) {
    operator fun invoke() = networkRepository.getHotelInfo()
}