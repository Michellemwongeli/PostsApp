package com.gamecodeschool.postsapp.`view model`

import androidx.lifecycle.MutableLiveData
import com.gamecodeschool.postsapp.Repository.CommentsRepository
import com.gamecodeschool.postsapp.model.Comments
import org.w3c.dom.Comment
import java.sql.RowId

class CommentsViewModel (val commentsRepository: CommentsRepository): viewModel(){
    var commentsLiveData = MutableLiveData<List<Comment>>()

    fun getComments(postId: Int){
        viewModelScope.launch { this: CoroutineScope
        val (response.isSuccessful){
                commentsLiveData.postValue(response.body() as list<Comments)

            }
            else{
                commentsFailedLiveData.postValue(response()?.string)

            }
        }

    }
    fun getDbComments(){

    }
}
