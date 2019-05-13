package com.spring.demo.repository.computer;

import com.spring.demo.entity.computer.MotherBoard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MotherBoardRepository extends JpaRepository<MotherBoard,String> {
    List<MotherBoard> findByPriceLessThanEqualOrderByScoreDesc(int price);
}
