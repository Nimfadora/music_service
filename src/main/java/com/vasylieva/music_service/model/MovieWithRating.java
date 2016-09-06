package com.vasylieva.music_service.model;

/**
 * Created by Lera on 06.09.2016.
 */
public class MovieWithRating extends Movie{
    private int rating;

    public MovieWithRating(){}

    public MovieWithRating(Long id, String title, String genre, int rating) {
        super(id, title, genre);
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
