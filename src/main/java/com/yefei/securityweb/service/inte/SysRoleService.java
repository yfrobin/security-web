package com.yefei.securityweb.service.inte;

import com.yefei.securityweb.entity.SysRole;

import java.util.List;

/**
 * @Author: yefei
 * @Date: create in 2019-11-19
 * @Desc:
 */
public interface SysRoleService {
    SysRole selectById(Integer id);

    SysRole selectByName(String name);

    List<SysRole> selectByNames(List<String> roleNames);
}
