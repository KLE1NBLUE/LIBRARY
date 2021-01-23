package com.zane.bookadmin.util;

import lombok.Data;

@Data
public class Result {
    private boolean flag;
    private String message;
    private Object data;

    // 接口调用失败时使用
    public Result(String message) {
        this.flag = false;
        this.message = message;
    }

    // 接口调用成功时使用
    public Result(String message, Object data) {
        this.flag = true;
        this.message = message;
        this.data = data;
    }
}
