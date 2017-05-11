package com.boomesh.themoviedb;

import com.boomesh.data.api.NetworkModule;
import com.boomesh.data.api.base.APIRequestFactory;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Components for the application portion of the movie DB architecture lives here
 * <p>
 * Created by sumesh on 5/9/17.
 */
@Singleton
@Component(modules =
        {
                NetworkModule.class
        })
public interface AppComponent {

    APIRequestFactory requestFactory();
}
