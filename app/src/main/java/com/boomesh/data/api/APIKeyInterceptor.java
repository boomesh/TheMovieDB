package com.boomesh.data.api;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Intercept all requests with the API KEY
 * Created by sumesh on 2/12/17.
 */

class APIKeyInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        HttpUrl newRequestURL =
                chain.request().url().newBuilder()
                        .addQueryParameter("api_key", Const.API_KEY)
                        .build();

        Request request = chain.request().newBuilder().url(newRequestURL).build();
        return chain.proceed(request);
    }
}
