package com.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;


@EnableEurekaClient
@RestController
@RequestMapping("/game")
public class GameController {
    @Value("${server.port}")
    String port;
    @RequestMapping("/hi")
    public String home(@RequestParam String name) {

        return "hi "+name+",i am from port:" +port;
    }





}
