package com.example.pruebatecnicaxml.domain.commentlist

import com.example.pruebatecnicaxml.data.database.comments.Comments

sealed class CommentListResult {
    data class Success (val commentsList: List<Comments>): CommentListResult()
    data class MessageError (val message: String): CommentListResult()
}
