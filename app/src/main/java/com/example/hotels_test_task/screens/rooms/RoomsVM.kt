package com.example.hotels_test_task.screens.rooms

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.rooms.GetAllRoomsUseCase
import com.example.hotels_test_task.mappers.toPresentation
import com.example.hotels_test_task.models.rooms.AllRoomsPresentation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoomsVM @Inject constructor(
    private val getAllRoomsUseCase: GetAllRoomsUseCase
) : ViewModel() {

    private val TAG = RoomsVM::class.simpleName

    private var allRoomsLiveData = MutableLiveData<AllRoomsPresentation>()
    val getAllRooms: LiveData<AllRoomsPresentation>
        get() = allRoomsLiveData

    init {
        getAllRooms()
    }

    private fun getAllRooms() {
        viewModelScope.launch {
            getAllRoomsUseCase().flowOn(Dispatchers.IO).catch {
                Log.d(TAG, it.message.toString())
            }.map {
                it.toPresentation()
            }.collect {
                allRoomsLiveData.postValue(it)
            }
        }
    }
}