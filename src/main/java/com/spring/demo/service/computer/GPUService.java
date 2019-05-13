package com.spring.demo.service.computer;

import com.spring.demo.entity.computer.GPU;

import java.util.List;

public interface GPUService {
    List<GPU> allGPU();
    GPU findGPUByPrice(int price);
}
