package com.example.moviecatalogservice.controller;

import com.example.moviecatalogservice.model.CatalogItem;
import com.example.moviecatalogservice.model.Movie;
import com.example.moviecatalogservice.model.Rating;
import com.example.moviecatalogservice.model.UserRatings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CatalogItem> getCatalog(@PathVariable("userId") final String userId) {
        UserRatings userRatings = restTemplate.getForObject("http://ratings-data-service/ratingsdata/users/" + userId,
                UserRatings.class);
        return userRatings.getRatingsList().stream().map(rating -> {
            Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(),
                    Movie.class);
            return CatalogItem.builder()
                    .name(movie.getMovieName())
                    .description("This is the first part of Avengers Infinity War movie series.")
                    .rating(rating.getRating()).build();
        }).collect(Collectors.toList());
    }
}
