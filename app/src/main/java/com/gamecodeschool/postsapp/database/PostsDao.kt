package com.gamecodeschool.postsapp.database

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.gamecodeschool.postsapp.model.Post
import retrofit2.http.Query

interface PostsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPost(post: Post)

@Query( value = "SELECT * FROM posts")
fun getPosts(): LiveData<List<Post>>
}