package com.spring.demo.service.computer;

import com.spring.demo.entity.computer.Memory;
import com.spring.demo.repository.computer.MemoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoryServiceImp implements MemoryService {
    @Autowired
    MemoryRepository memoryRepository;

    @Override
    public List<Memory> allMemory() {
        return memoryRepository.findAll();
    }

    @Override
    public Memory findMemoryByPrice(int price) {
        return memoryRepository.findByPriceLessThanEqualOrderByScoreDesc(price).get(0);
    }
}
