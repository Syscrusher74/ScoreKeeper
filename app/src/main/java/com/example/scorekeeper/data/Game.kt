package com.example.scorekeeper.data

data class Game(
    val name: String,
    val year: String?,
    val score: String?,
    val manufacturer: String?,
    val description: String?,
    val marqueeImageUrl: String?,
    val screenshotImageUrl: String?
)