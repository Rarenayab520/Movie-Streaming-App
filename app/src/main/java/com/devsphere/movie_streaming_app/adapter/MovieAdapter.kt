package com.devsphere.movie_streaming_app.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.devsphere.movie_streaming_app.databinding.ItemMovieBinding
import com.devsphere.movie_streaming_app.model.MovieDto

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var movieList = listOf<MovieDto>()

    fun submitList(list: List<MovieDto>) {
        movieList = list
        notifyDataSetChanged()
    }

    inner class MovieViewHolder(val binding: ItemMovieBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemMovieBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        val movie = movieList[position]

        holder.binding.tvMovieTitle.text = movie.title ?: "No Title"

        val posterUrl =
            "https://archive.org/services/img/${movie.identifier}"

        Glide.with(holder.itemView.context)
            .load(posterUrl)
            .into(holder.binding.ivPoster)
    }

    override fun getItemCount(): Int = movieList.size
}
