package com.yefei.securityweb.service.impl;

import com.yefei.securityweb.dao.SysPermissionMapper;
import com.yefei.securityweb.entity.SysPermission;
import com.yefei.securityweb.service.inte.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysPermissionServiceImpl implements SysPermissionService {

    @Autowired
    private SysPermissionMapper permissionMapper;

    /**
     * 获取指定角色所有权限
     */
    @Override
    public List<SysPermission> listByRoleId(Integer roleId) {
        return permissionMapper.listByRoleId(roleId);
    }

    @Override
    public List<SysPermission> listByRoleIds(List<Integer> roleIds) {
        return permissionMapper.listByRoleIds(roleIds);
    }
}
