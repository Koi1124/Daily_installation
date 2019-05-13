package com.spring.demo.service.computer;

import com.spring.demo.entity.computer.CPU;
import com.spring.demo.repository.computer.CPURepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CPUServiceImp implements CPUService {

    @Autowired
    CPURepository cpuRepository;

    @Override
    public List<CPU> allCPU() {
        return cpuRepository.findAll();
    }

    @Override
    public CPU findCPUByMaxPrice(int price) {
        return cpuRepository.findByPriceLessThanEqualOrderByScoreDesc(price).get(0);
    }
}
