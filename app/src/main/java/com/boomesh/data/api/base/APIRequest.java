package com.boomesh.data.api.base;

import android.support.annotation.NonNull;

import com.boomesh.data.api.TheMovieDBService;

import retrofit2.Call;

/**
 * Subclasses must build the synchronous request.  {@link APIRequestFactory} will perform the request
 * asynchronously.
 *
 * Created by sumesh on 5/9/17.
 */

public interface APIRequest<Body> {
    @NonNull
    Call<Body> buildRequest(TheMovieDBService api);
}
