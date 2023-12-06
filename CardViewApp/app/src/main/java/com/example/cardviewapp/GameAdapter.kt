package com.example.cardviewapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class GameAdapter(val gamesList:ArrayList<GameModel>) : RecyclerView.Adapter<GameAdapter.GameViewHolder>(){

    inner class GameViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        lateinit var gameTitle: TextView
        lateinit var gameImg: ImageView

        init {
            gameImg=itemView.findViewById(R.id.image_view)
            gameTitle=itemView.findViewById(R.id.text_view)

            itemView.setOnClickListener(){
                Toast.makeText(itemView.context,"You choose: "+gameTitle.text,Toast.LENGTH_SHORT).show()
            }
        }
    }

    // This will create the views using layout inflater
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.card_tile,parent,false)
        return  GameViewHolder(v)
    }

    override fun getItemCount(): Int {
        return gamesList.size
    }

    // This will bind data to the view
    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
       holder.gameTitle.setText(gamesList[position].text)
        holder.gameImg.setImageResource(gamesList[position].imgCard)
    }
}