package com.gamecodeschool.postsapp.`view model`

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gamecodeschool.postsapp.Repository.PostsRepository
import com.gamecodeschool.postsapp.model.Post
import kotlinx.coroutines.launch

private val Any.coroutineScope: Unit
    get() {}

class postsViewModel(val postsRepository:PostsRepository): ViewModel(){
    var postsLiveData= MutableLiveData<List<Post>>()
    var postsFailedLiveData =MutableLiveData<String>()

    fun getPosts(){
        viewModelScope.launch{ this.coroutineScope
        val response = postsRepository.getPosts()
        if(response.isSuccessful){
            postsLiveData.postValue(response.body())
        }
            else{
            postsFailedLiveData.postValue(response.body()?.string())
        }
        }

    }
    fun getDbPosts(){
        postsLiveData = postsRepository.getDbPosts()

    }
}