package com.example.demo.controller;

import com.example.demo.dto.user.*;
import com.example.demo.service.user.UserServiceV1;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

//    private final List<User> users = new ArrayList<>();
//    private final JdbcTemplate jdbcTemplate;
    private final UserServiceV1 userService;

    public UserController(UserServiceV1 userService) {
//        this.jdbcTemplate = jdbcTemplate;
//        this.userService = new UserService(jdbcTemplate);
        this.userService = userService;
    }

    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreateRequest request) {
//        users.add(new User(request.getName(), request.getAge()));
//        String sql = "insert into user (name, age) values (?,?)";
//        jdbcTemplate.update(sql, request.getName(), request.getAge());
        userService.saveUser(request);
    }

    @GetMapping("/user")
    public List<UserResponse> getUser() {
//        List<UserResponse> responses = new ArrayList<>();
//
//        for (int i = 0; i < users.size(); i++) {
//            responses.add(new UserResponse(i + 1, users.get(i)));
//        }
//        return responses;
        return userService.getUser();
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request) {
        userService.updateUser(request);
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name) {
        userService.deleteUser(name);
    }
}
