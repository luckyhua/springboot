package com.luckyhua.springboot.global.security;

import com.luckyhua.springboot.service.auth.RoleService;
import com.luckyhua.springboot.service.auth.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;

/**
 * PreAuthorize("authenticated and hasPermission('hello', 'view')"): 表示只有当前已登录的并且拥有("hello", "view")权限的用户才能访问此页面
 * SecurityContextHolder.getContext().getAuthentication().getName(): 获取当前登录的用户，也可以通过HttpServletRequest.getRemoteUser()获取
 *
 * @author luckyhua
 * @date 2016/11/25
 * @description 自定义权限认证
 */
class CustomPermissionEvaluator implements PermissionEvaluator {


    @Resource(name="permissionsMap")
    private Map permissionsMap;

    @Resource(name="roleHierarchy")
    private RoleHierarchy roleHierarchy;

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        return hasPermission(getRole(authentication), permission, targetDomainObject);
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String targetDomainObject, Object permission) {
        return false;
    }

    /**
     * Retrieves the user's highest role
     */
    private String getRole(Authentication authentication) {
        String highestRole = null;

        try {
            Set<GrantedAuthority> authorities = (Set<GrantedAuthority>) roleHierarchy.getReachableGrantedAuthorities(authentication.getAuthorities());
            for (GrantedAuthority auth: authorities) {
                highestRole = auth.getAuthority();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return highestRole;
    }

    private Boolean hasPermission(String role, Object permission, Object domain) {
        if (permissionsMap.containsKey(role) ) {
            Permission userPermission = (Permission) permissionsMap.get(role);

            if (userPermission.getObjects().containsKey(domain.getClass().getName())){

                for (String action : userPermission.getObjects().get(domain.getClass().getName()) ) {
                    if (action.equals(permission)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
