package com.forezp.web;

import com.forezp.service.SchedualServiceGame;
import com.forezp.service.SchedualServiceHi;
import com.forezp.service.SchedualServiceOpenCV;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("game")
public class GameController {

    @Autowired
    SchedualServiceGame schedualServiceGame;


    @GetMapping(value = "/hi")
    public String sayHi(HttpServletRequest request,String name){
        request.getSession().setAttribute("userName",name);
        return schedualServiceGame.sayHiFromClientOne(name);
    }

}
