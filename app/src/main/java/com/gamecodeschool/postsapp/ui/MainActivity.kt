package com.gamecodeschool.postsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.gamecodeschool.postsapp.R
import com.gamecodeschool.postsapp.Repository.PostsRepository
import com.gamecodeschool.postsapp.`view model`.PostsViewModelFactory
import com.gamecodeschool.postsapp.`view model`.postsViewModel

class MainActivity : AppCompatActivity() {
    lateinit var postsViewModel: postsViewModel
    lateinit var postsViewModelFactory: PostsViewModelFactory
}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        postId = intent.getIntExtra( name: "POST_ID", defaultValue: 0)


        postsViewModelFactory = PostsViewModelFactory(postsRepository)
        postsViewModel =
            ViewModelProvider(owner:this, postViewModelFactory).get(PostsViewModel::class.java)
        postsViewModel.getPosts(postId)

            }

        override fun onResume(){
            super.onResume()
        postsViewModel.postsFailedLiveData.observer(owner: this, observer{
                    tvTitle.text = post.title
                tvBody.text = post.body
          //  Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
        })
}
}