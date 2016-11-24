package com.luckyhua.springboot.global.session;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author luckyhua
 * @date 2016/11/24
 * @description
 */
@EnableRedisHttpSession
public class SessionConfig {

    @Bean
    public JedisConnectionFactory connectionFactory()
    {
        JedisConnectionFactory connection = new JedisConnectionFactory();
        connection.setPort(6397);
        connection.setHostName("192.168.1.146");
        return connection;
    }

}
