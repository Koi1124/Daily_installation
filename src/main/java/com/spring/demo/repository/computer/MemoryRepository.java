package com.spring.demo.repository.computer;

import com.spring.demo.entity.computer.Memory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoryRepository extends JpaRepository<Memory,String> {
}
