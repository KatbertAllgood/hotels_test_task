package com.example.domain.models.booking

interface BookingDomain {
    val id: Int
    val hotel_name: String
    val hotel_address: String
    val horating: Int
    val rating_name: String
    val departure: String
    val arrival_country: String
    val tour_date_start: String
    val tour_date_stop: String
    val number_of_nights: Int
    val room: String
    val nutrition: String
    val tour_price: Int
    val fuel_charge: Int
    val service_charge: Int
}


//{
//    "id": 1,
//    "hotel_name": "Лучший пятизвездочный отель в Хургаде, Египет",
//    "hotel_adress": "Madinat Makadi, Safaga Road, Makadi Bay, Египет",
//    "horating": 5,
//    "rating_name": "Превосходно",
//    "departure": "Москва",
//    "arrival_country": "Египет, Хургада",
//    "tour_date_start": "19.09.2023",
//    "tour_date_stop": "27.09.2023",
//    "number_of_nights": 7,
//    "room": "Люкс номер с видом на море",
//    "nutrition": "Все включено",
//    "tour_price": 289400,
//    "fuel_charge": 9300,
//    "service_charge": 2150
//}