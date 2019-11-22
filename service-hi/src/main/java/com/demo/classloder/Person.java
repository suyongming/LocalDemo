package com.demo.classloder;

import lombok.Data;

@Data
public class Person {

    private String name;

    Person(){
        System.out.println("Person...............");
    }

    Person(String name){}



}
