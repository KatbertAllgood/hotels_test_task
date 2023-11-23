package com.example.data.network

import com.example.data.models.booking.BookingData
import com.example.data.models.hotel.HotelInfoData
import com.example.data.models.rooms.AllRoomsData
import retrofit2.http.GET

interface NetworkApi {


    @GET("d144777c-a67f-4e35-867a-cacc3b827473")
    suspend fun getHotelInfo() : HotelInfoData

    @GET("8b532701-709e-4194-a41c-1a903af00195")
    suspend fun getAllRooms() : AllRoomsData

    @GET("63866c74-d593-432c-af8e-f279d1a8d2ff")
    suspend fun getBookingInfo() : BookingData
}


//interface NetworkApi {
//
//    @GET("offices")
//    suspend fun getAllOffices(): List<BankOfficeResponse>
//
//    @GET("/offices/{officeId}")
//    suspend fun getOfficeById(@Path("officeId") officeId: Long): BankOfficeData
//
//    @POST("/offices/recommended")
//    suspend fun getRecommendedOfficeByParameters(
//        @Body departmentData: DepartmentData
//    ): BankOfficeData
//}