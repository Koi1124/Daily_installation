package com.spring.demo.service;

import com.spring.demo.entity.Configuration;
import com.spring.demo.repository.ConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigurationServiceImp implements ConfigurationService {

    @Autowired
    ConfigurationRepository configurationRepository;

    @Override
    public List<Configuration> findConfigurationByUserName(String userName) {
        return configurationRepository.findByUserName(userName);
    }

    @Override
    public Configuration addConfiguration(Configuration configuration) {
        return configurationRepository.save(configuration);
    }

    @Override
    public void removeConfiguration(String id) {
        configurationRepository.deleteById(id);
    }

}

