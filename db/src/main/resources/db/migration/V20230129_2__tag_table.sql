CREATE TABLE `tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` DATETIME NOT NULL COMMENT '创建时间',
  `update_time` DATETIME NOT NULL COMMENT '修改时间',
  `create_user_id` bigint(20) unsigned NOT NULL COMMENT '创建用户id',
  `update_user_id` bigint(20) unsigned NOT NULL COMMENT '更新用户id',
  `code` varchar(32) NOT NULL UNIQUE COMMENT '编码',
  `name` varchar(32) NOT NULL COMMENT '名称',
  `description` varchar(64) NOT NULL COMMENT '描述',
  `parent_id` bigint(20) COMMENT '父标签id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='标签表';
