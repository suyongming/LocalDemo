package com.demo.proxy.stat1c;

public class UserDao implements IUserDao{
    @Override
    public void save() {
        System.out.println("User保存成功");
    }

}
