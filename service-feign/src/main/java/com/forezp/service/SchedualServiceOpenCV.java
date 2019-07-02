package com.forezp.service;

import com.forezp.service.hystric.SchedualServiceHiHystric;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "service-openCV",fallback = SchedualServiceHiHystric.class)
public interface SchedualServiceOpenCV {
    @RequestMapping(value = "/openCV/hi",method = RequestMethod.GET)
    String hi(@RequestParam(value = "name") String name);


}
