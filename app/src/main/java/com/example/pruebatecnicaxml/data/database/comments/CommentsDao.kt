package com.example.pruebatecnicaxml.data.database.comments

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CommentsDao {
    @Query("SELECT * FROM COMMENTS WHERE idPost=:idpst")
    suspend fun getCommentsList(idpst: Int):List<Comments>
    @Insert
    suspend fun saveComment(comments: Comments)
}