package com.spring.demo.service.test;

import com.spring.demo.entity.test.Person;

import java.util.List;

public interface PersonService  {
    Person addPerson(Person person);

    void removePerson(String id);

    Person update(Person person);

    List<Person> getAll();
}
