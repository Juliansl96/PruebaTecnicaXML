package com.example.pruebatecnicaxml.data.di

import androidx.room.Room.databaseBuilder
import com.example.pruebatecnicaxml.data.database.local.AppDataBase
import com.example.pruebatecnicaxml.data.database.remote.PostApi
import com.example.pruebatecnicaxml.data.repository.CommentListRepositoryImpl
import com.example.pruebatecnicaxml.data.repository.PostListRepositoryImpl
import com.example.pruebatecnicaxml.domain.commentlist.CommentListRepository
import com.example.pruebatecnicaxml.domain.postslist.PostsListRepository
import com.example.pruebatecnicaxml.presentation.commentList.CommentViewModel
import com.example.pruebatecnicaxml.presentation.postsList.PostListViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataBaseModule = module {
    //con single se inyecta dependencia una sola vez y se puede usar ya en cualquier parte del proyecto
    single {
        databaseBuilder(
            get(),
            AppDataBase::class.java,
            "DBPost"
        ).build()
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
    factory<PostsListRepository> { PostListRepositoryImpl(get(),get()) }
    factory<CommentListRepository> { CommentListRepositoryImpl(get()) }
}
//Modulo para conexion a api
val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PostApi::class.java)
    }
}