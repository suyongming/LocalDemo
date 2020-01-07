package com.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
//@TableName("sym_market.order_master")
public class UserEntity {

    private String userId;

    private String userName;

    private String password;

    private Date create;

    private Date lastModifyTime;

}
