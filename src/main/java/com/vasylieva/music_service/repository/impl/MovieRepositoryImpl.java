package com.vasylieva.music_service.repository.impl;

import com.vasylieva.music_service.model.Movie;
import com.vasylieva.music_service.model.MovieWithRating;
import com.vasylieva.music_service.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Lera on 06.09.2016.
 */
@Repository
public class MovieRepositoryImpl implements MovieRepository {
    private static final String GET_TOP_TEN_MOVIE_BY_AVERAGE_RATING_AND_USER_AGE = "SELECT movie.id, movie.title, movie.genre "
            + "FROM movie, user, rating WHERE rating.movie_id = movie.id AND rating.user_id = user.id AND user.age = ? "
            + "ORDER BY avg(rating.rating) DESC";
    private static final String GET_MOVIES_WITH_RATING_BY_USER = "SELECT movie.id, movie.title, movie.genre "
            + "FROM movie, user, rating WHERE rating.movie_id = movie.id AND rating.user_id = user.id AND user.age = ? "
            + "ORDER BY avg(rating.rating) DESC";
    private static final String GET_TOP_TWENTY_MOVIE_BY_AVERAGE_RATING_AND_RATED_BETWEEN_SPECIFIED_TIME = "SELECT movie.id, movie.title, movie.genre "
            + "FROM movie, user, rating WHERE rating.movie_id = movie.id AND rating.user_id = user.id AND user.age = ? "
            + "ORDER BY avg(rating.rating) DESC";
    private static final String GET_AVERAGE_MOVIE_RATING = "SELECT movie.id, movie.title, movie.genre "
            + "FROM movie, user, rating WHERE rating.movie_id = movie.id AND rating.user_id = user.id AND user.age = ? "
            + "ORDER BY avg(rating.rating) DESC";
    private static final String GET_TOP_FIVE_MOVIES_BY_AVERAGE_RATING_GENRE_AND_USERS_OLDER_AND_YOUNGER_THAN_SPECIFIED_BY_FIVE_YEARS =
            "SELECT movie.id, movie.title, movie.genre "
            + "FROM movie, user, rating WHERE rating.movie_id = movie.id AND rating.user_id = user.id AND user.age = ? "
            + "ORDER BY avg(rating.rating) DESC";


    private JdbcTemplate jdbcTemplate;

    private RowMapper<Movie> movieMapper = (rs, i) -> new MovieWithRating(rs.getLong("id"), rs.getString("title"), rs.getString("genre"), rs.getInt("rating"));

    @Autowired
    public MovieRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Movie> getTopTenMovieByAverageRatingAndUserAge(int age) {
        return jdbcTemplate.query(GET_TOP_TEN_MOVIE_BY_AVERAGE_RATING_AND_USER_AGE, new Object[]{age}, movieMapper);
    }

    @Override
    public List<MovieWithRating> getUserMovieInfo(long userId) {
        return jdbcTemplate.query(GET_TOP_TEN_MOVIE_BY_AVERAGE_RATING_AND_USER_AGE, new Object[]{userId},
                (rs, i) -> new MovieWithRating(rs.getLong("id"), rs.getString("title"), rs.getString("genre"), rs.getInt("rating")));
    }

    @Override
    public List<Movie> getTopTwentyMovieByAverageRatingAndState() {
        return jdbcTemplate.query(GET_TOP_TEN_MOVIE_BY_AVERAGE_RATING_AND_USER_AGE, movieMapper);
    }

    @Override
    public int getAverageMovieRating(long movieId) {
        return jdbcTemplate.queryForObject(GET_TOP_TEN_MOVIE_BY_AVERAGE_RATING_AND_USER_AGE, new Object[]{movieId},
                Integer.class);
    }

    @Override
    public List<Movie> getMovieByGenreAndUserAge(String genre, long userId) {
        return jdbcTemplate.query(GET_TOP_TEN_MOVIE_BY_AVERAGE_RATING_AND_USER_AGE, new Object[]{genre, userId}, movieMapper);
    }
}
