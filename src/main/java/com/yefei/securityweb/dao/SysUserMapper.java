package com.yefei.securityweb.dao;

import com.yefei.securityweb.entity.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author: yefei
 * @Date: create in 2019-11-19
 * @Desc:
 */
@Repository
public interface SysUserMapper {
    SysUser selectById(@Param("id") Integer id);

    SysUser selectByName(@Param("name") String name);
}
