package com.spring.demo.service;

import com.spring.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserService {
    User registerUser(User user);

    void removeUserByUserId(String name);

    User updateUser(User user);

    List<User> allUser();

    boolean isExist(String name);

    User findById(String name);

}
