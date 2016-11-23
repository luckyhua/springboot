package com.luckyhua.springboot.global.exception;

import com.luckyhua.springboot.enums.GlobalCode;

/**
 * @author luckyhua
 * @date 2016/11/23
 * @description 未登录异常
 */
public class FailException extends RuntimeException {

    private String msg;

    private Integer code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public FailException() {
        super();
    }

    public FailException(GlobalCode eEnum) {
        super(eEnum.getMsg());
    }

    public static void main(String[] args) {
        System.out.println(GlobalCode.NO_LOGIN.getDeclaringClass());
        throw new FailException(GlobalCode.NO_LOGIN);
    }
}
