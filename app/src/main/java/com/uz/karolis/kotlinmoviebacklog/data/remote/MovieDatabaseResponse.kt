package com.uz.karolis.kotlinmoviebacklog.data.remote

import com.google.gson.annotations.SerializedName
import com.uz.karolis.kotlinmoviebacklog.domain.Movie

/**
 * Created by Karolis on 2017-12-30.
 */
data class MovieDatabaseResponse(
        @SerializedName(MovieDatabaseContract.SEARCH) val movies: List<Movie>,
        @SerializedName(MovieDatabaseContract.TOTAL_RESULTS) val totalResults: Int,
        @SerializedName(MovieDatabaseContract.RESPONSE) val isSuccess: Boolean
)