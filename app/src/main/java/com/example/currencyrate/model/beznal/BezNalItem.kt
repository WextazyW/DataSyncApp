package com.example.currencyrate.model.beznal

data class BezNalItem(
    val author: String,
    val availableCopies: Int,
    val description: String,
    val genreId: Int,
    val id: Int,
    val publicationYear: Int,
    val readersId: Int,
    val title: String
)