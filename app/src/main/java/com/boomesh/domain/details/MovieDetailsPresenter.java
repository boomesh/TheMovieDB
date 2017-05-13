package com.boomesh.domain.details;

import com.boomesh.data.api.Const;
import com.boomesh.data.api.common.models.Movie;
import com.boomesh.domain.base.BasePresenter;

/**
 * Manages the information to be displayed in the movie details
 * <p>
 * Created by sumesh on 5/12/17.
 */

public class MovieDetailsPresenter extends BasePresenter<MovieDetailsViewable> {

    private Movie movie;

    @Override
    protected void onAttach(MovieDetailsViewable viewable) {
        super.onAttach(viewable);
        this.movie = getView().getMovie();
        updateTitle();
        updateReleaseDate();
        updatePlotSynopsis();
        updateMoviePoster();
        updateVoteAverage();
    }

    private void updateTitle() {
        getView().updateTitle(movie.title);
    }

    private void updateReleaseDate() {
        getView().updateReleaseDate(movie.releaseDate);
    }

    private void updatePlotSynopsis() {
        getView().updatePlotSynopsis(movie.overview);
    }

    private void updateMoviePoster() {
        getView().updateMoviePoster(Const.IMG_BASE_URL + movie.posterPath);
    }

    private void updateVoteAverage() {
        getView().updateRatings(movie.voteAverage + " / 10");
    }


}
