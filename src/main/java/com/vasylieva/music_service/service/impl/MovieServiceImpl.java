package com.vasylieva.music_service.service.impl;

import com.vasylieva.music_service.model.Movie;
import com.vasylieva.music_service.model.UserMoviesInfo;
import com.vasylieva.music_service.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Lera on 06.09.2016.
 */
@Service
public class MovieServiceImpl implements MovieService{
    @Override
    public List<Movie> getTopTenMovieByAverageRatingAndUserAge(int age) {
        return null;
    }

    @Override
    public UserMoviesInfo getUserMovieInfo(long userId) {
        return null;
    }

    @Override
    public List<Movie> getTopTwentyMovieByAverageRatingAndState() {
        return null;
    }

    @Override
    public int getAverageMovieRating(long movieId) {
        return 0;
    }

    @Override
    public List<Movie> getMovieByGenreAndUserAge(String genre, long userId) {
        return null;
    }
}
