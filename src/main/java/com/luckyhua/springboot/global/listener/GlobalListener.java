package com.luckyhua.springboot.global.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 全局监听器
 *
 * @author    luckyhua
 * @date      2017/01/11
 * @version   1.0
 */
@WebListener
public class GlobalListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContext初始化");
        System.out.println(sce.getServletContext());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContext销毁");
    }
}
