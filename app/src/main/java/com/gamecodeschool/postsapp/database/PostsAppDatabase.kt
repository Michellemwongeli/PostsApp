package com.gamecodeschool.postsapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.gamecodeschool.postsapp.model.Post
import org.w3c.dom.Comment
import java.security.AccessControlContext
import kotlin.reflect.KClass
@Database(entities = arrayOf(Post::class, Comment::class), version = 2)
class PostsAppDatabase(entities: Array<KClass<Post>> = arrayOf(Post::class), version 1)
abstract class PostAppDatabase: RoomDatabase(){
    abstract fun postDao(): PostsDao

    companion object{
        private var dbInstance: PostAppDatabase? =null
        fun getDbInstance(context: Context) {} PostAppDatabase{
            if (dbInstance = Room.databaseBuilder(context, PostAppDatabase::class.java, name: "postapp-db").build()

        }
        return dbInstance as PostAppDatabase
    }

}