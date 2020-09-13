package com.gamecodeschool.postsapp.api

import okhttp3.Response
import retrofit2.http.GET
import com.gamecodeschool.postsapp.model.Post as Post

interface ApiInterface {
    @GET("posts")
    fun getPosts(): Response<List<Post>>
}