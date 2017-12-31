package com.uz.karolis.kotlinmoviebacklog.di

import android.util.Log
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

/**
 * Created by Karolis on 2017-12-29.
 */
@Module(includes = arrayOf(ContextModule::class))
class NetworkModule {
    @Provides
    fun provideLoggingInterceptor() =
            HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
                message ->  Log.i("httpLoggingInterceptor", message)
            })


    @Provides
    fun provideHttpClient(loggingInterceptor:HttpLoggingInterceptor) = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
}