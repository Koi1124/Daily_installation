package com.spring.demo.controller;


import com.spring.demo.entity.Configuration;
import com.spring.demo.entity.computer.*;
import com.spring.demo.service.ConfigurationServiceImp;
import com.spring.demo.service.computer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class ConfigurationController {
    @Autowired
    ConfigurationServiceImp configurationServiceImp;
    @Autowired
    CPUServiceImp cpuServiceImp;
    @Autowired
    GPUServiceImp gpuServiceImp;
    @Autowired
    HDDServiceImp hddServiceImp;
    @Autowired
    MemoryServiceImp memoryServiceImp;
    @Autowired
    MotherBoardServiceImp motherBoardServiceImp;
    @Autowired
    PowerSupplyServiceImp powerSupplyServiceImp;
    @Autowired
    SSDServiceImp ssdServiceImp;

    @PostMapping("/publish")
    public String doPublish(Configuration test, HttpSession session) {
        System.out.println(test.toString());
        configurationServiceImp.addConfiguration(test);
        session.setAttribute("configuration", test);
        return "redirect:";
    }

    @RequestMapping("/recommend")
    public String openRecommend() {
        return "ttzj/recommend";
    }

    static double[][] priceRates = {{0.25, 0.15, 0.35, 0.075, 0.075, 0.075, 0.075},
                                    {0.25, 0.15, 0.40, 0.05,  0.05,  0.05,  0.05 },
                                    {0.25, 0.10, 0.40, 0.10,  0.05,  0.05,  0.05 },
                                    {0.20, 0.10, 0.40, 0.075, 0.075, 0.075, 0.075},
                                    {0.15, 0.05, 0.45, 0.875, 0.875, 0.875, 0.875}};

    @PostMapping("/recommendConfiguration")
    public String doPRecommend(int price, HttpSession session) {
        Configuration configuration = new Configuration();
        double[] priceRate;
        if (price >= 8000) priceRate = priceRates[4];
        else if (price >= 7000) priceRate = priceRates[3];
        else if (price >= 6000) priceRate = priceRates[2];
        else if (price >= 5000) priceRate = priceRates[1];
        else priceRate = priceRates[0];

        CPU cpu = cpuServiceImp.findCPUByMaxPrice((int)(priceRate[0] * price));
        MotherBoard motherBoard = motherBoardServiceImp.findMotherBoardByPrice((int)(priceRate[1] * price));
        GPU gpu = gpuServiceImp.findGPUByPrice((int)(priceRate[2] * price));
        HDD hdd = hddServiceImp.findHDDByPrice((int)(priceRate[5] * price));
        SSD ssd = ssdServiceImp.findSSDByPrice((int)(priceRate[4] * price));
        Memory memory = memoryServiceImp.findMemoryByPrice((int)(priceRate[3] * price));
        PowerSupply powerSupply = powerSupplyServiceImp.findPowerSupplyByPrice((int)(priceRate[6] * price));

        configuration.setCpuName(cpu.getCpuName());
        configuration.setCpuImg(cpu.getSrc());
        configuration.setMotherBoardName(motherBoard.getM_bName());
        configuration.setMotherBoardImg(motherBoard.getSrc());
        configuration.setGpuName(gpu.getGpuName());
        configuration.setGpuImg(gpu.getSrc());
        configuration.setHddName(hdd.getHddName());
        configuration.setHddImg(hdd.getSrc());
        configuration.setSsdName(ssd.getSsdName());
        configuration.setSsdImg(ssd.getSrc());
        configuration.setMemoryName(memory.getMemoryName());
        configuration.setMemoryImg(memory.getSrc());
        configuration.setPowerSupplyName(powerSupply.getP_sName());
        configuration.setPowerSupplyImg(powerSupply.getSrc());

        System.out.println(configuration);
        session.setAttribute("recommendConfiguration", configuration);
        return "ttzj/recommend";
    }
}