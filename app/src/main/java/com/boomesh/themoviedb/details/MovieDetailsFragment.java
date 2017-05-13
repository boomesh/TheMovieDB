package com.boomesh.themoviedb.details;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.boomesh.data.api.common.models.Movie;
import com.boomesh.domain.details.MovieDetailsPresenter;
import com.boomesh.domain.details.MovieDetailsViewable;
import com.boomesh.themoviedb.R;
import com.boomesh.themoviedb.base.BaseFragment;
import com.boomesh.themoviedb.base.BaseFragmentActivity;
import com.squareup.picasso.Picasso;

/**
 * Renders the details of a supplied movie.
 * <p>
 * Created by sumesh on 5/12/17.
 */

public class MovieDetailsFragment
        extends BaseFragment<MovieDetailsViewable, MovieDetailsPresenter>
        implements MovieDetailsViewable {
    private static final String TAG = MovieDetailsFragment.class.getSimpleName();
    private static final String ARGS_MOVIE_KEY = TAG + "args.movie";

    private ImageView posterImageView;
    private TextView releaseDateTextView;
    private TextView voteRatingsTextView;
    private TextView synopsisTextView;

    public static MovieDetailsFragment newInstance(Movie movie) {
        Bundle args = new Bundle();
        args.putParcelable(ARGS_MOVIE_KEY, movie);
        MovieDetailsFragment fragment = new MovieDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    //region Life Cycle
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        showUp();
        posterImageView = (ImageView) view.findViewById(R.id.movie_poster_iv);
        releaseDateTextView = (TextView) view.findViewById(R.id.movie_release_date_tv);
        voteRatingsTextView = (TextView) view.findViewById(R.id.movie_vote_ratings_tv);
        synopsisTextView = (TextView) view.findViewById(R.id.movie_synopsis_tv);
    }
    //endregion

    //<editor-fold desc="BaseFragment">
    @NonNull
    @Override
    protected MovieDetailsPresenter createPresenter() {
        return new MovieDetailsPresenter();
    }

    @NonNull
    @Override
    protected String getFragmentTag() {
        return TAG;
    }

    @Override
    protected int getFragmentContentLayout() {
        return R.layout.fragment_movie_details;
    }
    //</editor-fold>

    //<editor-fold desc="MovieDetailsViewable">
    @NonNull
    @Override
    public Movie getMovie() {
        return getArguments().getParcelable(ARGS_MOVIE_KEY);
    }

    @Override
    public void updateTitle(String title) {
        ((BaseFragmentActivity) getActivity())
                .getSupportActionBar().setTitle(title);
    }

    @Override
    public void updateReleaseDate(String releaseDate) {
        releaseDateTextView.setText(releaseDate);
    }

    @Override
    public void updatePlotSynopsis(String synopsis) {
        synopsisTextView.setText(synopsis);
    }

    @Override
    public void updateMoviePoster(String posterURL) {
        Picasso.with(getContext()).load(posterURL).into(posterImageView);
    }

    @Override
    public void updateRatings(String voteAverage) {
        voteRatingsTextView.setText(voteAverage);
    }
    //</editor-fold>
}
