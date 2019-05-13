package com.spring.demo.repository.computer;

import com.spring.demo.entity.computer.CPU;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CPURepository extends JpaRepository<CPU,String> {
    List<CPU> findByPriceLessThanEqualOrderByScoreDesc(int price);
}
