package com.gamecodeschool.postsapp.Repository

import androidx.lifecycle.LiveData
import com.gamecodeschool.postsapp.api.ApiClient
import com.gamecodeschool.postsapp.api.ApiInterface
import com.gamecodeschool.postsapp.model.Comments
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class CommentsRepository {
    suspend fun getComments(postId: Int):Response<List<Comment>> = withContext((Dispatcherschers.io))
    val apiInterface = ApiClient.buildService(ApiInterface::class.java)
    val response =apiInterface.getComments( postId
        return@withcontext response
}
suspend fun saveComments() = withContext(Dispatchers.IO){this.CoroutineScope
val data base = PostAppDatabase.getDbInstance(PoatApp.appContext)
val commentDao = database.commentsDao()
 commentsList.forEach{ comment =>
 commentDao.insertComment(comment)
 }
    fun getCommentsByPostId(postId: Int): LiveData<List>Comments>>
    val
}