package com.yefei.securityweb.service.inte;

import com.yefei.securityweb.entity.SysPermission;

import java.util.List;

public interface SysPermissionService {
     List<SysPermission> listByRoleId(Integer roleId);

    List<SysPermission> listByRoleIds(List<Integer> roleId);
}
