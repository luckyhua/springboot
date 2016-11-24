package com.luckyhua.springboot.global.exception.utils;

import com.luckyhua.springboot.enums.ExceptionEnums;
import com.luckyhua.springboot.global.exception.ResponseException;

/**
 * @author luckyhua
 * @date 2016/11/24
 * @description 异常工具类
 */
public class ExceptionUtils {

    public static void throwResponseException(ExceptionEnums exceptionEnums) throws ResponseException{
        throw new ResponseException(exceptionEnums);
    }

}
