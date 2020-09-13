package com.gamecodeschool.postsapp.Repository

import com.gamecodeschool.postsapp.api.ApiClient
import com.gamecodeschool.postsapp.api.ApiInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import okhttp3.Response

class PostsRepository {
    suspend fun getPosts() = withContext(Dispatchers.IO){ val coroutineScope =
        //this; CoroutineScope
    val apiInterface = ApiInterface.buildService(ApiInterface ::class.java)
    val response = apiInterface.getPosts()
    return@withContext response
    }
}

class Posts {

}
