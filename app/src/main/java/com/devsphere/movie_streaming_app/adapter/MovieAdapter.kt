package com.devsphere.movie_streaming_app.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.devsphere.movie_streaming_app.PlayerActivity
import com.devsphere.movie_streaming_app.databinding.ItemMovieBinding
import com.devsphere.movie_streaming_app.model.MovieDto
import com.devsphere.movie_streaming_app.repository.MovieRepository
import kotlinx.coroutines.*

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var movieList = listOf<MovieDto>()
    private val repository = MovieRepository()

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
        val context = holder.itemView.context

        holder.binding.tvMovieTitle.text = movie.title ?: "No Title"

        movie.identifier?.let { id ->

            // Poster
            val imageUrl = "https://archive.org/services/img/$id"

            Glide.with(context)
                .load(imageUrl)
                .into(holder.binding.ivPoster)

            // Click
            holder.itemView.setOnClickListener {

                CoroutineScope(Dispatchers.IO).launch {

                    val videoUrl = repository.getVideoUrl(id)

                    videoUrl?.let { url ->

                        withContext(Dispatchers.Main) {

                            val intent = Intent(context, PlayerActivity::class.java)
                            intent.putExtra("video_url", url)
                            context.startActivity(intent)
                        }
                    }
                }
            }
        }
    }

    override fun getItemCount(): Int = movieList.size
}
