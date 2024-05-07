package com.example.demo.controller;

import com.example.demo.dto.user.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

//    private final List<User> users = new ArrayList<>();
    private final JdbcTemplate jdbcTemplate;

    public UserController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreateRequest request) {
//        users.add(new User(request.getName(), request.getAge()));
        String sql = "insert into user (name, age) values (?,?)";
        jdbcTemplate.update(sql, request.getName(), request.getAge());
    }

    @GetMapping("/user")
    public List<UserResponse> getUser() {
//        List<UserResponse> responses = new ArrayList<>();
//
//        for (int i = 0; i < users.size(); i++) {
//            responses.add(new UserResponse(i + 1, users.get(i)));
//        }
//        return responses;
        String sql = "select * from user";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            long id = rs.getLong("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            return new UserResponse(id, name, age);
        });
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request) {
        String readSql = "select * from user where id = ?";
        boolean isUserNotExist = jdbcTemplate.query(readSql, (rs, rowNum) -> 0, request.getId()).isEmpty();
        if (isUserNotExist) {
            throw new IllegalArgumentException();
        }

        String sql = "update user set name = ? where id = ?";
        jdbcTemplate.update(sql, request.getName(), request.getId());
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name) {
        String readSql = "select * from user where name = ?";
        boolean isUserNotExist = jdbcTemplate.query(readSql, (rs, rowNum) -> 0, name).isEmpty();
        if (isUserNotExist) {
            throw new IllegalArgumentException();
        }

        String sql = "delete from user where name = ?";
        jdbcTemplate.update(sql, name);
    }
}
