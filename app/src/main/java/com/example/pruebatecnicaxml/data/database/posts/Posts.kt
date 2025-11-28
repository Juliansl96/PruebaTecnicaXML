package com.example.pruebatecnicaxml.data.database.posts

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Posts(
    val userid: Int,
    @PrimaryKey val idPost: Int,
    val title: String,
    val body: String
)
