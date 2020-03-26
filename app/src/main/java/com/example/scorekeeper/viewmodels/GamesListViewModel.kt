package com.example.scorekeeper.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.scorekeeper.data.Game

class GamesListViewModel: ViewModel() {

    val games = MutableLiveData<List<Game>>()
    val gamesLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh() {
        val game1 = Game("Donkey Kong", "1982", "1,012,300", "Nintendo", "Fuck this game.", "", "")
        val game2 = Game("Millipede", "1982", "444,999", "Nintendo", "Fuck this game.", "", "")
        val game3 = Game("Moon Patrol", "1982", "200,878", "Nintendo", "Fuck this game.", "", "")
        val gameList = arrayListOf<Game>(game1, game2, game3)

        games.value = gameList
        gamesLoadError.value = false
        loading.value = false
    }
}