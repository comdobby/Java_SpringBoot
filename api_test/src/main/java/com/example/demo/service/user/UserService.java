package com.example.demo.service.user;

import com.example.demo.dto.user.User;
import com.example.demo.dto.user.UserCreateRequest;
import com.example.demo.dto.user.UserResponse;
import com.example.demo.dto.user.UserUpdateRequest;
import com.example.demo.repository.user.UserRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
//        this.userRepository = new UserRepository(jdbcTemplate);
        this.userRepository = userRepository;
    }

    public void saveUser(UserCreateRequest request) {
        userRepository.saveUser(request);
    }

    public List<UserResponse> getUser() {
        return userRepository.getUser();
    }

    public void updateUser(UserUpdateRequest request) {
        boolean isUserNotExist = userRepository.isUserNotExist(request);
        if (isUserNotExist) {
            throw new IllegalArgumentException();
        }

        userRepository.updateUser(request);
    }

    public void deleteUser(String name) {
        boolean isUserNotExist = userRepository.isUserNotExist(name);
        if (isUserNotExist) {
            throw new IllegalArgumentException();
        }

        userRepository.deleteUser(name);
    }
}
