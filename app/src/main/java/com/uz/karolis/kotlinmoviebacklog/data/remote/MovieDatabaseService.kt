package com.uz.karolis.kotlinmoviebacklog.data.remote

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Karolis on 2017-12-30.
 */
interface MovieDatabaseService {
    @GET(".")
    fun requestSearchMovie(
            @Query(MovieDatabaseContract.SEARCH_TITLE) searchedTitle: String,
            @Query(MovieDatabaseContract.PAGE) page:Int,
            @Query(MovieDatabaseContract.API_KEY) apiKey:String
    ): Observable<MovieDatabaseResponse>
}