package com.luckyhua.springboot.global.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author luckyhua
 * @date 2016/11/24
 * @description
 */
public class SessionUtils {

    //session有效期，单位s
    public static final Integer DEFAULT_SESSION_PERIOD = 600;

    public static Object getAttribute(HttpServletRequest request, String key) {
        return request.getSession().getAttribute(key);
    }

    public static void setAttribute(HttpServletRequest request, String key, Object value) {
        HttpSession httpSession = request.getSession();
        httpSession.setMaxInactiveInterval(DEFAULT_SESSION_PERIOD);
        httpSession.setAttribute(key, value);
    }

}
