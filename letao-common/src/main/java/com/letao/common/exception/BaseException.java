package com.letao.common.exception;

import com.letao.common.enums.ResultEnum;
import lombok.Getter;

/**
 * 自定义异常类
 */

@Getter
public class BaseException extends RuntimeException {

    private ResultEnum exceptionEnum;

    public BaseException(ResultEnum exceptionEnum) {
        this.exceptionEnum = exceptionEnum;
    }

}
