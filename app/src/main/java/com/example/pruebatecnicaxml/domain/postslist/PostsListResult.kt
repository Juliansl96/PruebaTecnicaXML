package com.example.pruebatecnicaxml.domain.postslist

import com.example.pruebatecnicaxml.data.database.posts.Posts

sealed class PostsListResult {
    data class Success (val postList: List<Posts>): PostsListResult()
    data class MessageError (val message: String): PostsListResult()
}