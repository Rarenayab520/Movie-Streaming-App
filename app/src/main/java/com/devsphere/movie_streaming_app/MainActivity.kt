package com.devsphere.movie_streaming_app

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.devsphere.movie_streaming_app.adapter.MovieAdapter
import com.devsphere.movie_streaming_app.databinding.ActivityMainBinding
import com.devsphere.movie_streaming_app.viewmodel.MovieViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MovieViewModel by viewModels()
    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        observeMovies()

        viewModel.loadMovies()
    }

    private fun setupRecyclerView() {
        adapter = MovieAdapter()
        binding.rvMovies.layoutManager =
            androidx.recyclerview.widget.LinearLayoutManager(this)

        binding.rvMovies.adapter = adapter
    }

    private fun observeMovies() {
        viewModel.movies.observe(this) { movies ->
            adapter.submitList(movies)
        }
    }
}
