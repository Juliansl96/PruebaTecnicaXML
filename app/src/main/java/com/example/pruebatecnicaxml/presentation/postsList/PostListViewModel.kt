package com.example.pruebatecnicaxml.presentation.postsList

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebatecnicaxml.data.database.local.posts.Posts
import com.example.pruebatecnicaxml.data.database.remote.PostApi
import com.example.pruebatecnicaxml.domain.postslist.PostsListResult
import com.example.pruebatecnicaxml.domain.postslist.PostsListRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.math.log

class PostListViewModel(private val postListRepository: PostsListRepository): ViewModel() {
    //los mutableStateFlow son flujos de datos que siempre tienen un valor actual y puede estarse cambiando y cualquier observador se dara cuenta de inmediato

    private val _posts = MutableStateFlow<PostsListResult>(PostsListResult.Loading)
    val posts: StateFlow<PostsListResult> = _posts

    fun loadPosts() {
        viewModelScope.launch {
            postListRepository.fetchPostsFromApi()
            _posts.value = postListRepository.getLocalPosts()
        }
    }
}