package com.spring.demo.controller;


import com.spring.demo.entity.User;
import com.spring.demo.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class RegisterController {
    @Autowired
    UserServiceImp userServiceImp;

    @GetMapping("/register")
    public String toRegister() {
        return "ttzj/testRegister";
    }

    @PostMapping("/doRegister")
    public String doRegister(User user, Map<String,Object> map) {
        if (!userServiceImp.isExist(user.getName())) {
            user.setSrc("/asserts/img/user.png");
            userServiceImp.registerUser(user);
            return "redirect:/login.html";
        } else if(user.getName().equals("admin")) {
            map.put("msg","不能注册此名字");
            return "ttzj/testRegister";
        } else {
            map.put("msg","用户名已存在");
            return "ttzj/testRegister";
        }
    }


}
