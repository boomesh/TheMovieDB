package com.boomesh.data.api.GetPopularMovies.request;

import android.support.annotation.NonNull;

import com.boomesh.data.api.API;
import com.boomesh.data.api.GetPopularMovies.models.PopularMoviePage;
import com.boomesh.data.api.TheMovieDBService;
import com.boomesh.data.api.base.APIRequest;

import io.reactivex.Single;

/**
 * Interface to fetch the list of popular movies from the datasource
 * <p>
 * Created by sumesh on 2/19/17.
 */

public class GetPopularMovies implements APIRequest<PopularMoviePage> {

    @NonNull
    @Override
    public Single<PopularMoviePage> buildRequest(TheMovieDBService api) {
        return api.getPopularMovies();
    }
}

