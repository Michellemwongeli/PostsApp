package com.gamecodeschool.postsapp.database

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.gamecodeschool.postsapp.model.Post
import retrofit2.http.Query

interface PostsDao {


}@Query(value:"SELECT * FROM posts WHERE id = :postId")
        fun getPostById(postId: Int) LiveData<Post>