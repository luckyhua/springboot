package com.luckyhua.springboot.global.exception;

import com.luckyhua.springboot.enums.ExceptionEnums;

/**
 * @author luckyhua
 * @date 2016/11/23
 * @description 响应异常
 */
public class ResponseException extends RuntimeException {

    private ExceptionEnums exceptionEnums;

    public ExceptionEnums getExceptionEnums() {
        return exceptionEnums;
    }

    public void setExceptionEnums(ExceptionEnums exceptionEnums) {
        this.exceptionEnums = exceptionEnums;
    }

    private ResponseException() {}

    public ResponseException(ExceptionEnums exceptionEnums) {
        super(exceptionEnums.getMsg());
    }

}
