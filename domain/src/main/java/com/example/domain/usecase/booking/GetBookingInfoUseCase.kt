package com.example.domain.usecase.booking

import com.example.domain.repository.NetworkRepository

class GetBookingInfoUseCase(
    private val networkRepository: NetworkRepository
) {
    operator fun invoke() = networkRepository.getBookingInfo()
}