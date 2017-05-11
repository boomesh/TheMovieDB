package com.boomesh.domain.movieposters;

import android.support.annotation.NonNull;

import com.boomesh.data.api.GetPopularMovies.models.PopularMovie;
import com.boomesh.data.api.GetPopularMovies.models.PopularMoviePage;
import com.boomesh.domain.base.LoadViewable;
import com.boomesh.domain.base.Viewable;

import java.util.List;

/**
 * Views that intend to display movie posters, must implement this
 * <p>
 * Created by sumesh on 2/12/17.
 */

public interface MoviePostersViewable extends LoadViewable {

    void showPosters(@NonNull List<PopularMovie> popularMovies);
}
