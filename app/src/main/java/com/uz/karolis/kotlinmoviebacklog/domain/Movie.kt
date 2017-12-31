package com.uz.karolis.kotlinmoviebacklog.domain

import com.google.gson.annotations.SerializedName

/**
 * Created by Karolis on 2017-12-11.
 */
data class Movie(
        @SerializedName("Title") val title    :String,
        @SerializedName("Year") val year     :String,
        @SerializedName("imdbID") val imdbId   :String,
        @SerializedName("Type") val type     :String,
        @SerializedName("Poster") val posterUrl:String)