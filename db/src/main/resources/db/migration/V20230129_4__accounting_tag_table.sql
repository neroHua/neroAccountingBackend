CREATE TABLE `accounting_tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` DATETIME NOT NULL COMMENT '创建时间',
  `update_time` DATETIME NOT NULL COMMENT '修改时间',
  `create_user_id` bigint(20) unsigned NOT NULL COMMENT '创建用户id',
  `update_user_id` bigint(20) unsigned NOT NULL COMMENT '更新用户id',
  `accounting_id` bigint(20) unsigned NOT NULL COMMENT '记账id',
  `tag_id` bigint(20) unsigned NOT NULL COMMENT '标签id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='记账标签关联表';
