package com.example.snackaudiobook.navigation

import java.io.Serializable

data class Book(val name: String , val author: String, val summary: String, val madeby: String) :
    Serializable