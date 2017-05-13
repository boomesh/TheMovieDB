package com.boomesh.themoviedb.posters;

import android.support.annotation.NonNull;

import com.boomesh.themoviedb.base.BaseFragment;
import com.boomesh.themoviedb.base.BaseFragmentActivity;

public class MoviePostersActivity extends BaseFragmentActivity {
    @NonNull
    @Override
    protected BaseFragment getSingleFragmentInstance() {
        return MoviePosterFragment.newInstance();
    }
}
