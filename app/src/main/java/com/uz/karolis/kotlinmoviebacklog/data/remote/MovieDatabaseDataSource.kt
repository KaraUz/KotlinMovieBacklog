package com.uz.karolis.kotlinmoviebacklog.data.remote

import javax.inject.Inject

/**
 * Created by Karolis on 2017-12-30.
 */
class MovieDatabaseDataSource @Inject constructor(private val movieDatabaseService: MovieDatabaseService){
    fun requestMovieSearch(movieTitle:String, page:Int = 1) =
            movieDatabaseService.requestSearchMovie(movieTitle, page, MovieDatabaseContract.API_KEY_VALUE)
}