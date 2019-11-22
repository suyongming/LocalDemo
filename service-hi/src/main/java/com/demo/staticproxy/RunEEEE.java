package com.demo.staticproxy;

public class RunEEEE {
    public static void main(String[] args){
        IUserDao p = new ProxyUserDao();
        p.save();
    }
}
