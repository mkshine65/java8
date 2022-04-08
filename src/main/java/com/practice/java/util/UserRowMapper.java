package com.practice.java.util;

import com.practice.java.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class UserRowMapper implements RowMapper {


    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {

        User u=new User();
        u.setId(rs.getInt("id"));
        u.setName(rs.getString("name"));
        return  u;
    }
}
