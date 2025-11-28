package com.example.pruebatecnicaxml.domain.commentlist

import com.example.pruebatecnicaxml.data.database.comments.Comments

interface CommentListRepository {
    suspend fun getCommentList(idspt: Int): CommentListResult
}