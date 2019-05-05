package com.spring.demo.repository.computer;

import com.spring.demo.entity.computer.GPU;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GPURepository extends JpaRepository<GPU,String> {
}
