package com.spring.demo.repository.computer;

import com.spring.demo.entity.computer.HDD;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HDDRepository extends JpaRepository<HDD,String> {
    List<HDD> findByPriceLessThanEqualOrderByScoreDesc(int price);
}
