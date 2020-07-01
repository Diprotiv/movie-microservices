package com.example.movieinfoservice.controller;

import com.example.movieinfoservice.model.Movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @RequestMapping("/{movieId}")
    public Movie getMovieByInfo(@PathVariable("movieId") final String movieId) {
        return Movie.builder()
                .movieId(movieId)
                .movieName("Avengers Infinity War I").build();
    }

}
