/*

package com.practice.java.controller;

import com.practice.java.model.User;
import com.practice.java.repository.UserRepository;
import com.practice.java.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {


    @Autowired
    UserRepository userRepository;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id)
    {
            User u=userRepository.getById(id);
           return new ResponseEntity<>(new User(u.getId(),u.getName()), HttpStatus.ACCEPTED);
    }


    @PostMapping("/load")
    public ResponseEntity<List<User>> insertUser(@RequestBody User user)
    {
        userRepository.save(user);

        List<User> list=userRepository.findAll().stream().collect(Collectors.toList());

        return new ResponseEntity<>(list,HttpStatus.OK);
    }


}

*/
