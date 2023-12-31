package com.example.domain.models.hotel

interface HotelInfoDomain {
    val id: Int
    val name: String
    val address: String
    val minimal_price: Int
    val price_for_it: String
    val rating: Int
    val rating_name: String
    val image_urls: List<String>
    val about_the_hotel: AboutHotelDomain
}



//{
//    "id": 1,
//    "name": "Лучший пятизвездочный отель в Хургаде, Египет",
//    "adress": "Madinat Makadi, Safaga Road, Makadi Bay, Египет",
//    "minimal_price": 134268,
//    "price_for_it": "За тур с перелётом",
//    "rating": 5,
//    "rating_name": "Превосходно",
//    "image_urls": [
//    "https://www.atorus.ru/sites/default/files/upload/image/News/56149/Club_Priv%C3%A9_by_Belek_Club_House.jpg",
//    "https://deluxe.voyage/useruploads/articles/The_Makadi_Spa_Hotel_02.jpg",
//    "https://deluxe.voyage/useruploads/articles/article_1eb0a64d00.jpg"
//    ],
//    "about_the_hotel": {
//    "description": "Отель VIP-класса с собственными гольф полями. Высокий уровнь сервиса. Рекомендуем для респектабельного отдыха. Отель принимает гостей от 18 лет!",
//    "peculiarities": [
//    "Бесплатный Wifi на всей территории отеля",
//    "1 км до пляжа",
//    "Бесплатный фитнес-клуб",
//    "20 км до аэропорта"
//    ]
//}
//}