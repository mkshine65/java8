package com.practice.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JDBCTemplateQuery {

    @Autowired
    @Qualifier("Jdbctest")
    JdbcTemplate jdbcTemplateTest;

    @Autowired
    @Qualifier("Jdbctest1")
    JdbcTemplate jdbcTemplateTestOne;

    String query="Select count(*) from user";
    String queryTwo="Select count(*) from users";

    @GetMapping("/jdbc1/{id}")
    public ResponseEntity<Integer> countUserJDBC(@PathVariable int id)
    {
        int cnt= jdbcTemplateTest.queryForObject(query,Integer.class);

        return new ResponseEntity<>(cnt, HttpStatus.OK);

    }

    @GetMapping("/jdbc2/{id}")
    public ResponseEntity<Integer> countUserJDBCOne(@PathVariable int id)
    {
        int cnt= jdbcTemplateTestOne.queryForObject(queryTwo,Integer.class);

        return new ResponseEntity<>(cnt, HttpStatus.OK);

    }
}
