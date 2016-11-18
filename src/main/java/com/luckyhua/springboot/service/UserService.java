package com.luckyhua.springboot.service;

import com.luckyhua.springboot.model.User;

import java.util.List;

/**
 * @author luckyhua
 * @date 2016/11/18
 * @description
 */
public interface UserService {

    /**
     * 添加一个用户
     * @param user 用户对象
     * @return 是否添加成功
     */
    boolean add(User user);

    /**
     * 查询所有用户
     * @return 返回用户列表
     */
    List<User> findAll();

}
