package com.example.currencyrate.model.nal

data class NalItem(
    val firstName : String,
    val lastName : String,
    val contactDetails : Int,
    val author: String,
    val availableCopies: Int,
    val description: String,
    val genreId: Int,
    val id: Int,
    val publicationYear: Int,
    val readersId: Int,
    val title: String
)