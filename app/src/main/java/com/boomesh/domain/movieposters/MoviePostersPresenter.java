package com.boomesh.domain.movieposters;

import com.boomesh.domain.base.Presentable;

import java.lang.ref.WeakReference;

/**
 * In charge of determining when to show movie posters, as well as issuing the fetch requests
 * <p>
 * Created by sumesh on 2/12/17.
 */

public class MoviePostersPresenter implements Presentable<MoviePostersViewable> {

    private WeakReference<MoviePostersViewable> weakRef;

    void fetchPosters() {
        //TODO: talk to API and get top movies
    }

    //region Presentable
    @Override
    public void set(MoviePostersViewable viewable) {
        weakRef = new WeakReference<MoviePostersViewable>(viewable);
    }
    //endregion
}
