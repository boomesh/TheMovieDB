package com.boomesh.themoviedb.movieposters.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.boomesh.data.api.Const;
import com.boomesh.data.api.common.models.Movie;
import com.boomesh.themoviedb.R;
import com.squareup.picasso.Picasso;

/**
 * A single movie poster is displayed via this view holder
 * <p>
 * Created by sumesh on 5/9/17.
 */

public class MoviePosterViewHolder extends RecyclerView.ViewHolder {
    ImageView moviePosterImageView;

    public MoviePosterViewHolder(View itemView) {
        super(itemView);
        moviePosterImageView = (ImageView) itemView.findViewById(R.id.movie_poster_iv);
    }

    public void set(Movie movie) {
        String imageURL = Const.IMG_BASE_URL + movie.posterPath;
        Picasso.with(itemView.getContext()).load(imageURL).into(moviePosterImageView);
    }
}
