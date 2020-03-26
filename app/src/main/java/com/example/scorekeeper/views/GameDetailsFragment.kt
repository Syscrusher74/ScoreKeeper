package com.example.scorekeeper.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import com.example.scorekeeper.R
import com.example.scorekeeper.viewmodels.GameDetailsViewModel
import com.example.scorekeeper.viewmodels.GamesListViewModel
import kotlinx.android.synthetic.main.fragment_game_details.*
import kotlinx.android.synthetic.main.fragment_game_details.gameName
import kotlinx.android.synthetic.main.item_game.*

/**
 * A simple [Fragment] subclass.
 */
class GameDetailsFragment : Fragment() {

    private var gameUuid = 0
    private lateinit var gameDetailsViewModel: GameDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        gameDetailsViewModel = ViewModelProvider(this).get(GameDetailsViewModel::class.java)
        //deprecated
        //gameDetailsViewModel = ViewModelProviders.of(this).get(GameDetailsViewModel::class.java)
        gameDetailsViewModel.fetch()

        /*arguments?.let {
            gameUuid = GameDetailsFragmentArgs.fromBundle(it).gameUuid
            //textView.text = gameUuid.toString()
        }*/

        observeViewModel()
    }

    private fun observeViewModel() {
        gameDetailsViewModel.gameLiveData.observe(viewLifecycleOwner, Observer { game ->
            game?.let {
                gameName.text = game.name
                gameYear.text = game.year
                gameManufacturer.text = game.manufacturer
                gameScore.text = game.score
                gameDescription.text = game.description
            }
        })
    }
}
