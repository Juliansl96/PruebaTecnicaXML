package com.example.pruebatecnicaxml.data.di

import androidx.room.Room.databaseBuilder
import com.example.pruebatecnicaxml.data.database.AppDataBase
import com.example.pruebatecnicaxml.data.repository.CommentListRepositoryImpl
import com.example.pruebatecnicaxml.data.repository.PostListRepositoryImpl
import com.example.pruebatecnicaxml.domain.commentlist.CommentListRepository
import com.example.pruebatecnicaxml.domain.postslist.PostsListRepository
import com.example.pruebatecnicaxml.presentation.commentList.CommentViewModel
import com.example.pruebatecnicaxml.presentation.postsList.PostListViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val dataBaseModule = module {
    //con single se inyecta dependencia una sola vez y se puede usar ya en cualquier parte del proyecto
    single {
        databaseBuilder(
            get(),
            AppDataBase::class.java,
            "DBPost"
        )
    }
    single { get<AppDataBase>().postsDao() }
    single { get<AppDataBase>().commentsDao() }
}

val viewModelModule = module {
    viewModelOf(::PostListViewModel)
    viewModelOf(::CommentViewModel)
}

val repositoryModule = module {
    //con factory mantenemos la instancia solo en la vista y al pasar a otra vista se destruye
    factory<PostsListRepository> { PostListRepositoryImpl(get()) }
    factory<CommentListRepository> { CommentListRepositoryImpl(get()) }
}