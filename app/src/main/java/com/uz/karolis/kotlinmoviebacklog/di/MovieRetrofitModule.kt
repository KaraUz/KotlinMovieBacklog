package com.uz.karolis.kotlinmoviebacklog.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.uz.karolis.kotlinmoviebacklog.data.remote.MovieDatabaseContract
import com.uz.karolis.kotlinmoviebacklog.data.remote.MovieDatabaseService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

/**
 * Created by Karolis on 2017-12-29.
 */
@Module(includes = arrayOf(NetworkModule::class))
class MovieRetrofitModule {

    @Provides
    fun provideRetrofit(gson: Gson, okHttpClient:OkHttpClient):Retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(MovieDatabaseContract.BASE_API)
            .client(okHttpClient)
            .build()

    @Provides
    fun provideGson():Gson =  GsonBuilder().create()

    @Provides @Singleton
    fun provideMovieDatabaseService(retrofit: Retrofit):MovieDatabaseService =
            retrofit.create(MovieDatabaseService::class.java)
}