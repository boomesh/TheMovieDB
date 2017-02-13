package com.boomesh.data.api;

import com.boomesh.data.api.GetPopularMovies.PopularMoviePage;

import io.reactivex.Observable;
import retrofit2.http.GET;


/**
 * Interface with The Movie DB API
 * <p>
 * Created by sumesh on 2/12/17.
 */

public interface TheMovieDBService {
    @GET("/movie/popular/")
    Observable<PopularMoviePage> getPopularMovies();
}
