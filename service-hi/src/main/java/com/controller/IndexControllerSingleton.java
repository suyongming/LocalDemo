package com.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope("prototype")
public class IndexControllerSingleton {

    @Autowired
    private com.controller.RequestObj RequestObj;

    @Autowired
    private com.controller.SessionObj SessionObj;

    @Autowired
    private com.controller.PrototypeObj PrototypeObj;

    @Autowired
    private com.controller.SingletonObj SingletonObj;
static int i=0;
    @RequestMapping("/testScope")
    public String index() {
        i++;
        System.out.println("第"+i+"次访问");
        print();
        return "Welcome";
    }

    public void print() {
        System.out.println("first  time singleton is :" + SingletonObj);
        System.out.println("second time singleton is :" + SingletonObj);

        System.out.println("first  time prototype is :" + PrototypeObj);
        System.out.println("second time prototype is :" + PrototypeObj);

        System.out.println("first  time request is :" + RequestObj);
        System.out.println("second time request is :" + RequestObj);

        System.out.println("first  time session is :" + SessionObj);
        System.out.println("second time session is :" + SessionObj);
    }

}