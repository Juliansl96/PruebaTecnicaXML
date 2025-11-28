package com.example.pruebatecnicaxml.presentation.postsList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebatecnicaxml.data.database.posts.Posts
import com.example.pruebatecnicaxml.domain.postslist.PostsListResult
import com.example.pruebatecnicaxml.domain.postslist.PostsListRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class PostListViewModel(private val postListRepository: PostsListRepository): ViewModel() {
    //los mutableStateFlow son flujos de datos que siempre tienen un valor actual y puede estarse cambiando y cualquier observador se dara cuenta de inmediato
    private val _messageError = MutableStateFlow("")
    var messageError = _messageError

    private val _success = MutableStateFlow<List<Posts>>(listOf())
    var success = _success

    fun getPostList(){
        viewModelScope.launch {
            when (val response = postListRepository.getPostList()){
                is PostsListResult.Success -> _success.value = response.postList
                is PostsListResult.MessageError -> _messageError.value = response.message
            }
        }
    }

}