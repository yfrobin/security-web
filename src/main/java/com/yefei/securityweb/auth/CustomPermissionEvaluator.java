package com.yefei.securityweb.auth;

import com.yefei.securityweb.entity.SysPermission;
import com.yefei.securityweb.entity.SysRole;
import com.yefei.securityweb.service.inte.SysPermissionService;
import com.yefei.securityweb.service.inte.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {
    @Autowired
    private SysPermissionService permissionService;
    @Autowired
    private SysRoleService roleService;

    @Override
    public boolean hasPermission(Authentication authentication, Object targetUrl, Object targetPermission) {
        // 获得loadUserByUsername()中注入的角色
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        if (!CollectionUtils.isEmpty(authorities)) {
            List<String> roleNames = authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
            List<SysRole> roles = roleService.selectByNames(roleNames);
            if (!CollectionUtils.isEmpty(roles)) {
                List<Integer> roleId = roles.stream().map(SysRole::getId).collect(Collectors.toList());
                List<SysPermission> permissions = permissionService.listByRoleIds(roleId);

                for (SysPermission permission : permissions) {
                    if (targetUrl.equals(permission.getUrl()) && permission.getPermissions().contains(targetPermission)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        return false;
    }
}
