package com.luckyhua.springboot.controller;

import com.luckyhua.springboot.cache.redis.RedisUtil;
import com.luckyhua.springboot.common.utils.AssertUtils;
import com.luckyhua.springboot.enums.PublicEnums;
import com.luckyhua.springboot.global.context.json.ResponseInfo;
import com.luckyhua.springboot.global.context.utils.ResponseUtils;
import com.luckyhua.springboot.global.session.SessionUtils;
import com.luckyhua.springboot.model.User;
import com.luckyhua.springboot.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ApiOperation(notes = "添加用户", value = "添加一个用户", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", paramType = "query", dataType = "string"),
            @ApiImplicitParam(name = "psw", paramType = "query", dataType = "string")
    })
    public User create(@RequestBody User user, HttpServletRequest request) {
        log.info("ZGH10040: user = {}", user);
        AssertUtils.notNull(PublicEnums.PARAMS_IS_NULL, user.getName());
        userService.add(user);
        SessionUtils.setAttribute(request, "user", user);
        return user;
    }

    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ApiOperation(notes = "查询所有用户", value = "查询所有用户列表", httpMethod = "GET")
    public ResponseInfo get(Integer offset, Integer limit, HttpServletRequest request) {
        User user = (User) SessionUtils.getAttribute(request, "user");
        ResponseInfo responseInfo = ResponseUtils.buildResponseInfo();
        responseInfo.putData("userList", userService.findAll(offset, limit));
        responseInfo.putData("user", user);
        return responseInfo;
    }

    @RequestMapping("/test")
    @Cacheable(value = "test")
    public String getSessionId(){
        redisUtil.set("123", "测试");
        String test = redisUtil.get("123").toString();
        return test;
    }

}
