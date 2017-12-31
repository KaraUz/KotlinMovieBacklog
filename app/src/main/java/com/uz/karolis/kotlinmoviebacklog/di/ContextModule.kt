package com.uz.karolis.kotlinmoviebacklog.di

import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * Created by Karolis on 2017-12-29.
 */
@Module
class ContextModule(val context:Context) {

    @Provides
    fun provideContext():Context = context
}