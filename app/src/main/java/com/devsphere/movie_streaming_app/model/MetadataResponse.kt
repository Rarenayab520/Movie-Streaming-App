package com.devsphere.movie_streaming_app.model

data class MetadataResponse(
    val files: List<FileItem>
)

data class FileItem(
    val name: String?,
    val format: String?
)
