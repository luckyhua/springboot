package com.luckyhua.springboot.global.session;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

/**
 * @author luckyhua
 * @date 2016/11/24
 * @description
 */
public class SessionInitializer extends AbstractHttpSessionApplicationInitializer {

    public SessionInitializer() {
        super(SessionConfig.class);
    }
}
