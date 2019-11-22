package com.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.sql.Timestamp;

@Getter
@Setter
@TableName("sym_market.order_master")
public class UserEntity {

    @Excel(name = "id" ,orderNum = "0")
    private String userId;

    @Excel(name = "姓名" ,orderNum = "1")
    private String userName;

    @Excel(name = "密码" ,orderNum = "2")
    private String password;

    @Excel(name = "添加时间" ,orderNum = "3",exportFormat = "yyyy-MM-dd HH:mm:ss")//exportFormat = "yyyy-MM-dd HH:mm:ss")
    private Date create;

    @Excel(name = "修改时间" ,orderNum = "4",exportFormat = "yyyy-MM-dd HH:mm:ss")//exportFormat = "yyyy-MM-dd HH:mm:ss")
    private Date lastModifyTime;

}
