package com.uz.karolis.kotlinmoviebacklog.di

import com.squareup.picasso.Picasso
import com.uz.karolis.kotlinmoviebacklog.view.BackloggedMoviesFragment.BackloggedMovieFragment
import com.uz.karolis.kotlinmoviebacklog.view.BackloggedMoviesFragment.BackloggedMovieViewModel
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by Karolis on 2017-12-28.
 */
@Component(modules = arrayOf(
        BackloggedMovieRepositoryModule::class,
        PicassoModule::class))
@Singleton
interface AppComponent {
    fun inject(backloggedMovieViewModel: BackloggedMovieViewModel)

    fun getPicasso(): Picasso
}
