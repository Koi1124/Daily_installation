package com.spring.demo.service;

import com.spring.demo.entity.User;
import com.spring.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void removeUserByUserId(String name) {
        userRepository.deleteById(name);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> allUser() {
        return userRepository.findAll();
    }

    @Override
    public boolean isExist(String name) {
        return userRepository.existsById(name);
    }

    @Override
    public User findById(String name) {
        Optional<User> byId = userRepository.findById(name);
        return byId.get();
    }
}
