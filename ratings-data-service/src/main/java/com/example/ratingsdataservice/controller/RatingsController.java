package com.example.ratingsdataservice.controller;

import com.example.ratingsdataservice.model.Rating;
import com.example.ratingsdataservice.model.UserRatings;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsController {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") final String movieId) {
        return Rating.builder()
                .movieId("1")
                .rating(9).build();
    }

    @RequestMapping("users/{userId}")
    public UserRatings getRatingsForUser(@PathVariable("userId") final String userId) {
        return UserRatings.builder()
                .ratingsList(Arrays.asList(
                        Rating.builder()
                                .movieId("1")
                                .rating(4).build(),
                        Rating.builder()
                                .movieId("2")
                                .rating(7).build()))
                .build();
    }
}
