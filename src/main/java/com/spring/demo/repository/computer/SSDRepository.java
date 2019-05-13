package com.spring.demo.repository.computer;

import com.spring.demo.entity.computer.SSD;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SSDRepository extends JpaRepository<SSD,String> {
    List<SSD> findByPriceLessThanEqualOrderByScoreDesc(int price);
}
