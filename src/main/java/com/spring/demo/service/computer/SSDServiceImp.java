package com.spring.demo.service.computer;

import com.spring.demo.entity.computer.SSD;
import com.spring.demo.repository.computer.SSDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SSDServiceImp implements SSDService {
    @Autowired
    SSDRepository ssdRepository;

    @Override
    public List<SSD> allSSD() {
        return ssdRepository.findAll();
    }
}
