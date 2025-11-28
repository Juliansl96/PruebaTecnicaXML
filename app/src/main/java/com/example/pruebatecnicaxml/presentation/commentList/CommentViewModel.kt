package com.example.pruebatecnicaxml.presentation.commentList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebatecnicaxml.data.database.comments.Comments
import com.example.pruebatecnicaxml.domain.commentlist.CommentListResult
import com.example.pruebatecnicaxml.domain.commentlist.CommentListRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class CommentViewModel(private val commentListRepository: CommentListRepository):
    ViewModel() {
    //los mutableStateFlow son flujos de datos que siempre tienen un valor actual y puede estarse cambiando y cualquier observador se dara cuenta de inmediato
    private val _messageError = MutableStateFlow("")
    var messageError = _messageError

    private val _success = MutableStateFlow<List<Comments>>(listOf())
    var success = _success

    fun getCommentList(idspt: Int){
        viewModelScope.launch {
            when (val response = commentListRepository.getCommentList(idspt)){
                is CommentListResult.Success -> _success.value = response.commentsList
                is CommentListResult.MessageError -> _messageError.value = response.message
            }
        }
    }
}