package com.spring.demo.repository.computer;

import com.spring.demo.entity.computer.MotherBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotherBoardRepository extends JpaRepository<MotherBoard,String> {
}
