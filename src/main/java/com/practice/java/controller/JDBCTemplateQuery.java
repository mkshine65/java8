package com.practice.java.controller;

import com.practice.java.model.User;
import com.practice.java.util.FileUtils;
import com.practice.java.util.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;
import java.util.Map;

@RestController
public class JDBCTemplateQuery {

    @Autowired
    @Qualifier("Jdbctest")
    JdbcTemplate jdbcTemplateTest;

    @Autowired
    @Qualifier("Jdbctest1")
    JdbcTemplate jdbcTemplateTestOne;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    Map<String,String> queryMap= FileUtils.loadMap("db-queries.xml");



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
        int count= jdbcTemplateTestOne.queryForObject(queryTwo,Integer.class);

        return new ResponseEntity<>(count, HttpStatus.OK);

    }

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody User user)
    {
        int count = jdbcTemplateTest.update("insert into users values(?,?)",user.getId(),user.getName());

        return new ResponseEntity<>("Inserted query"+count, HttpStatus.OK);

    }

    @GetMapping("/getEmployee/{eid}")
    public ResponseEntity<User> getUserById(@PathVariable int eid)
    {
        //String userQuery="Select * from user where id=:"+id;
        MapSqlParameterSource paraMap= new MapSqlParameterSource().addValue("id",eid);
        User user= (User) namedParameterJdbcTemplate.queryForObject("Select * from user where id=:id",paraMap,
                (rs,row)-> new User(rs.getInt("id"),rs.getString("name")));
        return  new ResponseEntity<>(new User(user.getId(),user.getName()),HttpStatus.OK);

    }

    @GetMapping("/getAll")
    public List<User> getAllUser()
    {
        List<User> list=jdbcTemplateTest.query("Select * from user",
                (rs,row)-> new User(rs.getInt("id"),rs.getString("name")));
        return list;
    }

    @PostMapping("/getAllList")
    public  List<User> getUserInList(@RequestBody List<Integer> id)
    {
        SqlParameterSource parameters = new MapSqlParameterSource("ids", id);

        String query=queryMap.get("readUser");
        List<User> list=namedParameterJdbcTemplate.query(query,
                parameters,(rs,row)-> new User(rs.getInt("id"),rs.getString("name")));
        return list;
    }
}
