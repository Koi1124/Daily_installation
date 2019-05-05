package com.spring.demo.repository.computer;

import com.spring.demo.entity.computer.SSD;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SSDRepository extends JpaRepository<SSD,String> {
}
