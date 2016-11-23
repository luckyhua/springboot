package com.luckyhua.springboot.controller;

import com.luckyhua.springboot.model.User;
import com.luckyhua.springboot.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author luckyhua
 * @date 2016/11/18
 * @description 测试demo
 */
@RestController
@RequestMapping("/demo/user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Resource(name = "userService")
    private UserService userService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ApiOperation(notes = "添加用户", value = "添加一个用户", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", paramType = "query", dataType = "string"),
            @ApiImplicitParam(name = "psw", paramType = "query", dataType = "string")
    })
    public User create(@RequestBody User user) {
        log.info("ZGH10040: user = {}", user);
        userService.add(user);
        return user;
    }

    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ApiOperation(notes = "查询所有用户", value = "查询所有用户列表", httpMethod = "GET")
    public List<User> get() {
        return userService.findAll();
    }

}
