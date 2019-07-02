package com.forezp.service.hystric;

import com.forezp.service.SchedualServiceGame;
import com.forezp.service.SchedualServiceOpenCV;
import org.springframework.stereotype.Component;


@Component
public class SchedualServiceGameHystric implements SchedualServiceGame {

    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}
