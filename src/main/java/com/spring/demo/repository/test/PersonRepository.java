package com.spring.demo.repository.test;

import com.spring.demo.entity.test.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface PersonRepository extends JpaRepository<Person,Integer> {

    @Modifying
    @Transactional
    @Query("delete from Person p where p.id=?1")
    void deleteById(String string);
}
