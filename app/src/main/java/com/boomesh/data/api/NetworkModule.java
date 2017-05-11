package com.boomesh.data.api;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Encapsulates the networking layer
 * <p>
 * Created by sumesh on 5/9/17.
 */

@Module
public class NetworkModule {

    @Singleton
    @Provides
    public TheMovieDBService providesTheMovieDBService(APIKeyInterceptor apiKeyInterceptor) {
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        clientBuilder.addInterceptor(apiKeyInterceptor);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Const.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(clientBuilder.build())
                .build();

        return retrofit.create(TheMovieDBService.class);
    }

}
