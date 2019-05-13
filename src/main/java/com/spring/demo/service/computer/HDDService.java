package com.spring.demo.service.computer;

import com.spring.demo.entity.computer.HDD;

import java.util.List;

public interface HDDService {
    List<HDD> allHDD();
    HDD findHDDByPrice(int price);
}
