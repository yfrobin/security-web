package com.yefei.securityweb.service.impl;

import com.yefei.securityweb.dao.SysRoleMapper;
import com.yefei.securityweb.entity.SysRole;
import com.yefei.securityweb.service.inte.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: yefei
 * @Date: create in 2019-11-19
 * @Desc:
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleMapper roleMapper;

    @Override
    public SysRole selectById(Integer id){
        return roleMapper.selectById(id);
    }

    @Override
    public SysRole selectByName(String name) {
        return roleMapper.selectByName(name);
    }

    @Override
    public List<SysRole> selectByNames(List<String> roleNames) {
        return roleMapper.selectByNames(roleNames);
    }

}
