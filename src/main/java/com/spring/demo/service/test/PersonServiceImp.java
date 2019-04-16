package com.spring.demo.service.test;

import com.spring.demo.entity.test.Person;
import com.spring.demo.repository.test.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonServiceImp implements PersonService{

    @Autowired
    PersonRepository personRepository;

    @Override
    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void removePerson(String id) {
        personRepository.deleteById(id);
    }

    @Override
    public Person update(Person person) {
        return personRepository.save(person);
    }

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }
}
