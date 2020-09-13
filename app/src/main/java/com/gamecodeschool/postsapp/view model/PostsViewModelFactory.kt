package com.gamecodeschool.postsapp.`view model`

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gamecodeschool.postsapp.Repository.PostsRepository
import com.gamecodeschool.postsapp.model.Post
import java.lang.IllegalArgumentException

class PostsViewModelFactory (val postsRepository: PostsRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(PostsViewModelFactory::class.java)){
            return PostsViewModelFactory(postsRepository) as T
        }
        throw IllegalArgumentException("Unknown viewmodel class")
    }

}
