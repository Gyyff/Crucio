package com.heiqi.chat.entity;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.annotations.Select;

@Getter
@Setter
public class Manager {
    private Integer managerId;
    private String managerName;
    private String managerPassWord;

    /** 令牌*/
    private String token;
}
