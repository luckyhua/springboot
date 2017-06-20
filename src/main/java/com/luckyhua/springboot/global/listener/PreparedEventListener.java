package com.luckyhua.springboot.global.listener;

import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * spring boot上下文context创建完成，
 * 但此时spring中的bean是没有完全加载完成的。
 * 上下文创建完成后执行的事件监听器
 * 在获取完上下文后，可以将上下文传递出去做一些额外的操作。
 * 在该监听器中是无法获取自定义bean并进行操作的。
 *
 * @author luckyhua
 * @version 1.0
 * @since 2017/6/20
 */
public class PreparedEventListener implements ApplicationListener<ApplicationPreparedEvent> {

    @Override
    public void onApplicationEvent(ApplicationPreparedEvent event) {
        ConfigurableApplicationContext cac = event.getApplicationContext();
        passContextInfo(cac);
    }

    /**
     * 传递上下文
     * @param act
     */
    private void passContextInfo(ApplicationContext act) {
        //do something()
    }

}
