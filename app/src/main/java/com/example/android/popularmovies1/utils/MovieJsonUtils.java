package com.example.android.popularmovies1.utils;

import com.example.android.popularmovies1.model.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by mariona on 26/1/17.
 */

public class MovieJsonUtils {
    private static final String LBL_RESULTS = "results";

    private static final String LBL_ID = "id";
    private static final String LBL_POSTER_PATH = "poster_path";
    private static final String LBL_ORIGINAL_TITLE = "original_title";
    private static final String LBL_OVERVIEW = "overview";
    private static final String LBL_RELEASE_DATE = "release_date";
    private static final String LBL_VOTE_AVERAGE = "vote_average";

    public static Movie[] getMovies(JSONObject jsonData) throws JSONException{
        JSONArray moviesJsonArray = jsonData.getJSONArray(LBL_RESULTS);
        int length = moviesJsonArray.length();
        Movie[] movies = new Movie[length];
        for (int i = 0; i < length; i ++) {
            JSONObject jsonMovie = moviesJsonArray.getJSONObject(i);
            Movie m = new Movie();
            m.setId(jsonMovie.getInt(LBL_ID));
            m.setPosterPath(jsonMovie.getString(LBL_POSTER_PATH));
            m.setOriginalTitle(jsonMovie.getString(LBL_ORIGINAL_TITLE));
            m.setOverview(jsonMovie.getString(LBL_OVERVIEW));
            String releaseDate = jsonMovie.getString(LBL_RELEASE_DATE);
            m.setReleaseDate(releaseDate);
            m.setVoteAverage(jsonMovie.getDouble(LBL_VOTE_AVERAGE));
            movies[i] = m;
        }
        return movies;
    }
}
