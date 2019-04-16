package com.spring.demo.repository.test;

import com.spring.demo.entity.test.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login,Integer> {

}
