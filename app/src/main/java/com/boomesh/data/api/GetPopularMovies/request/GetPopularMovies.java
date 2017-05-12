package com.boomesh.data.api.GetPopularMovies.request;

import android.support.annotation.NonNull;

import com.boomesh.data.api.common.models.MoviesPage;
import com.boomesh.data.api.TheMovieDBService;
import com.boomesh.data.api.base.APIRequest;

import io.reactivex.Single;

/**
 * Interface to fetch the list of popular movies from the datasource
 * <p>
 * Created by sumesh on 2/19/17.
 */

public class GetPopularMovies implements APIRequest<MoviesPage> {

    @NonNull
    @Override
    public Single<MoviesPage> buildRequest(TheMovieDBService api) {
        return api.getPopularMovies();
    }
}

