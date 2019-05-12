package com.spring.demo.service;

import com.spring.demo.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User registerUser(User user);

    void removeUserByUserId(String name);

    User updateUser(User user);

    List<User> allUser();

    boolean isExist(String name);

    User findById(String name);

    List<User> findByIdLike(String name);

}
