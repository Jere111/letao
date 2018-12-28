package com.letao.common.vo;

import com.letao.common.enums.ResultEnum;
import lombok.Data;

/**
 * 自定义异常结果类
 */

@Data
public class ResponseResult<T> {

    private int code;
    private String message;
    private T data;
    private long timestamp;

    public ResponseResult(ResultEnum resultEnum) {
        this.code = resultEnum.code();
        this.message = resultEnum.message();
        this.timestamp = System.currentTimeMillis();
    }

    public ResponseResult(ResultEnum resultEnum, T data) {
        this.code = resultEnum.code();
        this.message = resultEnum.message();
        this.data = data;
        this.timestamp = System.currentTimeMillis();
    }

}
