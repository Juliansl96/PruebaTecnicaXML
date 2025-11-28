package com.example.pruebatecnicaxml.data.database.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pruebatecnicaxml.data.database.local.comments.Comments
import com.example.pruebatecnicaxml.data.database.local.comments.CommentsDao
import com.example.pruebatecnicaxml.data.database.local.posts.Posts
import com.example.pruebatecnicaxml.data.database.local.posts.PostsDao

@Database(entities = [Posts::class, Comments::class], version = 1)
abstract class AppDataBase : RoomDatabase(){
    abstract fun postsDao(): PostsDao
    abstract fun commentsDao(): CommentsDao
}