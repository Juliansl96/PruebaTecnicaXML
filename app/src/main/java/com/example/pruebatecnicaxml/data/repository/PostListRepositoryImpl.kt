package com.example.pruebatecnicaxml.data.repository

import android.util.Log
import com.example.pruebatecnicaxml.data.database.local.posts.Posts
import com.example.pruebatecnicaxml.data.database.local.posts.PostsDao
import com.example.pruebatecnicaxml.data.database.remote.PostApi
import com.example.pruebatecnicaxml.domain.postslist.PostsListRepository
import com.example.pruebatecnicaxml.domain.postslist.PostsListResult
import kotlin.math.log

class PostListRepositoryImpl(
    private val postsDao: PostsDao,
    private val postApi: PostApi) : PostsListRepository {

    override suspend fun fetchPostsFromApi(): PostsListResult =
        try {
        val remote = postApi.getPosts()
        val entities = remote.map { item ->
            Posts(
                item.userId,
                item.idPost,
                item.title,
                item.body)
        }

        postsDao.insertAll(entities)
        PostsListResult.Success(entities)
    } catch (e: Exception) {
        PostsListResult.MessageError(e.toString())
    }

    override suspend fun getLocalPosts(): PostsListResult = try {
        PostsListResult.Success(postsDao.getPostsList())
    } catch (e: Exception) {
        PostsListResult.MessageError(e.toString())
    }
}
