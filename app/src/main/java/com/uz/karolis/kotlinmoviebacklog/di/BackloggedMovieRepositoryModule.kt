package com.uz.karolis.kotlinmoviebacklog.di

import com.uz.karolis.kotlinmoviebacklog.data.remote.MovieDatabaseDataSource
import com.uz.karolis.kotlinmoviebacklog.data.repository.BackloggedMovieRepository
import com.uz.karolis.kotlinmoviebacklog.data.repository.MockBackloggedMovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Karolis on 2017-12-28.
 */
@Module(includes = arrayOf(MovieRetrofitModule::class))
class BackloggedMovieRepositoryModule {

    @Provides @Singleton
    fun provideBackloggedMovieRepository(movieDatabaseDataSource: MovieDatabaseDataSource):
            BackloggedMovieRepository = MockBackloggedMovieRepository(movieDatabaseDataSource)
}