package com.boomesh.data.api;

import com.boomesh.data.api.common.models.MoviesPage;

import javax.inject.Singleton;

import retrofit2.Call;
import retrofit2.http.GET;


/**
 * Interface with The Movie DB API
 * <p>
 * Created by sumesh on 2/12/17.
 */

@Singleton
public interface TheMovieDBService {
    @GET("movie/popular")
    Call<MoviesPage> getPopularMovies();

    @GET("movie/top_rated")
    Call<MoviesPage> getTopRatedMovies();
}
