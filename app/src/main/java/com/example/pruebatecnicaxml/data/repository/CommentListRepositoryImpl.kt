package com.example.pruebatecnicaxml.data.repository

import com.example.pruebatecnicaxml.data.database.local.comments.CommentsDao
import com.example.pruebatecnicaxml.domain.commentlist.CommentListRepository
import com.example.pruebatecnicaxml.domain.commentlist.CommentListResult

class CommentListRepositoryImpl(private val commentsDao: CommentsDao):CommentListRepository{

    override suspend fun getCommentList(idspt:Int): CommentListResult {
        return try {
            val listComments = commentsDao.getCommentsList(idspt)
            CommentListResult.Success(listComments)
        } catch (e: Exception) {
            CommentListResult.MessageError(e.toString())
        }
    }
}