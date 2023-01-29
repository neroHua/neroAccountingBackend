CREATE TABLE `accounting` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` DATETIME NOT NULL COMMENT '创建时间',
  `update_time` DATETIME NOT NULL COMMENT '修改时间',
  `create_user_id` bigint(20) unsigned NOT NULL COMMENT '创建用户id',
  `update_user_id` bigint(20) unsigned NOT NULL COMMENT '更新用户id',
  `user_id` bigint(20) unsigned NOT NULL COMMENT '账单用户',
  `bill_create_time` DATETIME NOT NULL COMMENT '账单创建时间',
  `bill_money` DOUBLE NOT NULL COMMENT '账单金额',
  `description` varchar(64) COMMENT '描述',
  `review_description` varchar(64) COMMENT '复盘描述',
  `valuable` TINYINT(1) COMMENT '是否值得',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='记账表';
