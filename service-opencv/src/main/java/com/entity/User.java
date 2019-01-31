package com.entity;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class User {

    private String userId;

    private String userName;

    private String password;

    private Timestamp create;

    private Timestamp lastModifyTime;

}
