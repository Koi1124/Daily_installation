package com.spring.demo.service.computer;

import com.spring.demo.entity.computer.PowerSupply;
import com.spring.demo.repository.computer.PowerSupplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PowerSupplyServiceImp implements PowerSupplyService {
    @Autowired
    PowerSupplyRepository powerSupplyRepository;

    @Override
    public List<PowerSupply> allPowerSupply() {
        return powerSupplyRepository.findAll();
    }

    @Override
    public PowerSupply findPowerSupplyByPrice(int price) {
        return powerSupplyRepository.findByPriceLessThanEqualOrderByScoreDesc(price).get(0);
    }
}
