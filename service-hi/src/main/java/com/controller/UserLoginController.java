package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.entity.UserEntity;
import com.service.UserService;
import com.util.R;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@EnableEurekaClient
@RestController
@RequestMapping("/user")
public class UserLoginController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    private R getUser(@RequestBody JSONObject json){

        return R.ok();
    }

    @GetMapping("/login/{userId}")
    private R getUserById(@PathVariable String userId){

        return R.ok().put("user",userService.getById(userId));
    }



}
