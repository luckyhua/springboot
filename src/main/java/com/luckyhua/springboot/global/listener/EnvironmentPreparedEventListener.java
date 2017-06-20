package com.luckyhua.springboot.global.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import java.util.Iterator;

/**
 * spring boot 对应enviroment已经准备完毕，
 * 但此时上下文context还没有创建。
 * 配置环境事件监听
 *
 * @author luckyhua
 * @version 1.0
 * @since 2017/6/20
 */
public class EnvironmentPreparedEventListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    private static final Logger log = LoggerFactory.getLogger(EnvironmentPreparedEventListener.class);

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        ConfigurableEnvironment environment = event.getEnvironment();
        MutablePropertySources mps = environment.getPropertySources();
        if (mps != null) {
            Iterator<PropertySource<?>> iterator = mps.iterator();
            while (iterator.hasNext()) {
                PropertySource<?> ps = iterator.next();
                log.info("ps.getName:{};ps.getSource:{};ps.getClass:{}", ps.getName(), ps.getSource(), ps.getClass());
            }
        }
    }
}
