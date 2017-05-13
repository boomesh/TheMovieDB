package com.boomesh.themoviedb.posters.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.boomesh.data.api.common.models.Movie;
import com.boomesh.themoviedb.R;

import java.util.List;

/**
 * Created by sumesh on 5/9/17.
 */

public class MoviePosterAdapter extends RecyclerView.Adapter<MoviePosterViewHolder> {
    private List<Movie> movieList;

    public MoviePosterAdapter(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @Override
    public MoviePosterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_movie_poster, parent, false);
        return new MoviePosterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MoviePosterViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.set(movie);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public void setList(List<Movie> list) {
        this.movieList = list;
    }
}
