package com.yefei.securityweb.service.impl;

import com.yefei.securityweb.dao.SysUserRoleMapper;
import com.yefei.securityweb.entity.SysUserRole;
import com.yefei.securityweb.service.inte.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: yefei
 * @Date: create in 2019-11-19
 * @Desc:
 */
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {

    @Autowired
    private SysUserRoleMapper userRoleMapper;

    @Override
    public List<SysUserRole> listByUserId(Integer userId) {
        return userRoleMapper.listByUserId(userId);
    }
}
