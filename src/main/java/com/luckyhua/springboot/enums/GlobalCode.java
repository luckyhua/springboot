package com.luckyhua.springboot.enums;

/**
 * @author luckyhua
 * @date 2016/11/23
 * @description 全局码
 */
public enum GlobalCode {

    NO_LOGIN(1000, "用户未登录!", "需要登录后操作"),
    PARAMS_NULL(1001, "参数为空!", "某些参数必填项");


    private final int code;
    private final String msg;
    private final String describe;

    GlobalCode(int code, String msg, String describe) {
        this.code = code;
        this.msg = msg;
        this.describe = describe;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public String getDescribe() {
        return describe;
    }

    public String toString() {
        return Integer.toString(this.code);
    }

    public static GlobalCode valueOf(int code) {
        GlobalCode[] var1 = values();
        int var2 = var1.length;

        for (int var3 = 0; var3 < var2; ++var3) {
            GlobalCode globalCode = var1[var3];
            if (globalCode.code == code) {
                return globalCode;
            }
        }

        throw new IllegalArgumentException("No matching constant for [" + code + "]");
    }

}
