package com.forezp.web;

import com.forezp.service.SchedualServiceHi;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;


@RestController
@Api(value="测试模块",tags={"测试模块"})//接口简要标注，对中文的支持不太好
public class HiController {

    @Autowired
    SchedualServiceHi schedualServiceHi;

    @ApiOperation(value="eureka测试", notes="eureka测试")
    @GetMapping(value = "/hi")
    public String sayHi(HttpServletRequest request,@ApiParam(name="name",value="回显的用户名",required=true)String name){
        request.getSession().setAttribute("userName",name);
        return schedualServiceHi.sayHiFromClientOne(name);
    }

    @GetMapping(value = "/user/login/{userId}")
    public String getUser(@PathVariable(value = "userId") String userId){
        return schedualServiceHi.getUserById(userId);
    }
}
