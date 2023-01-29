CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` DATETIME NOT NULL COMMENT '创建时间',
  `update_time` DATETIME NOT NULL COMMENT '修改时间',
  `create_user_id` bigint(20) unsigned NOT NULL COMMENT '创建用户id',
  `update_user_id` bigint(20) unsigned NOT NULL COMMENT '更新用户id',
  `user_id` varchar(12) NOT NULL UNIQUE COMMENT '账户id',
  `password` varchar(12) NOT NULL COMMENT '登录密码',
  `nick_name` varchar(50) NOT NULL COMMENT '昵称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='用户表';
