package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.entity.UserEntity;
import com.service.UserService;
import com.util.R;
import com.util.redis.RedisLockUtil;
import com.util.redis.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@EnableEurekaClient
@RestController
@RequestMapping("/user")
@Slf4j
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

    /**
     * RedisLockUtil.
     */
    @Autowired
    private RedisLockUtil redisLockUtil;

    /**
     * LOCK_KEY.
     */
    private static final String LOCK_KEY = "LOCK_CONTRACT";


    @GetMapping("/tryLock")
    public R isLock(String name) throws InterruptedException {
        //假设 这是一次巨量的修改或新增操作
        log.info("当前操作人:{}", name);
        boolean tryLock = redisLockUtil.tryLock(LOCK_KEY);
        if (tryLock) {
            RedisUtil.set("THIS_SERVER:" + LOCK_KEY, name);
            StopWatch watch = new StopWatch();

            watch.start();
            Thread.sleep(5000);
            watch.stop();
            log.info("【本次任务结束，消耗时间】：{}ms", watch.getTotalTimeMillis());

            redisLockUtil.releaseLock(LOCK_KEY);
            RedisUtil.del("THIS_SERVER:" + LOCK_KEY);
        } else {
            String thisName = RedisUtil.get("THIS_SERVER:" + LOCK_KEY);
            log.info("{}正在尝试该操作，请勿重复提交", thisName);
            return R.error(thisName + "正在尝试该操作，请勿重复提交");
        }

        return R.ok();
    }



}
