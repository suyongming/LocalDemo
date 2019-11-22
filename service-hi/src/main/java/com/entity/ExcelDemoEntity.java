package com.entity;


import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@Data
public class ExcelDemoEntity {


    @Excel(name = "id" ,orderNum = "0")
    private String id;

    @Excel(name = "姓名" ,orderNum = "1")
    private String name;

    @Excel(name = "年纪" ,orderNum = "2")
    private String age;

    /**
     * 性别 0:男 1:女
     * */
    @Excel(name = "性别" ,orderNum = "3")
    private String gender;

    @Excel(name = "身份证" ,orderNum = "4")
    private String identity;

    @Excel(name = "手机" ,orderNum = "5")
    private String mobile;

    @Excel(name = "邮箱" ,orderNum = "6")
    private String email;

    @Excel(name = "地址" ,orderNum = "7")
    private String road;

    @Excel(name = "创建日期" ,orderNum = "8",exportFormat = "yyyy-MM-dd HH:mm:ss")//importFormat = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
}
