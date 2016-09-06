package com.vasylieva.music_service.service;

import com.vasylieva.music_service.model.Movie;
import com.vasylieva.music_service.model.UserMoviesInfo;

import java.util.List;

/**
 * Created by Lera on 06.09.2016.
 */
public interface MovieService {
    List<Movie> getTopTenMovieByAverageRatingAndUserAge(int age);
    UserMoviesInfo getUserMovieInfo(long userId);
    List<Movie> getTopTwentyMovieByAverageRatingAndState();
    int getAverageMovieRating(long movieId);
    List<Movie> getMovieByGenreAndUserAge(String genre, long userId);
}
