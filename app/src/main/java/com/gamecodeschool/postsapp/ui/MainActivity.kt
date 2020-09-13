package com.gamecodeschool.postsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.gamecodeschool.postsapp.R
import com.gamecodeschool.postsapp.Repository.PostsRepository
import com.gamecodeschool.postsapp.`view model`.PostsViewModelFactory
import com.gamecodeschool.postsapp.`view model`.postsViewModel

class MainActivity : AppCompatActivity() {
    private var postsViewModelFactory: PostsViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val postsRepository = PostsRepository()
        postsViewModelFactory = PostsViewModelFactory(postsRepository)
        postsViewModel =
            ViewModelProvider(owner:this, postViewModelFactory).get(PostsViewModel::class.java)
        postsViewModel.getPosts()
        postsViewModel.postsLiveData.observer(owner: this, observer{ postsList->
            //recycler view
            Toast.makeText(baseContext,text : "${postsList.size} posts fetched", Toast.LENGTH_LONG).show()
        })
        postsViewModel.postsFailedLiveData.observer(owner: this, observer{ error->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
        })
}