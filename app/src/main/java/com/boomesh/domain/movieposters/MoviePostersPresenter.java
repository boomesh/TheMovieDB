package com.boomesh.domain.movieposters;

import com.boomesh.data.api.GetPopularMovies.request.GetPopularMovies;
import com.boomesh.data.api.GetTopRatedMovies.request.GetTopRatedMovies;
import com.boomesh.data.api.base.APIRequest;
import com.boomesh.data.api.base.APIRequestFactory;
import com.boomesh.data.api.common.models.MoviesPage;
import com.boomesh.domain.base.BasePresenter;

/**
 * In charge of determining when to show movie posters, as well as issuing the fetch requests
 * <p>
 * Created by sumesh on 2/12/17.
 */

public class MoviePostersPresenter extends BasePresenter<MoviePostersViewable> {

    private MoviesFilter filterRequest = MoviesFilter.POPULAR;

    private final APIRequestFactory apiRequestFactory;

    @Override
    public void attach(MoviePostersViewable viewable) {
        super.attach(viewable);
        fetchMovies();
    }

    public MoviePostersPresenter(APIRequestFactory apiRequestFactory) {
        this.apiRequestFactory = apiRequestFactory;
    }

    public void fetchMovies() {
        // TODO: 5/12/17 handle onError gracefully
        apiRequestFactory
                .make(filterRequest.apiRequest)
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

    //<editor-fold desc="View -> Presenter interactions">
    public void onMostPopularFilterSelected() {
        filterRequest = MoviesFilter.POPULAR;
        fetchMovies();
    }

    public void onHighestRatedFilterSelected() {
        filterRequest = MoviesFilter.TOP_RATED;
        fetchMovies();
    }
    //</editor-fold>

    private enum MoviesFilter {
        POPULAR(new GetPopularMovies()),
        TOP_RATED(new GetTopRatedMovies());

        private final APIRequest<MoviesPage> apiRequest;

        MoviesFilter(APIRequest<MoviesPage> apiRequest) {
            this.apiRequest = apiRequest;
        }
    }
}
