package com.gamecodeschool.postsapp.`view model`

import android.app.Application
import android.content.Context
import com.facebook.stetho.Stetho

class PostsApp: Application() {
    override fun onCreate() {
        super.onCreate()
        PostsApp.appContext = applicationContext
        Stetho.initializeWithDefault(baseContext)
    }
    companion object{
        lateinit var appContext: Context
    }
}