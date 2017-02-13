package com.boomesh.data.api;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

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
    private static API instance;

    public static API api()
    {
        if (instance == null)
        {
            instance = new API();
        }
        return instance;
    }

    public TheMovieDBService service() {
        if (service == null) {
            OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
            clientBuilder.addInterceptor(new APIKeyInterceptor());

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Const.API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(clientBuilder.build())
                    .build();

            service = retrofit.create(TheMovieDBService.class);
        }
        return service;
    }
}
