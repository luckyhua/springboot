package com.luckyhua.springboot.global.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

import javax.servlet.annotation.WebListener;

/**
 * spring boot启动开始时执行的事件
 *
 * @author luckyhua
 * @version 1.0
 * @since 2017/6/20
 */
@WebListener
public class StartedEventListener implements ApplicationListener<ApplicationStartedEvent> {

    private static final Logger log = LoggerFactory.getLogger(StartedEventListener.class);

    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        log.info("spring boot before start ...");
    }
}
