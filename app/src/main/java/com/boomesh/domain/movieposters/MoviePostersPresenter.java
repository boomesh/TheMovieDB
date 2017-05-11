package com.boomesh.domain.movieposters;

import com.boomesh.data.api.GetPopularMovies.request.GetPopularMovies;
import com.boomesh.data.api.base.APIRequestFactory;
import com.boomesh.domain.base.BasePresenter;

/**
 * In charge of determining when to show movie posters, as well as issuing the fetch requests
 * <p>
 * Created by sumesh on 2/12/17.
 */

public class MoviePostersPresenter extends BasePresenter<MoviePostersViewable> {

    private final APIRequestFactory apiRequestFactory;

    public MoviePostersPresenter(APIRequestFactory apiRequestFactory) {
        this.apiRequestFactory = apiRequestFactory;
    }

    public void fetchPosters() {
        apiRequestFactory
                .make(new GetPopularMovies())
                .doOnSubscribe(disposable -> {
                    getView().showLoading(true);
                })
                .doFinally(() -> {
                    getView().showLoading(false);
                })
                .subscribe(popularMoviePage -> {
                    getView().showPosters(popularMoviePage.getResults());
                });

    }
}
