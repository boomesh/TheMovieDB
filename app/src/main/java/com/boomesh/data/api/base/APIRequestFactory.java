package com.boomesh.data.api.base;

import android.support.annotation.NonNull;

import com.boomesh.data.api.TheMovieDBService;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Class to configure, and build api requests.  Potentially timeouts, server errors can be handled here.
 * <p>
 * Created by sumesh on 5/9/17.
 */

public class APIRequestFactory {
    private final TheMovieDBService api;

    @Inject
    public APIRequestFactory(TheMovieDBService api) {
        this.api = api;
    }

    @NonNull
    public <T> Single<T> make(APIRequest<T> request) {
        return request
                .buildRequest(api)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
