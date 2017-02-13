package com.boomesh.themoviedb.movieposters;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.boomesh.domain.movieposters.MoviePostersPresenter;
import com.boomesh.themoviedb.R;
import com.boomesh.themoviedb.base.BaseFragment;

/**
 * Displays the list of posters
 * Created by sumesh on 2/7/17.
 */

public class MoviePosterFragment extends BaseFragment {
    private static final String TAG = MoviePosterFragment.class.getSimpleName();

    private MoviePostersPresenter presenter = new MoviePostersPresenter();

    public static MoviePosterFragment newInstance() {
        return new MoviePosterFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter.fetchPosters();
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
