package com.spring.demo.service.computer;

import com.spring.demo.entity.computer.HDD;
import com.spring.demo.repository.computer.HDDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HDDServiceImp implements HDDService {
    @Autowired
    HDDRepository hddRepository;

    @Override
    public List<HDD> allHDD() {
        return hddRepository.findAll();
    }

    @Override
    public HDD findHDDByPrice(int price) {
        return hddRepository.findByPriceLessThanEqualOrderByScoreDesc(price).get(0);
    }
}
