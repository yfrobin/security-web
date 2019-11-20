package com.yefei.securityweb.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: yefei
 * @Date: create in 2019-11-19
 * @Desc:
 */
@Data
public class SysUser implements Serializable {
    static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String password;
}
