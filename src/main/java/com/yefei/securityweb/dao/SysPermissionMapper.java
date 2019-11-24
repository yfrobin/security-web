package com.yefei.securityweb.dao;


import com.yefei.securityweb.entity.SysPermission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SysPermissionMapper {
    List<SysPermission> listByRoleId(@Param("roleId") Integer roleId);

    List<SysPermission> listByRoleIds(@Param("roleIds") List<Integer> roleIds);
}
