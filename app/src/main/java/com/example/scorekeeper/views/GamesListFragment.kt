package com.example.scorekeeper.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.scorekeeper.R
import com.example.scorekeeper.adapters.GameListAdapter
import com.example.scorekeeper.viewmodels.GamesListViewModel
import kotlinx.android.synthetic.main.fragment_games_list.*

/**
 * A simple [Fragment] subclass.
 */
class GamesListFragment : Fragment() {

    private lateinit var viewModel: GamesListViewModel
    private val gameListAdapter =
        GameListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_games_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(GamesListViewModel::class.java)
        viewModel.refresh()

        gamesListRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = gameListAdapter
        }

        observeViewModel()
    }

    //change viewLifecycleOwner back to "this"?
    fun observeViewModel() {
        viewModel.games.observe(viewLifecycleOwner, Observer { games ->
            games?.let {
                gamesListRecyclerView.visibility = View.VISIBLE
                gameListAdapter.updateGameList(games)
            }
        })

        viewModel.gamesLoadError.observe(viewLifecycleOwner, Observer {isError ->
            isError?.let {
                gamesListError.visibility = if(it) View.VISIBLE else View.GONE
            }
        })

        viewModel.loading.observe(viewLifecycleOwner, Observer {isLoading ->
            isLoading?.let {
                gamesListLoadingView.visibility = if(it) View.VISIBLE else View.GONE
                if(it) {
                    gamesListError.visibility = View.GONE
                    gamesListRecyclerView.visibility = View.GONE
                }
            }
        })
    }

}
