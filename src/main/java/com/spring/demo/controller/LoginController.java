package com.spring.demo.controller;

import com.spring.demo.entity.User;
import com.spring.demo.entity.test.Login;
import com.spring.demo.repository.test.LoginRepository;
import com.spring.demo.service.UserServiceImp;
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

    @RequestMapping("/")
    public String loginPage() {
        return "ttzj/login";
    }

    @PostMapping(value = "/newLogin")
    public String login(User user,HttpSession session,Map<String,Object> map) {
        String name=user.getName();
        if (userServiceImp.isExist(name)&&
                userServiceImp.findById(name).getPassword().equals(user.getPassword())) {
            session.setAttribute("user",name);
            return "redirect:/main.html";
        }else {
            map.put("msg","用户密码错误");
            return "ttzj/login";
        }
    }


    // for test
    @PostMapping(value = "/login")
    public String loginAction(@ModelAttribute(name = "info")Login login, Model model
                , HttpSession session, Map<String,Object> map) {
        String email=login.getEmail();
        String password=login.getPassword();
        if (email.equals("koixxx1124@gmail.com")&&password.equals("yyh1124")) {
            session.setAttribute("loginUser",email);
            return "redirect:/main.html";
        } else {
            map.put("msg","用户密码错误");
            return "login";
        }
    }


}
