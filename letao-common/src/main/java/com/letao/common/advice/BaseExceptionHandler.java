package com.letao.common.advice;

import com.letao.common.exception.BaseException;
import com.letao.common.vo.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 拦截自定义异常处理类
 */

@Slf4j
@ControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseResult handleException(BaseException e) {
        return new ResponseResult(e.getExceptionEnum());
    }

}
