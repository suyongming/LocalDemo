package com.demo.dao.impl;

import com.demo.dao.PersonDao;
import com.demo.pojo.Person;

import java.util.List;

//原始实现类
public class PersonImpl implements PersonDao
{
    private String person = null;
    public PersonImpl()
    {
    }
    public PersonImpl(String person)
    {
        this.person = person;
    }
    public String getUserName()
    {
        return person;
    }
    public void getPerson()
    {
        System.out.println("this is getPerson() method!");
    }

    public void setPerson(String user)
    {
        this.person = user;
        System.out.println("this is setPerson() method!");
    }


    @Override
    public void add() {
        System.out.println("this is addPerson() method!");

    }

    @Override
    public void delete() {
        System.out.println("this is delete() method!");
    }

    @Override
    public List<Person> findAll() {
        System.out.println("this is findAll() method!");
        return null;
    }

    @Override
    public void updateByPerson(Person person) {
        System.out.println("this is updateByPerson() method!");
    }
}
