package com.yefei.securityweb.service.impl;

import com.yefei.securityweb.dao.SysUserMapper;
import com.yefei.securityweb.entity.SysUser;
import com.yefei.securityweb.service.inte.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: yefei
 * @Date: create in 2019-11-19
 * @Desc:
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper userMapper;

    @Override
    public SysUser selectById(Integer id) {
        return userMapper.selectById(id);
    }

    @Override
    public SysUser selectByName(String name) {
        return userMapper.selectByName(name);
    }
}
