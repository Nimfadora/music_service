package com.vasylieva.music_service.repository;

import com.vasylieva.music_service.model.Movie;
import com.vasylieva.music_service.model.MovieWithRating;

import java.util.List;

/**
 * Created by Lera on 06.09.2016.
 */
public interface MovieRepository {
    List<Movie> getTopTenMovieByAverageRatingAndUserAge(int age);
    List<MovieWithRating> getUserMovieInfo(long userId);
    List<Movie> getTopTwentyMovieByAverageRatingAndState();
    int getAverageMovieRating(long movieId);
    List<Movie> getMovieByGenreAndUserAge(String genre, long userId);
}
