package com.example.movieapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.data.model.Movie
import com.example.movieapp.databinding.ListItemBinding

class MovieAdapter():RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {
    val movieList=ArrayList<Movie>()

    fun setList(movies: List<Movie>){
        movieList.clear()
        movieList.addAll(movies)
    }
    class MyViewHolder(val binding:ListItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(movie: Movie){
            binding.descText.text=movie.overview
            binding.titleText.text=movie.title
            val posterUrl="https://image.tmdb.org/t/p/w500"+ movie.posterPath
            Glide.with(binding.imageView.context).load(posterUrl).into(binding.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
     val layoutInflater=LayoutInflater.from(parent.context)
        val binding: ListItemBinding=DataBindingUtil.inflate(layoutInflater, R.layout.list_item,parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return movieList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

}