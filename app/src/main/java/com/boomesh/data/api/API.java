package com.boomesh.data.api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Serves as an accessor to the API.
 *
 * Created by sumesh on 2/12/17.
 */

public class API {

    private static TheMovieDBService service;

    public TheMovieDBService service() {
        if (service == null) {
            OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
            clientBuilder.addInterceptor(new APIKeyInterceptor());

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Const.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(clientBuilder.build())
                    .build();

            service = retrofit.create(TheMovieDBService.class);
        }
        return service;
    }
}
