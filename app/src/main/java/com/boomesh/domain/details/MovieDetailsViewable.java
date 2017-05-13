package com.boomesh.domain.details;

import android.support.annotation.NonNull;

import com.boomesh.data.api.common.models.Movie;
import com.boomesh.domain.base.message.MessageViewable;

/**
 * Movie details view conforms to this contract.
 * <p>
 * Created by sumesh on 5/12/17.
 */

public interface MovieDetailsViewable extends MessageViewable {
    void updateTitle(String title);

    void updateReleaseDate(String releaseDate);

    void updatePlotSynopsis(String synopsis);

    void updateMoviePoster(String posterURL);

    void updateRatings(String voteAverage);

    @NonNull
    Movie getMovie();
}
