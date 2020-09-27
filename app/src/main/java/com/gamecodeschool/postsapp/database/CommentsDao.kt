package com.gamecodeschool.postsapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import org.w3c.dom.Comment
import retrofit2.http.Query
@Dao
interface CommentsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertComment(comment: Comment)

    @Query(value: "SELECT * FROM comments")
    fun getComments(): LiveData<List<Comment>>

    @Query(value: "SELECT * FROM comments WHERE postId = postId")
    fun getCommentsByPostId(postId: Int): LiveData<List<Comment>>
}