package com.zane.bookadmin.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    public static final int STATUS_ENABLED = 0;
    public static final int STATUS_DISABLED = 1;


    private Long id;

    private String username;

    private String password;

    /**
     * 状态: 0: 启动 1: 禁用
     */
    private Integer status;

    private Long roleId;

    private Role role;

    private static final long serialVersionUID = 1L;
}