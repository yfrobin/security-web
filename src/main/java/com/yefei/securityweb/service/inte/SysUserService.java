package com.yefei.securityweb.service.inte;

import com.yefei.securityweb.entity.SysUser;

/**
 * @Author: yefei
 * @Date: create in 2019-11-19
 * @Desc:
 */
public interface SysUserService {
    SysUser selectById(Integer id);

    SysUser selectByName(String username);
}
