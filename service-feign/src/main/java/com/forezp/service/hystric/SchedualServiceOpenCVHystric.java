package com.forezp.service.hystric;

import com.forezp.service.SchedualServiceHi;
import com.forezp.service.SchedualServiceOpenCV;
import org.springframework.stereotype.Component;


@Component
public class SchedualServiceOpenCVHystric implements SchedualServiceOpenCV {
    @Override
    public String hi(String name) {
        return "sorry "+name;
    }

}
