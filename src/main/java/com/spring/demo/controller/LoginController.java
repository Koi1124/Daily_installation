package com.spring.demo.controller;

import com.spring.demo.entity.Article;
import com.spring.demo.entity.User;
import com.spring.demo.service.ArticleServiceImp;
import com.spring.demo.service.UserServiceImp;
import com.spring.demo.service.computer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    UserServiceImp userServiceImp;
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
    @Autowired
    ArticleServiceImp articleServiceImp;



    @RequestMapping("/")
    public String homePage(HttpSession session) {
        if (session.getAttribute("cpus")==null) {
            session.setAttribute("cpus",cpuServiceImp.allCPU());
            session.setAttribute("gpus",gpuServiceImp.allGPU());
            session.setAttribute("hdds",hddServiceImp.allHDD());
            session.setAttribute("memorys",memoryServiceImp.allMemory());
            session.setAttribute("motherboards",motherBoardServiceImp.allMotherBoard());
            session.setAttribute("powersupplys",powerSupplyServiceImp.allPowerSupply());
            session.setAttribute("ssds",ssdServiceImp.allSSD());
        }
        return "ttzj/homepage";
    }

    @RequestMapping("/toLogin")
    public String loginPage() {
        return "ttzj/testLogin";
    }

    @PostMapping(value = "/login")
    public String login(User user,HttpSession session,Map<String,Object> map) {
        String name=user.getName();
        if (!userServiceImp.isExist(name)) {
            map.put("msg","用户名不存在");
            return "ttzj/testLogin";
        }
        User owner=userServiceImp.findById(name);
        if (userServiceImp.isExist(name)&&
                owner.getPassword().equals(user.getPassword())) {
            session.setAttribute("user",name);
            session.setAttribute("headImg",owner.getSrc());
            return "redirect:/";
        }else {
            map.put("msg","用户密码错误");
            return "ttzj/testLogin";
        }
    }


}
