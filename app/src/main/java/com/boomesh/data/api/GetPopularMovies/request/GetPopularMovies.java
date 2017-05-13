package com.boomesh.data.api.GetPopularMovies.request;

import android.support.annotation.NonNull;

import com.boomesh.data.api.TheMovieDBService;
import com.boomesh.data.api.base.APIRequest;
import com.boomesh.data.api.common.models.MoviesPage;

import retrofit2.Call;

/**
 * Interface to fetch the list of popular movies from the datasource
 * <p>
 * Created by sumesh on 2/19/17.
 */

public class GetPopularMovies implements APIRequest<MoviesPage> {

    @NonNull
    @Override
    public Call<MoviesPage> buildRequest(TheMovieDBService api) {
        return api.getPopularMovies();
    }
}

