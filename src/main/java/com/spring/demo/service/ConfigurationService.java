package com.spring.demo.service;

import com.spring.demo.entity.Configuration;
import java.util.List;

public interface ConfigurationService {

    List<Configuration> findConfigurationByUserName(String userName);

    Configuration addConfiguration(Configuration configuration);

    void removeConfiguration(String id);

}