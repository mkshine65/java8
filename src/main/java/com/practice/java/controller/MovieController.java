package com.practice.java.controller;

import com.practice.java.model.Movie;
import com.practice.java.model.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {

    @Value("${api.key}")
    String apiKey;

    @Autowired
    RestTemplate restTemplate;


    @GetMapping("/getmovie/{id}")
    public MovieSummary getMovie(@PathVariable("id") String id)
    {
            String url="https://api.themoviedb.org/3/movie/"+id+"?api_key="+apiKey;

            MovieSummary movieSummary=restTemplate.getForObject(url,MovieSummary.class);

            return movieSummary;
            //return new Movie(movieSummary.getId(), movieSummary.getOverview());
    }
}
