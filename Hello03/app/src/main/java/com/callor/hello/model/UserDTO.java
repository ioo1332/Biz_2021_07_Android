package com.callor.hello.model;

import java.io.Serializable;

/**
 * Activity 간에 extra 로 DTO(VO)를 넘기기 위해서
 * Serializable interface 설정
 */
public class UserDTO implements Serializable {
    public String user_id;
    public String password;
    public String tel;
    public String addr;
}
