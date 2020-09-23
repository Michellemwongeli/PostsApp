package com.gamecodeschool.postsapp.Repository

import androidx.lifecycle.LiveData
import com.gamecodeschool.postsapp.`view model`.PostsApp
import com.gamecodeschool.postsapp.api.ApiClient
import com.gamecodeschool.postsapp.api.ApiInterface
import com.gamecodeschool.postsapp.database.PostAppDatabase
import com.gamecodeschool.postsapp.model.Post
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import okhttp3.Response

class PostsRepository {
    suspend fun getPosts() = withContext(Dispatchers.IO){ val coroutineScope =
        //this; CoroutineScope
    val apiInterface = ApiInterface.buildService(ApiInterface ::class.java)
    val response = apiInterface.getPosts()
        if(response.isSuccessful){
            val posts = response.body() as List<Post>
            savePosts(Posts)
        }
    return@withContext response
    }
    suspend fun  savePosts(postsList: List<Post>) = withContext()Dis
            val database = PostAppDatabase.getDbInstance(PostsApp.appContext)
            postsList.forEach { post ->
    database.postDao().insertPost(post)
    }
}

fun getPosts(): LiveData<List<Posts>> {
    val database = PostAppDatabase.getDbInstance(PostsApp.appContext)
    return database.postDao().getPosts()
}

}
