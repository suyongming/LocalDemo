package com.demo.lambdas;

import com.alibaba.fastjson.JSONObject;
import com.entity.ExcelDemoEntity;
import com.entity.UserEntity;
import com.util.RandomValue;

import java.util.*;
import java.util.stream.Collectors;

public class LambdaDemo {
    public static void main(String[] args){
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);
        List<ExcelDemoEntity> personList = getDemoList();

        personList.forEach(System.out::println);





    }

    private static List<UserEntity> getUserList() {
        List<UserEntity> list = new ArrayList();


        for (int i = 0; i < 20; i++) {
            Map ranObj = RandomValue.getAddress();
            UserEntity userEntity = new UserEntity();

            userEntity.setUserId(UUID.randomUUID().toString());
            userEntity.setUserName(ranObj.get("email")+"");
            userEntity.setPassword("******");
            userEntity.setLastModifyTime(new Date());
            userEntity.setCreate(new Date());
            list.add(userEntity);

        }
        return list;
    }

    private static List<ExcelDemoEntity> getDemoList() {
        List<ExcelDemoEntity> list = new ArrayList();


        for (int i = 0; i < 20; i++) {
            Map ranObj = RandomValue.getAddress();
            ExcelDemoEntity excelDemoEntity = JSONObject.parseObject(ranObj.toString(),ExcelDemoEntity.class);
            excelDemoEntity.setId(UUID.randomUUID().toString());
            excelDemoEntity.setCreateTime(new Date());
            list.add(excelDemoEntity);

        }
        return list;
    }
}
