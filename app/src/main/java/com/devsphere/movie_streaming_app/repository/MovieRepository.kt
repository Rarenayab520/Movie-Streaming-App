package com.devsphere.movie_streaming_app.repository

import com.devsphere.movie_streaming_app.api.RetrofitClient
import com.devsphere.movie_streaming_app.model.MovieDto

class MovieRepository {

    suspend fun fetchMovies(): List<MovieDto> {

        val response = RetrofitClient.api.searchMovies(
            query = "mediatype:(movies)"
        )

        return response.response.docs
    }
}
