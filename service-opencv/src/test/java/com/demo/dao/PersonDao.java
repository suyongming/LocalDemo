package com.demo.dao;

import com.demo.pojo.Person;

import java.util.List;

public interface PersonDao {

    void add();
    void delete();
    List<Person> findAll();
    void updateByPerson(Person person);
}

