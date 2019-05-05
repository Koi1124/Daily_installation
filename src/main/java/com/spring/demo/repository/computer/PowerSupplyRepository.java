package com.spring.demo.repository.computer;

import com.spring.demo.entity.computer.PowerSupply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PowerSupplyRepository extends JpaRepository<PowerSupply,String> {
}
