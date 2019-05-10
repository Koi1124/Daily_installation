package com.spring.demo.service.computer;

import com.spring.demo.entity.computer.GPU;
import com.spring.demo.repository.computer.GPURepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GPUServiceImp implements GPUService {
    @Autowired
    GPURepository gpuRepository;

    @Override
    public List<GPU> allGPU() {
        return gpuRepository.findAll();
    }
}
