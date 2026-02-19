package com.devsphere.movie_streaming_app.viewmodel

import androidx.lifecycle.*
import com.devsphere.movie_streaming_app.model.MovieDto
import com.devsphere.movie_streaming_app.repository.MovieRepository
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {

    private val repository = MovieRepository()

    private val _movies = MutableLiveData<List<MovieDto>>()
    val movies: LiveData<List<MovieDto>> = _movies

    fun loadMovies() {
        viewModelScope.launch {
            try {
                val movieList = repository.fetchMovies()
                _movies.postValue(movieList)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
