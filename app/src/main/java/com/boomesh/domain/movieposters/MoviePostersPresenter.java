package com.boomesh.domain.movieposters;

import android.util.Log;

import com.boomesh.data.api.API;
import com.boomesh.data.api.GetPopularMovies.PopularMoviePage;
import com.boomesh.domain.base.Presentable;

import java.lang.ref.WeakReference;

import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * In charge of determining when to show movie posters, as well as issuing the fetch requests
 * <p>
 * Created by sumesh on 2/12/17.
 */

public class MoviePostersPresenter implements Presentable<MoviePostersViewable> {

    private WeakReference<MoviePostersViewable> weakRef;

    public void fetchPosters() {
        API.api().service().getPopularMovies()
                .subscribeOn(Schedulers.io())
                .doOnError(new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.e("ASDAS", "Here we are");
                    }
                })
                .subscribe(new Consumer<PopularMoviePage>() {
                    @Override
                    public void accept(PopularMoviePage popularMoviePage) throws Exception {
                        Log.e("ASDAS", "Here we are");
                    }
                });
    }

    //region Presentable
    @Override
    public void set(MoviePostersViewable viewable) {
        weakRef = new WeakReference<MoviePostersViewable>(viewable);
    }
    //endregion
}
