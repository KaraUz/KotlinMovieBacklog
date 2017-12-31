package com.uz.karolis.kotlinmoviebacklog.data.repository

import android.util.Log
import com.uz.karolis.kotlinmoviebacklog.data.remote.MovieDatabaseDataSource
import com.uz.karolis.kotlinmoviebacklog.domain.Movie
import io.reactivex.Observable
import io.reactivex.Observable.just
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Karolis on 2017-12-28.
 */
class MockBackloggedMovieRepository
@Inject constructor(private val movieDatabaseDataSource: MovieDatabaseDataSource):
        BackloggedMovieRepository {
    override fun getBackloggedMovies(): List<Movie> {
        return ArrayList<Movie>().apply {
            //for (i in 1..15)
            //    this.add(Movie("Terminator " + i, "Action", "0", "movie", "N/A"))

            movieDatabaseDataSource.requestMovieSearch("Terminator")
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            { movieDatabaseResponse ->
                                if (movieDatabaseResponse.isSuccess) {
                                    this.addAll(movieDatabaseResponse.movies)
                                }
                            },
                            { t: Throwable? ->
                                Log.e("MockBackloggedMovieRepo",
                                        "Failed to retrieve movies from movie DB!\n" + t?.printStackTrace())
                            }
                    )
        }
    }
}
