package com.example.pruebatecnicaxml.domain.commentlist

interface CommentListRepository {
    suspend fun getCommentList(idspt: Int): CommentListResult
}