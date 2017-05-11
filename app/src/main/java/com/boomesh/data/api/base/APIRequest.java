package com.boomesh.data.api.base;

import android.support.annotation.NonNull;

import com.boomesh.data.api.TheMovieDBService;

import io.reactivex.Single;

/**
 * Created by sumesh on 5/9/17.
 */

public interface APIRequest<Response> {
    @NonNull
    Single<Response> buildRequest(TheMovieDBService api);
}
