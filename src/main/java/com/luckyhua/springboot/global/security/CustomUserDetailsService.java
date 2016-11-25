package com.luckyhua.springboot.global.security;

import com.luckyhua.springboot.model.User;
import com.luckyhua.springboot.service.auth.RoleService;
import com.luckyhua.springboot.service.auth.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Principle(user), Authority(role)
 *
 * @author luckyhua
 * @date 2016/11/25
 * @description 自定义用户和角色控制
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Resource(name = "userService")
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        if (StringUtils.isBlank(userName)) {
            throw new UsernameNotFoundException("userName is null!");
        }

        User user = userService.findByUserName(userName);
        Optional<User> optional = Optional.ofNullable(user);
        optional.orElseThrow(() -> new UsernameNotFoundException("user is not exist!"));

        Set<GrantedAuthority> authorities = new HashSet<>();
        roleService.getUserRoles(user.getId()).forEach(r ->
                authorities.add(new SimpleGrantedAuthority("ROLE_"+ r.getName()))
        );

        return new org.springframework.security.core.userdetails.User(
                userName, user.getPassword(),
                true,//是否可用
                true,//是否过期
                true,//证书不过期为true
                true,//账户未锁定为true
                authorities);

    }

}
