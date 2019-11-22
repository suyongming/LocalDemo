package com.forezp.service.hystric;

import com.forezp.service.SchedualServiceHi;
import org.springframework.stereotype.Component;


@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }

    @Override
    public String getUserById(String userId) {
        return "sorry "+userId;
    }
}
