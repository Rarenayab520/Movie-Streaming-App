package com.devsphere.movie_streaming_app.api

import com.devsphere.movie_streaming_app.model.MetadataResponse
import com.devsphere.movie_streaming_app.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiService {

    @GET("advancedsearch.php")
    suspend fun searchMovies(
        @Query("q") query: String,
        @Query("fl[]") fields: List<String> = listOf("title", "identifier"),
        @Query("rows") rows: Int = 20,
        @Query("page") page: Int = 1,
        @Query("output") output: String = "json"
    ): MovieResponse


    // ✅ NEW API (IMPORTANT)
    @GET("metadata/{identifier}")
    suspend fun getMovieMetadata(
        @Path("identifier") identifier: String
    ): MetadataResponse
}
