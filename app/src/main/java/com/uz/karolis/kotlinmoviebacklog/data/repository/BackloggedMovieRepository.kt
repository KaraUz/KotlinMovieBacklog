package com.uz.karolis.kotlinmoviebacklog.data.repository

import com.uz.karolis.kotlinmoviebacklog.domain.Movie
import io.reactivex.Observable

/**
 * Created by Karolis on 2017-12-28.
 */
interface BackloggedMovieRepository {
    fun getBackloggedMovies():Observable<List<Movie>>
}