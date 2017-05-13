package com.boomesh.domain.movieposters;

import android.support.annotation.NonNull;

import com.boomesh.data.api.common.models.Movie;
import com.boomesh.domain.base.LoadViewable;
import com.boomesh.domain.base.MessageViewable;

import java.util.List;

/**
 * Views that intend to display movie posters, must implement this
 * <p>
 * Created by sumesh on 2/12/17.
 */

public interface MoviePostersViewable extends LoadViewable, MessageViewable {

    void showPosters(@NonNull List<Movie> movies);
}
