package com.example.pruebatecnicaxml.presentation

import android.app.Application
import com.example.pruebatecnicaxml.data.di.dataBaseModule
import com.example.pruebatecnicaxml.data.di.networkModule
import com.example.pruebatecnicaxml.data.di.repositoryModule
import com.example.pruebatecnicaxml.data.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ApplicationApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{

            androidLogger()

            androidContext(this@ApplicationApp)
            // Load modules
            modules(listOf(
                dataBaseModule,
                viewModelModule,
                repositoryModule,
                networkModule)
            )
        }
    }
}