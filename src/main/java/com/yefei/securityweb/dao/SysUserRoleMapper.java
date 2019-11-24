package com.yefei.securityweb.dao;

import com.yefei.securityweb.entity.SysUserRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: yefei
 * @Date: create in 2019-11-19
 * @Desc:
 */
@Repository
public interface SysUserRoleMapper {
    List<SysUserRole> listByUserId(@Param("userId") Integer userId);
}
