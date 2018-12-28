package com.letao.common.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 请求结果枚举类
 */


@NoArgsConstructor
@AllArgsConstructor
public enum ResultEnum {

    SUCCESS(200, "操作成功"),
    ERROR(500, "服务异常"),
    AUTH10011041(10011041, "页面已过期,请重新登录"),
    AUTH10011040(10011040, "解析header失败")
    ;
    int code;
    String message;

    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }
}
