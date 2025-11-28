package com.example.pruebatecnicaxml.data.repository

import com.example.pruebatecnicaxml.data.database.posts.PostsDao
import com.example.pruebatecnicaxml.domain.postslist.PostsListResult
import com.example.pruebatecnicaxml.domain.postslist.PostsListRepository

class PostListRepositoryImpl(private val postsDao: PostsDao): PostsListRepository {
    override suspend fun getPostList(): PostsListResult {
        return try {
            val listPosts = postsDao.getPostsList()
            PostsListResult.Success(listPosts)
        } catch (e: Exception) {
            PostsListResult.MessageError(e.toString())
        }
    }
}
