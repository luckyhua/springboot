package com.luckyhua.springboot.global.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 登录认证
 *
 * @author luckyhua
 * @version 1.0
 * @date 2017/3/21
 */
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

//    @Autowired
//    private TokenHelper tokenHelper;
//
//    @Override
//    public boolean preHandle(HttpServletRequest request,
//                             HttpServletResponse response,
//                             Object o) throws Exception {
//        if (!tokenHelper.isLogin(tokenHelper.getToken(request))) {
//            ExceptionUtils.throwResponseException(PublicEnums.USER_NO_LOGIN);
//        }
//        return true;
//    }
}
