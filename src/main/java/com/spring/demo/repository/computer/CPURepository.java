package com.spring.demo.repository.computer;

import com.spring.demo.entity.computer.CPU;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CPURepository extends JpaRepository<CPU,String> {
}
