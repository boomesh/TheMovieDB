package com.boomesh.data.api.GetPopularMovies.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Represents a page object under: https://developers.themoviedb.org/3/movies/get-popular-movies
 *
 * Created by sumesh on 2/12/17.
 */

public class PopularMoviePage {
    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("results")
    @Expose
    private List<PopularMovie> results = null;
    @SerializedName("total_results")
    @Expose
    private Integer totalResults;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;

    public List<PopularMovie> getResults() {
        return results;
    }
}
