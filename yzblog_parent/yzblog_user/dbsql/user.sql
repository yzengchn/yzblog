-- 管理员用户表
drop table if exists `admin_user`;
CREATE TABLE `admin_user`(
	`id` varchar(20) NOT NULL,
	`login_name` varchar(32) NOT NULL COMMENT '登录名',
	`password` varchar(32) NOT NULL COMMENT '密码',
	`state` tinyint(1) DEFAULT NULL COMMENT '状态',
	PRIMARY KEY(`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '管理员表';

-- 用户表
drop table if exists `user`;
CREATE TABLE `user`(
  `id` varchar(20) NOT NULL,
  `mobile` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `login_name` varchar(32) DEFAULT NULL COMMENT 登录名',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `nickname` varchar(64) DEFAULT NULL COMMENT '昵称',
  `sex` tinyint(1) DEFAULT 0 COMMENT '性别(0：未知，1：男，2：女)',
  `birthday` datetime DEFAULT NULL COMMENT '出生年月日',
  `avatar` varchar(100) DEFAULT NULL COMMENT '头像',
  `email` varchar(32) DEFAULT NULL COMMENT 'E-Mail',
  `regdate` datetime DEFAULT NULL COMMENT '注册日期',
  `updatedate` datetime DEFAULT NULL COMMENT '修改日期',
  `lastdate` datetime DEFAULT NULL COMMENT '最后登陆日期',
  `online` bigint(20) DEFAULT NULL COMMENT '在线时长（分钟）',
  `interest` varchar(255) DEFAULT NULL COMMENT '兴趣',
  `personality` varchar(255) DEFAULT NULL COMMENT '个性',
  `fanscount` int(20) DEFAULT NULL COMMENT '粉丝数',
  `followcount` int(20) DEFAULT NULL COMMENT '关注数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';


drop table if exists `follow`;
CREATE TABLE `follow` (
  `user_id` varchar(20) NOT NULL COMMENT '用户ID',
  `target_user_id` varchar(20) NOT NULL COMMENT '被关注用户ID',
  PRIMARY KEY (`user_id`,`target_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='关注用户表';

