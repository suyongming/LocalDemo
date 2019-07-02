package com.demo.staticproxy;

public class UserDao implements IUserDao{
    @Override
    public void save() {
        System.out.println("User保存成功");
    }

}
