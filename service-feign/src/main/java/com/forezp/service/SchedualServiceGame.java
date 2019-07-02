package com.forezp.service;

import com.forezp.service.hystric.SchedualServiceGameHystric;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "service-game",fallback = SchedualServiceGameHystric.class)
public interface SchedualServiceGame {
    @RequestMapping(value = "/game/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);

}
