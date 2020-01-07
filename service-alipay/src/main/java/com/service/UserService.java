package com.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.entity.UserEntity;
import com.util.PageUtils;

import java.util.Map;

public interface UserService extends IService<UserEntity> {

    PageUtils queryPage(Map<String, Object> params);
}
