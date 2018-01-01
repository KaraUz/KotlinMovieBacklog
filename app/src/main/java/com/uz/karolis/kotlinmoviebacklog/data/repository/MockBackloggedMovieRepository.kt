package com.uz.karolis.kotlinmoviebacklog.data.repository

import com.uz.karolis.kotlinmoviebacklog.data.remote.MovieDatabaseDataSource
import com.uz.karolis.kotlinmoviebacklog.domain.Movie
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Karolis on 2017-12-28.
 */
class MockBackloggedMovieRepository
@Inject constructor(private val movieDatabaseDataSource: MovieDatabaseDataSource):
        BackloggedMovieRepository {

    override fun getBackloggedMovies(): Observable<List<Movie>> {
        return movieDatabaseDataSource.requestMovieSearch("Terminator")
                .map { movieDatabaseResponse -> movieDatabaseResponse.movies }
                .observeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
    }
}
