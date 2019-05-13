package com.spring.demo.repository;

import com.spring.demo.entity.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConfigurationRepository extends JpaRepository<Configuration, String> {

    List<Configuration> findByUserName(String userName);

}
