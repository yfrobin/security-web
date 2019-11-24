CREATE TABLE IF NOT EXISTS `sys_user`
(
    id         INT(11)      NOT NULL AUTO_INCREMENT COMMENT 'id',
    name       VARCHAR(255) NOT NULL COMMENT '用户名称',
    password   VARCHAR(255) NOT NULL COMMENT '密码',
    gmt_create DATETIME     NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
    gmt_modify DATETIME     NOT NULL DEFAULT current_timestamp() COMMENT '修改时间',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
    COMMENT '用户表';


CREATE TABLE IF NOT EXISTS `sys_role`
(
    id        INT(11)      NOT NULL COMMENT 'id',
    name      VARCHAR(255) NOT NULL COMMENT '角色名称',
    gmt_create DATETIME     NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
    gmt_modify DATETIME     NOT NULL DEFAULT current_timestamp() COMMENT '修改时间',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
    COMMENT '角色表';

CREATE TABLE IF NOT EXISTS `sys_user_role`
(
    user_id    INT(11)  NOT NULL COMMENT '用户id',
    role_id    INT(11)  NOT NULL COMMENT '角色id',
    gmt_create DATETIME NOT NULL DEFAULT current_timestamp() COMMENT '创建时间',
    gmt_modify DATETIME NOT NULL DEFAULT current_timestamp() COMMENT '修改时间',
    PRIMARY KEY (user_id, role_id),
    KEY `fk_role_id` (role_id),
    CONSTRAINT `fk_role_id` FOREIGN KEY (role_id) REFERENCES `sys_role` (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT `fk_user_id` FOREIGN KEY (user_id) REFERENCES `sys_user` (id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
    COMMENT '用户-角色表';

CREATE TABLE `sys_permission`
(
    id         INT(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
    url        VARCHAR(255) DEFAULT NULL COMMENT 'url',
    role_id    INT(11)      DEFAULT NULL COMMENT '角色id',
    permission VARCHAR(255) DEFAULT NULL COMMENT '权限',
    gmt_create datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    gmt_modify datetime default CURRENT_TIMESTAMP not null comment '修改时间',
    PRIMARY KEY (id),
    KEY `fk_roleId` (role_id),
    CONSTRAINT `fk_roleId` FOREIGN KEY (role_id) REFERENCES `sys_role` (id) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB
  AUTO_INCREMENT = 5
  DEFAULT CHARSET = utf8
COMMENT '权限表';
