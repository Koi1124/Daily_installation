package com.spring.demo.repository.computer;

import com.spring.demo.entity.computer.Memory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemoryRepository extends JpaRepository<Memory,String> {
    List<Memory> findByPriceLessThanEqualOrderByScoreDesc(int price);
}
