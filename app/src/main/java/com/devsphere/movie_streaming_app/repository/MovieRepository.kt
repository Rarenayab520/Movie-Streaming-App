package com.devsphere.movie_streaming_app.repository

import com.devsphere.movie_streaming_app.api.RetrofitClient
import com.devsphere.movie_streaming_app.model.MovieDto

class MovieRepository {

    suspend fun fetchMovies(): List<MovieDto> {

        val response = RetrofitClient.api.searchMovies(
            query = "mediatype:(movies) AND format:(MP4)"
        )

        return response.response.docs
    }

    // ✅ NEW FUNCTION
    suspend fun getVideoUrl(identifier: String): String? {

        val metadata = RetrofitClient.api.getMovieMetadata(identifier)

        val mp4File = metadata.files.find {
            it.name?.endsWith(".mp4") == true
        }

        return mp4File?.let {
            "https://archive.org/download/$identifier/${it.name}"
        }
    }
}
