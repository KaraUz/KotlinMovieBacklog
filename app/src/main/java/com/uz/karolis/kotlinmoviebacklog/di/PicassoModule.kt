package com.uz.karolis.kotlinmoviebacklog.di

import android.content.Context
import com.jakewharton.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient

/**
 * Created by Karolis on 2017-12-29.
 */
@Module(includes = arrayOf(NetworkModule::class, ContextModule::class))
class PicassoModule {
    @Provides
    fun providePicasso(okHttpClient:OkHttpClient, context:Context) =
            Picasso.Builder(context)
            .downloader(OkHttp3Downloader(okHttpClient))
            .build()
}