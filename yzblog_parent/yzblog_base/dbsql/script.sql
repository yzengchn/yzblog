
-- 创建标签表
drop table if exists `label`;
CREATE TABLE `label` (
  `id` varchar(19) NOT NULL,
	`labelname` varchar(32) NOT NULL COMMENT '标签名称',
  `count` bigint(20) DEFAULT 0 COMMENT '使用数量',
  `fans` bigint(20) DEFAULT 0 COMMENT '关注数',
  `recommend` varchar(2) DEFAULT NULL COMMENT '是否推荐',
  `state` varchar(10) DEFAULT NULL COMMENT '状态',
	`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '标签表';


