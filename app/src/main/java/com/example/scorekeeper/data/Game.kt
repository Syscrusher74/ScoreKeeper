package com.example.scorekeeper.data

import com.google.gson.annotations.SerializedName

data class Game(
    @SerializedName("title")
    val name: String,

    @SerializedName("year")
    val year: String?,

    @SerializedName("score")
    val score: String?,

    @SerializedName("manufacturer")
    val manufacturer: String?,

    @SerializedName("description")
    val description: String?,

    @SerializedName("")
    val marqueeImageUrl: String?

    /*@SerializedName("year")
    val screenshotImageUrl: String?*/
)