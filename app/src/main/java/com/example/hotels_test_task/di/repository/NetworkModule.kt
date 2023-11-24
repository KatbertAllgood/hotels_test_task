package com.example.hotels_test_task.di.repository

import com.example.domain.repository.NetworkRepository
import com.example.domain.usecase.booking.GetBookingInfoUseCase
import com.example.domain.usecase.hotel.GetHotelInfoUseCase
import com.example.domain.usecase.rooms.GetAllRoomsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class NetworkModule {

    @Provides
    fun providesGetHotelInfoUseCase(networkRepository: NetworkRepository) =
        GetHotelInfoUseCase(networkRepository)

    @Provides
    fun providesGetBookingInfoUseCase(networkRepository: NetworkRepository) =
        GetBookingInfoUseCase(networkRepository)

    @Provides
    fun providesGetAllRoomsUseCase(networkRepository: NetworkRepository) =
        GetAllRoomsUseCase(networkRepository)
}