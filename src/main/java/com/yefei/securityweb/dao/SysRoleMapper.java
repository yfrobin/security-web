package com.yefei.securityweb.dao;

import com.yefei.securityweb.entity.SysRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: yefei
 * @Date: create in 2019-11-19
 * @Desc:
 */
@Repository
public interface SysRoleMapper {
    SysRole selectById(@Param("id") Integer id);

    SysRole selectByName(@Param("name") String name);

    List<SysRole> selectByNames(@Param("roleNames") List<String> roleNames);
}
