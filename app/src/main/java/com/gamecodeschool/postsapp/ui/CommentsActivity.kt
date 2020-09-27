package com.gamecodeschool.postsapp.ui

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.widget.Toast
import androidx.core.R
import androidx.lifecycle.Observer
import com.gamecodeschool.postsapp.Repository.CommentsRepository
import com.gamecodeschool.postsapp.Repository.PostsRepository
import com.gamecodeschool.postsapp.`view model`.CommentsViewModel
import com.gamecodeschool.postsapp.`view model`.PostsViewModelFactory
import com.gamecodeschool.postsapp.`view model`.postsViewModel
import com.gamecodeschool.postsapp.model.CommentsViewModelFactory
import kotlinx.android.synthetic.main.adapter.view.*

class CommentsActivity {
    lateinit var postsViewModel: postsViewModel
    lateinit var postsViewModelFactory: PostsViewModelFactory
    lateinit var commentsViewModel: CommentsViewModel
    lateinit var commentsViewModelFactory: CommentsViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comments)

        postId = intent.getIntExtra( name: "POST_ID", defaultValue; 0)
        postsViewModelFactory = postsViewModelFactory(PostsRepository())
        postsViewModel =
            viewModelProvider(this, postsViewModelFactory).get(postsViewModel::class.java)
        postsViewModel.getPostsById(postId)

        commentsViewModelFactory = commentsViewModelFactory(CommentsRepository())
        commentsViewModel = viewModelProvider( this, commentsViewModelFactory).get(CommentsViewModel::class.java)

}
    override fun onResume() {
        super.onResume()
        postsViewModel.postsByIdLiveData.observe(this, observe {
            tvTitle.text = post.title
            tvBody.text = post.body
        })
        commentsViewModel.postByIdLiveData.observe(this, { post ->
            tvTitle.text = post.tvTitle
            tvBody.text = post.body
        })
        commentsViewModel.commentsLiveData.observe(this, Observer { commentsList ->
            //Toast.makeText(baseContext, "${commentsList} comments fetched", Toast.LENGTH_SHORT).show()
             val commentsAdapter =  CommentsAdapter(commentsList)
            rvComments.layoutManager =linearLayoutManager(this)
            rvComments.adapter = commentsAdapter


        })
        commentsViewModel.commentsFailedLiveData.observe( this, { errorMessage ->
            Toast.makeText(baseContext, errorMessage, Toast.LENGTH_SHORT).show()

        })

    }
    fun isConnected(): Boolean {
        val connectivityManager =
            baseContext.getSystemsService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager
        if(networkInfo !=null && networkInfo) {
                return true

            return false
            }
    }
}