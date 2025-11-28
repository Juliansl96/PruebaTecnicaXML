package com.example.pruebatecnicaxml.data.database.posts

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PostsDao {
    @Insert
    suspend fun savePost(posts: Posts)
    @Query("SELECT * FROM posts")
    suspend fun getPostsList(): List<Posts>
}