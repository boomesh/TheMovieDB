package com.boomesh.themoviedb;

import android.app.Application;

import com.boomesh.data.api.NetworkModule;

/**
 * The Movie DB custom Application class.
 * <p>
 * Created by sumesh on 5/9/17.
 */

public class App extends Application {

    private static AppComponent appComponent;

    public static AppComponent getAppComponent() {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder()
                    .networkModule(new NetworkModule())
                    .build();
        }
        return appComponent;
    }
}
