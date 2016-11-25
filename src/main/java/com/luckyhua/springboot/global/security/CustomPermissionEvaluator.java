package com.luckyhua.springboot.global.security;

import com.luckyhua.springboot.model.User;
import com.luckyhua.springboot.service.auth.RoleService;
import com.luckyhua.springboot.service.auth.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

import java.io.Serializable;

/**
 * PreAuthorize("authenticated and hasPermission('hello', 'view')"): 表示只有当前已登录的并且拥有("hello", "view")权限的用户才能访问此页面
 * SecurityContextHolder.getContext().getAuthentication().getName(): 获取当前登录的用户，也可以通过HttpServletRequest.getRemoteUser()获取
 *
 * @author luckyhua
 * @date 2016/11/25
 * @description 自定义权限认证
 */
class CustomPermissionEvaluator implements PermissionEvaluator {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Override
    public boolean hasPermission(Authentication authentication, Object o, Object o1) {
        String userName = authentication.getName();
        User user = userService.findByUserName(userName);
        return roleService.authorized(user.getId(), targetDomainObject.toString(), permission.toString());
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        return false;
    }
}
