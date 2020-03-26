package com.example.scorekeeper.data

import io.reactivex.Single
import retrofit2.http.GET

interface GamesApi {
    @GET("")
    fun getGames(): Single<List<Game>>

}