package com.example.architecture.repo

import retrofit2.http.GET

interface Api {
    @GET("posts")
    suspend fun getPosts() : MutableList<String>
}