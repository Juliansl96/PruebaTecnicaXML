package com.example.pruebatecnicaxml.domain.postslist

interface PostsListRepository {
    suspend fun getPostList(): PostsListResult
}