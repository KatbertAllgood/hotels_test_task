package com.example.domain.models.hotel

interface AboutHotelDomain {
    val description: String
    val peculiarities: List<String>
}

//"about_the_hotel": {
//    "description": "Отель VIP-класса с собственными гольф полями. Высокий уровнь сервиса. Рекомендуем для респектабельного отдыха. Отель принимает гостей от 18 лет!",
//    "peculiarities": [
//    "Бесплатный Wifi на всей территории отеля",
//    "1 км до пляжа",
//    "Бесплатный фитнес-клуб",
//    "20 км до аэропорта"
//    ]
//}