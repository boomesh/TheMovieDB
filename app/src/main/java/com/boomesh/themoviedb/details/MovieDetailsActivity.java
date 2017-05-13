package com.boomesh.themoviedb.details;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.boomesh.data.api.common.models.Movie;
import com.boomesh.themoviedb.base.BaseFragment;
import com.boomesh.themoviedb.base.BaseFragmentActivity;

/**
 * Encapsulates the various fragments involved in the movie details view.
 * <p>
 * Created by sumesh on 5/12/17.
 */

public class MovieDetailsActivity extends BaseFragmentActivity {
    private static final String EXTRA_MOVIE_KEY = ".extras.movie";

    public static Intent createStartIntentWithMovie(Context context, Movie movie) {
        Intent intent = new Intent(context, MovieDetailsActivity.class);
        intent.putExtra(EXTRA_MOVIE_KEY, movie);
        return intent;
    }

    @NonNull
    @Override
    protected BaseFragment getSingleFragmentInstance() {
        return MovieDetailsFragment.newInstance(getIntent().getParcelableExtra(EXTRA_MOVIE_KEY));
    }
}
