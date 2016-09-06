package com.vasylieva.music_service.controller;

import com.vasylieva.music_service.model.Movie;
import com.vasylieva.music_service.model.UserMoviesInfo;
import com.vasylieva.music_service.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {
    private MovieService service;

    @Autowired
    public MovieController(MovieService service){
        this.service = service;
    }

    @RequestMapping(value = "/user/age/{age}", method = RequestMethod.GET)
    public ResponseEntity<List<Movie>> getTopTenMovieByAverageRatingAndUserAge(@PathVariable("age") int age) {
        return new ResponseEntity<List<Movie>>(service.getTopTenMovieByAverageRatingAndUserAge(age), HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserMoviesInfo> getUserMoviesInfo(@PathVariable("id") long id) {
        return new ResponseEntity<UserMoviesInfo>(service.getUserMovieInfo(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/movie/state", method = RequestMethod.GET)
    public ResponseEntity<List<Movie>> getTopTwentyMovieByAverageRatingAndState() {
        return new ResponseEntity<List<Movie>>(service.getTopTwentyMovieByAverageRatingAndState(), HttpStatus.OK);
    }

    @RequestMapping(value = "/movie/{id}", method = RequestMethod.GET)
    public ResponseEntity<Integer> getAverageMovieRating(@PathVariable("id") long id) {
        return new ResponseEntity<Integer>(service.getAverageMovieRating(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/movie", method = RequestMethod.GET)
    public ResponseEntity<List<Movie>> getMovieByGenreAndUserAge(@RequestParam("genre") String genre,
                                                                 @RequestParam("userId") long userId) {
        return new ResponseEntity<List<Movie>>(service.getMovieByGenreAndUserAge(genre, userId), HttpStatus.OK);
    }


}
