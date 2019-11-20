package com.yefei.securityweb.service.inte;

import com.yefei.securityweb.entity.SysUserRole;

import java.util.List;

/**
 * @Author: yefei
 * @Date: create in 2019-11-19
 * @Desc:
 */
public interface SysUserRoleService {
    List<SysUserRole> listByUserId(Integer userId);
}
