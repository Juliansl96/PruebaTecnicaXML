package com.example.pruebatecnicaxml.data.database.local.posts

import android.util.Log
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PostsDao {
    @Insert
    suspend fun insertAll(posts:List<Posts>)
    @Query("SELECT * FROM posts")
    suspend fun getPostsList(): List<Posts>
}