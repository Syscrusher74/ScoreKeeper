package com.example.scorekeeper.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.scorekeeper.data.Game

class GameDetailsViewModel : ViewModel() {

    val gameLiveData = MutableLiveData<Game>()

    fun fetch() {
        val game = Game("Moon Patrol", "1982", "716,000", "Irem", "Good game.", "", "")
        gameLiveData.value = game
    }
}