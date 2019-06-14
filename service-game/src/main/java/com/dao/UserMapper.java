package com.dao;

import com.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User getUser(String password);

    int addUser(User user);
}
