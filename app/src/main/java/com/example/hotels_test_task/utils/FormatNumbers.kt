package com.example.hotels_test_task.utils

fun formatNumberWithSpaces(number: Int): String {
    return String.format("%,d", number).replace(',', ' ')
}