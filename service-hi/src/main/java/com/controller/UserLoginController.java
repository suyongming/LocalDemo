package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.dao.UserMapper;
import com.entity.User;
import com.netflix.discovery.converters.Auto;
import com.util.ResultBean;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class UserLoginController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private HttpServletRequest request;

    @PostMapping("/login")
    private ResultBean getUser(@RequestBody JSONObject json){
        ResultBean result = new ResultBean();
        result.setData(userMapper.getUser(json.getString("password")));
        return result;
    }

    @PostMapping("/register")
    private ResultBean registerUser(@RequestBody User user){
        ResultBean result = new ResultBean();
        user.setUserId(UUID.randomUUID().toString().replace("-",""));
        result.setData(userMapper.addUser(user)>0);
        return result;
    }

    @GetMapping("/checkSession")
    public ResultBean getSession(String name){
        ResultBean result = new ResultBean();
        String flag = (String)request.getSession().getAttribute("admin");
        if(StringUtils.isBlank(flag)){
            request.getSession().setAttribute("admin","admin");
            result.setMsg("第一次登录");
            request.getSession().setMaxInactiveInterval(30);


        }else{
            result.setData(request.getSession().getAttribute("admin"));
        }

        return result;
    }

//    @GetMapping("/checkCookie")
//    public ResultBean getCookie(){
//        ResultBean result = new ResultBean();
//        Cookie[] cookies = request.getCookies();
//        if(cookies != null){
//            for(Cookie cookie: cookies){
//                if(cookie.getName().equals("lastAccessTime")){
//                    result.setMsg("您上一次访问时间为："+cookie);
//                }
//            }
//
//
//        }else{
//            result.setMsg("第一次登录,加入cookie");
//            Cookie cookie = new Cookie("lastAccessTime",System.currentTimeMillis()+"");
//            response.addCookie(cookie);
//            result.setData(cookie);
//        }
//
//        return result;
//    }
}
