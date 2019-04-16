package com.spring.demo.controller.test;


import com.spring.demo.entity.test.Person;
import com.spring.demo.service.test.PersonServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PersonController {

    @Autowired
    PersonServiceImp personServiceImp;

    @GetMapping("/people")
    public String people(Model model) {
        List<Person> people = personServiceImp.getAll();
        model.addAttribute("people",people);
        return "person/list";
    }

    @GetMapping("/person")
    public String toPerson() {
        return "person/add";
    }

    @PostMapping("/person/add")
    public String addPerson(Person person) {
        System.out.println(person);
        personServiceImp.addPerson(person);
        return "redirect:/people";

    }

}
