package com.example.pruebatecnicaxml.domain.postslist

import com.example.pruebatecnicaxml.data.database.local.posts.Posts

interface PostsListRepository {
    //suspend fun getPostList(): PostsListResult
    suspend fun fetchPostsFromApi(): PostsListResult
    suspend fun getLocalPosts(): PostsListResult

}