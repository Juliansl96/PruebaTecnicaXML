package com.example.pruebatecnicaxml.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pruebatecnicaxml.data.database.comments.Comments
import com.example.pruebatecnicaxml.data.database.comments.CommentsDao
import com.example.pruebatecnicaxml.data.database.posts.Posts
import com.example.pruebatecnicaxml.data.database.posts.PostsDao

@Database(entities = [Posts::class, Comments::class], version = 1)
abstract class AppDataBase : RoomDatabase(){
    abstract fun postsDao(): PostsDao
    abstract fun commentsDao(): CommentsDao
}