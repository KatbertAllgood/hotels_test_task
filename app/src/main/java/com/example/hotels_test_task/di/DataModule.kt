package com.example.hotels_test_task.di

import com.example.data.repository.NetworkRepositoryImpl
import com.example.domain.repository.NetworkRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideNetworkRepository() : NetworkRepository = NetworkRepositoryImpl()

}