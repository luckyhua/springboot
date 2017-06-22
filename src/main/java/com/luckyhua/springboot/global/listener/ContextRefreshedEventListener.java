package com.luckyhua.springboot.global.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * spring容器初始化完成监听事件
 *
 * @author luckyhua
 * @version 1.0
 * @since 2017/5/26
 */
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {

    private static Logger log = LoggerFactory.getLogger(ContextRefreshedEventListener.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        // root application context
//        contextRefreshedEvent.getApplicationContext().getDisplayName().equals("Root WebApplicationContext")
        if(null == contextRefreshedEvent.getApplicationContext().getParent()) {
            log.debug(">>>>> spring初始化完毕 <<<<<");
            // spring初始化完毕后，通过反射调用所有使用InitMapper注解的initMapper方法
//            Map<String, Object> services = contextRefreshedEvent.getApplicationContext().getBeansWithAnnotation(InitMapper.class);
//            for(Object service : services.values()) {
//                log.debug(">>>>> {}.initMapper()", service.getClass().getName());
//                try {
//                    Method initMapper = service.getClass().getMethod("initMapper");
//                    initMapper.invoke(service);
//                } catch (Exception e) {
//                    log.error("初始化service的initMapper方法异常", e);
//                    e.printStackTrace();
//                }
//            }
        }
    }
}
