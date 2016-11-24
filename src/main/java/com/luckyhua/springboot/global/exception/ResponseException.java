package com.luckyhua.springboot.global.exception;

import com.luckyhua.springboot.enums.ResultEnums;

/**
 * @author luckyhua
 * @date 2016/11/23
 * @description 响应异常
 */
public class ResponseException extends RuntimeException {

    private ResultEnums resultEnums;

    public ResultEnums getResultEnums() {
        return resultEnums;
    }

    public void setResultEnums(ResultEnums resultEnums) {
        this.resultEnums = resultEnums;
    }

    private ResponseException() {}

    public ResponseException(ResultEnums resultEnums) {
        super(resultEnums.getMsg());
        this.resultEnums = resultEnums;
    }

}
