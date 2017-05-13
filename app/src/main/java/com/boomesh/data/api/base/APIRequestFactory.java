package com.boomesh.data.api.base;

import android.support.annotation.NonNull;

import com.boomesh.data.api.TheMovieDBService;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Response;

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
    public <T> Single<APIResponse<T>> make(APIRequest<T> request) {
        return Single.fromCallable(() -> {
            try {
                Response<T> response = request.buildRequest(api).execute();
                return new APIResponse<T>(response.body(), null);
            } catch (SocketTimeoutException ste) {
                return new APIResponse<T>(null, APIResponse.Error.TIMEOUT);
            } catch (UnknownHostException uhe) {
                return new APIResponse<T>(null, APIResponse.Error.NO_NETWORK);
            } catch (Exception e) {
                return new APIResponse<T>(null, APIResponse.Error.UNKNOWN);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
