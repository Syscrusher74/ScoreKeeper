package com.example.scorekeeper.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.scorekeeper.R
import com.example.scorekeeper.data.Game
import kotlinx.android.synthetic.main.item_game.view.*

class GameListAdapter(val gameList: ArrayList<Game>): RecyclerView.Adapter<GameListAdapter.GameViewHolder>() {

    class GameViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    fun updateGameList(newGameList: List<Game>) {
        gameList.clear()
        gameList.addAll(newGameList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_game, parent, false)
        return GameViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return gameList.size
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.view.gameName.text = gameList[position].name
        holder.view.gameScore.text = gameList[position].score
    }


}