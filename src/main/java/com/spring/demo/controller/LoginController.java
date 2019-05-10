package com.spring.demo.controller;

import com.spring.demo.entity.User;
import com.spring.demo.entity.test.Login;
import com.spring.demo.repository.test.LoginRepository;
import com.spring.demo.service.UserServiceImp;
import com.spring.demo.service.computer.CPUServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    UserServiceImp userServiceImp;
    @Autowired
    CPUServiceImp cpuServiceImp;

    @RequestMapping("/")
    public String homePage(HttpSession session) {
        session.setAttribute("cpus",cpuServiceImp.allCPU());
        return "ttzj/homepage";
    }

    @RequestMapping("/toLogin")
    public String loginPage() {
        return "ttzj/testLogin";
    }

    @PostMapping(value = "/login")
    public String login(User user,HttpSession session,Map<String,Object> map) {
        String name=user.getName();
        User owner=userServiceImp.findById(name);
        if (userServiceImp.isExist(name)&&
                owner.getPassword().equals(user.getPassword())) {
            session.setAttribute("user",name);
            session.setAttribute("headImg",owner.getSrc());
            return "redirect:/main.html";
        }else {
            map.put("msg","用户密码错误");
            return "ttzj/testLogin";
        }
    }


}
