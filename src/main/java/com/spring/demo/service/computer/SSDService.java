package com.spring.demo.service.computer;

import com.spring.demo.entity.computer.SSD;

import java.util.List;

public interface SSDService {
    List<SSD> allSSD();

    SSD findSSDByPrice(int price);
}
