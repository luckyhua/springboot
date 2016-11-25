package com.luckyhua.springboot.service.auth;

import com.luckyhua.springboot.model.Role;
import java.util.List;

/**
 * @author luckyhua
 * @date 2016/11/25
 * @description
 */
public interface RoleService {

    List<Role> getUserRoles(Integer userId);

}
