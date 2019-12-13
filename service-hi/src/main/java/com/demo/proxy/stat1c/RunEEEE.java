package com.demo.proxy.stat1c;

public class RunEEEE {
    public static void main(String[] args){
        IUserDao p = new ProxyUserDao();
        p.save();
    }
}
