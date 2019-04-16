package com.spring.demo.controller.test;


import com.spring.demo.entity.test.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Map;

@Controller
public class TestController {


    @RequestMapping(value = "/index")
    public String display(Map<String,Object> map, HttpSession session) {
        Person person=new Person();
        person.setId("1");
        person.setName("YIN YIHAN");
        person.setEmail("koixxx1124@gmail.com");
        map.put("information",person);
        map.put("music", Arrays.asList("hip-hop","synthwave","trance"));
        map.put("userEmail",session.getAttribute("loginUser"));
        return "index";
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(Model model, String info) {
        model.addAttribute("info",info);
        return "test";
    }
}
