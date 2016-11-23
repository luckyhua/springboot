package com.luckyhua.springboot.service.impl;

import com.luckyhua.springboot.dao.mapper.UserMapper;
import com.luckyhua.springboot.model.User;
import com.luckyhua.springboot.model.UserExample;
import com.luckyhua.springboot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author luckyhua
 * @date 2016/11/18
 * @description 用户业务层
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserMapper userMapper;

    public void add(User user) {
        log.info("ZGH10020: add user ...");
        userMapper.insertSelective(user);
    }

    @Override
    public List<User> findAll() {
        return userMapper.selectByExample(new UserExample());
    }
}
