package com.boomesh.data.api.GetTopRatedMovies.request;

import android.support.annotation.NonNull;

import com.boomesh.data.api.TheMovieDBService;
import com.boomesh.data.api.base.APIRequest;
import com.boomesh.data.api.common.models.MoviesPage;

import retrofit2.Call;

/**
 * Fetch the top rated movies from TMDB
 *
 * Created by sumesh on 5/11/17.
 */

public class GetTopRatedMovies implements APIRequest<MoviesPage> {
    @NonNull
    @Override
    public Call<MoviesPage> buildRequest(TheMovieDBService api) {
        return api.getTopRatedMovies();
    }
}
