package com.uz.karolis.kotlinmoviebacklog.di

import android.app.Application

/**
 * Created by Karolis on 2017-12-28.
 */
class MovieBacklogApplication:Application() {
    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        initializeDagger()
    }

    fun initializeDagger() {
        appComponent = DaggerAppComponent.builder()
                .contextModule(ContextModule(this))
                .build()
    }
}