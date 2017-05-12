package com.boomesh.data.api;

import com.boomesh.data.api.common.models.MoviesPage;

import javax.inject.Singleton;

import io.reactivex.Single;
import retrofit2.http.GET;


/**
 * Interface with The Movie DB API
 * <p>
 * Created by sumesh on 2/12/17.
 */

@Singleton
public interface TheMovieDBService {
    @GET("movie/popular")
    Single<MoviesPage> getPopularMovies();

    @GET("/movie/top_rated")
    Single<MoviesPage> getTopRatedMovies();
}
