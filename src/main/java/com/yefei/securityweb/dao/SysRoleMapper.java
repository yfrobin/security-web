package com.yefei.securityweb.dao;

import com.yefei.securityweb.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Author: yefei
 * @Date: create in 2019-11-19
 * @Desc:
 */
@Repository
public interface SysRoleMapper {
    @Select("SELECT * FROM sys_role WHERE id = #{id}")
    SysRole selectById(Integer id);
}
