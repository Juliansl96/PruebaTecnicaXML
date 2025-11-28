package com.example.pruebatecnicaxml.data.database.remote
import retrofit2.http.GET

interface PostApi {
    @GET("posts")
    suspend fun getPosts(): List<PostDto>
}