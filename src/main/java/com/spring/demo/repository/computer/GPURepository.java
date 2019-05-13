package com.spring.demo.repository.computer;

import com.spring.demo.entity.computer.GPU;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GPURepository extends JpaRepository<GPU,String> {
    List<GPU> findByPriceLessThanEqualOrderByScoreDesc(int price);
}
