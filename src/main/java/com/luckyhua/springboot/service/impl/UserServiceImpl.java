package com.luckyhua.springboot.service.impl;

import com.luckyhua.springboot.model.User;
import com.luckyhua.springboot.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author luckyhua
 * @date 2016/11/18
 * @description
 */
@Service("userService")
public class UserServiceImpl implements UserService {



    @Override
    public boolean add(User user) {
        return false;
    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
