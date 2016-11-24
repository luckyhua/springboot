package com.luckyhua.springboot.global.exception;

import com.luckyhua.springboot.global.context.json.ResponseInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author luckyhua
 * @date 2016/11/24
 * @description
 */
@RestController
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object defaultExceptionHandler(HttpServletRequest req, Exception e) throws Exception {
        log.error("ZGH10060: DefaultException Handler---Host {} invokes url {} ERROR: {}",
                req.getRemoteHost(), req.getRequestURL(), e.getMessage());
        return e.getMessage();
    }

    @ExceptionHandler(value = ResponseException.class)
    @ResponseBody
    public Object responseExceptionHandler(HttpServletRequest req, ResponseException e) throws Exception {
        log.error("ZGH10060: ResponseException Handler---Host {} invokes url {} ERROR: {}",
                req.getRemoteHost(), req.getRequestURL(), e.getMessage());
        return new ResponseInfo(e.getResultEnums());
    }
}
