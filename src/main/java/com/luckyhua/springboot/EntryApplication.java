package com.luckyhua.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author luckyhua
 * @date 2016/11/18
 * @description
 */
@MapperScan("com.luckyhua.springboot.dao.mapper")
@ServletComponentScan
@SpringBootApplication
public class EntryApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(EntryApplication.class, args);
    }

}
