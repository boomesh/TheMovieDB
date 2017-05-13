package com.boomesh.domain.movieposters;

import com.boomesh.data.api.GetPopularMovies.request.GetPopularMovies;
import com.boomesh.data.api.GetTopRatedMovies.request.GetTopRatedMovies;
import com.boomesh.data.api.base.APIRequest;
import com.boomesh.data.api.base.APIRequestFactory;
import com.boomesh.data.api.common.models.MoviesPage;
import com.boomesh.domain.base.BasePresenter;
import com.boomesh.domain.base.LoadPresenter;

/**
 * In charge of determining when to show movie posters, as well as issuing the fetch requests
 * <p>
 * Created by sumesh on 2/12/17.
 */

public class MoviePostersPresenter
        extends BasePresenter<MoviePostersViewable>
        implements LoadPresenter<MoviePostersViewable> {

    private MoviesFilter filterRequest = MoviesFilter.POPULAR;

    private final APIRequestFactory apiRequestFactory;

    @Override
    protected void onAttach(MoviePostersViewable viewable) {
        fetchMovies();
    }

    public MoviePostersPresenter(APIRequestFactory apiRequestFactory) {
        this.apiRequestFactory = apiRequestFactory;
    }

    public void fetchMovies() {
        loadWith(apiRequestFactory.make(filterRequest.apiRequest))
                .subscribe(apiResponse -> {
                    MoviesPage page = apiResponse.getData();
                    if (apiResponse.isSuccessful() && page != null) {
                        getView().showPosters(page.getResults());
                    }
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
