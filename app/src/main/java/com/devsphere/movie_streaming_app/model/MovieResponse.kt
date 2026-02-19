package com.devsphere.movie_streaming_app.model

data class MovieResponse(
    val response: ResponseData
)

data class ResponseData(
    val docs: List<MovieDto>
)

data class MovieDto(
    val title: String?,
    val identifier: String?
)
