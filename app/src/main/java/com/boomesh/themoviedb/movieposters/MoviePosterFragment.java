package com.boomesh.themoviedb.movieposters;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.boomesh.data.api.GetPopularMovies.models.PopularMovie;
import com.boomesh.domain.movieposters.MoviePostersPresenter;
import com.boomesh.domain.movieposters.MoviePostersViewable;
import com.boomesh.themoviedb.App;
import com.boomesh.themoviedb.R;
import com.boomesh.themoviedb.base.BaseFragment;
import com.boomesh.themoviedb.movieposters.adapter.MoviePosterAdapter;

import java.util.List;

/**
 * Displays the list of posters
 * Created by sumesh on 2/7/17.
 */

public class MoviePosterFragment
        extends BaseFragment<MoviePostersViewable, MoviePostersPresenter>
        implements MoviePostersViewable {
    private static final String TAG = MoviePosterFragment.class.getSimpleName();
    private RecyclerView postersRecyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    @Nullable
    private MoviePosterAdapter adapter;

    public static MoviePosterFragment newInstance() {
        return new MoviePosterFragment();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        postersRecyclerView = (RecyclerView) view.findViewById(R.id.posters_rv);
        postersRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.loading_layout_srl);
        swipeRefreshLayout.setOnRefreshListener(() -> {
            getPresenter().fetchPosters();
        });

        getPresenter().fetchPosters();
    }

    //<editor-fold desc="BaseFragment">
    @NonNull
    @Override
    protected MoviePostersPresenter createPresenter() {
        return new MoviePostersPresenter(App.getAppComponent().requestFactory());
    }

    @NonNull
    @Override
    protected String getFragmentTag() {
        return TAG;
    }

    @Override
    protected int getFragmentContentLayout() {
        return R.layout.fragment_movie_posters;
    }
    //</editor-fold>

    //<editor-fold desc="MoviePostersViewable">
    @Override
    public void showLoading(boolean isLoading) {
        swipeRefreshLayout.setRefreshing(isLoading);
    }

    @Override
    public void showPosters(@NonNull List<PopularMovie> popularMovies) {
        if (adapter == null) {
            adapter = new MoviePosterAdapter(popularMovies);
            postersRecyclerView.setAdapter(adapter);
        } else {
            adapter.setList(popularMovies);
            adapter.notifyDataSetChanged();
        }
    }
    //</editor-fold>
}
