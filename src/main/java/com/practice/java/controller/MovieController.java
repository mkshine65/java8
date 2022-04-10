package com.practice.java.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.practice.java.model.CollectionList;
import com.practice.java.model.Movie;
import com.practice.java.model.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpClient;


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

        String object=restTemplate.getForObject(url,String.class);
        JsonObject convertedObject = new Gson().fromJson(object, JsonObject.class);


        MovieSummary movieSummary= new Gson().fromJson(object,MovieSummary.class);

          return movieSummary;
    }




}
