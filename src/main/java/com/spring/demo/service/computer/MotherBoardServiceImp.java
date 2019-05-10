package com.spring.demo.service.computer;

import com.spring.demo.entity.computer.MotherBoard;
import com.spring.demo.repository.computer.MemoryRepository;
import com.spring.demo.repository.computer.MotherBoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotherBoardServiceImp implements MotherBoardService {
    @Autowired
    MotherBoardRepository motherBoardRepository;

    @Override
    public List<MotherBoard> allMotherBoard() {
        return motherBoardRepository.findAll();
    }
}
