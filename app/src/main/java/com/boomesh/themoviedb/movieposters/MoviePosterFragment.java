package com.boomesh.themoviedb.movieposters;

import android.support.annotation.NonNull;

import com.boomesh.themoviedb.R;
import com.boomesh.themoviedb.base.BaseFragment;

/**
 * Displays the list of posters
 * Created by sumesh on 2/7/17.
 */

public class MoviePosterFragment extends BaseFragment {
    private static final String TAG = MoviePosterFragment.class.getSimpleName();

    public static MoviePosterFragment newInstance() {
        return new MoviePosterFragment();
    }

    //region {@class BaseFragment}
    @NonNull
    @Override
    protected String getFragmentTag() {
        return TAG;
    }

    @Override
    protected int getFragmentContentLayout() {
        return R.layout.fragment_movie_posters;
    }

    //endregion
}
