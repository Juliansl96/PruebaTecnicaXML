package com.example.pruebatecnicaxml.data.database.comments

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Comments(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,//Valor predeterminado 0 para autogenerar
    val idPost: Int,
    val comment: String
)
