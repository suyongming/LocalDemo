package com.string;

import com.demo.pojo.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringDemo {
    public static void main(String[] args){
        Map<String,String> map=new HashMap<String,String>();
        map.put("1", "value1");
        map.put("2", "value2");
        map.put("3", "value3");
        map.put("4", "value4");

        for(Map.Entry<String,String> entry: map.entrySet()){

            System.out.println("Key: "+ entry.getKey()+ " Value: "+entry.getValue());
        }


        List<String> list = new ArrayList();
        list.add("1");
        list.add("12");
        list.add("123");

        list.add("1234");
        System.out.println(list.size());

    }


}
