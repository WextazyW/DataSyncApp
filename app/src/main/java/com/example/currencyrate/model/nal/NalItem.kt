package com.example.currencyrate.model.nal

data class NalItem(
    val author: String,
    val availableCopies: Int,
    val description: String,
    val genre_id: Int,
    val id: Int,
    val publicationYear: Int,
    val readers_id: Int,
    val title: String
)