package com.uz.karolis.kotlinmoviebacklog.view.BackloggedMoviesFragment

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.uz.karolis.kotlinmoviebacklog.data.repository.BackloggedMovieRepository
import com.uz.karolis.kotlinmoviebacklog.di.MovieBacklogApplication
import com.uz.karolis.kotlinmoviebacklog.domain.Movie
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Karolis on 2017-12-27.
 */
class BackloggedMovieViewModel: ViewModel(){

    @Inject lateinit var backloggedMovieRepository: BackloggedMovieRepository

    val backloggedMovies = MutableLiveData<List<Movie>>()

    init {
        initializeDagger()
        backloggedMovieRepository.getBackloggedMovies()
               .observeOn(Schedulers.io())
               .subscribeOn(AndroidSchedulers.mainThread())
               .subscribe(
                   {movies -> backloggedMovies.postValue(movies) },
                   {error -> error.printStackTrace()}
               )
    }

    private fun initializeDagger() = MovieBacklogApplication.appComponent.inject(this)


}