package com.uz.karolis.kotlinmoviebacklog.view.BackloggedMoviesFragment

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.uz.karolis.kotlinmoviebacklog.data.repository.BackloggedMovieRepository
import com.uz.karolis.kotlinmoviebacklog.di.MovieBacklogApplication
import com.uz.karolis.kotlinmoviebacklog.domain.Movie
import javax.inject.Inject

/**
 * Created by Karolis on 2017-12-27.
 */
class BackloggedMovieViewModel
    @Inject constructor(backloggedMovieRepository: BackloggedMovieRepository):
        ViewModel(){

    val backloggedMovies = MutableLiveData<List<Movie>>()

    init {
        backloggedMovies.value = backloggedMovieRepository.getBackloggedMovies()
    }
}