package com.luckyhua.springboot.global.exception.utils;

import com.luckyhua.springboot.enums.ResultEnums;
import com.luckyhua.springboot.global.exception.ResponseException;

/**
 * @author luckyhua
 * @date 2016/11/24
 * @description 异常工具类
 */
public class ExceptionUtils {

    public static void throwResponseException(ResultEnums resultEnums) throws ResponseException{
        throw new ResponseException(resultEnums);
    }

}
