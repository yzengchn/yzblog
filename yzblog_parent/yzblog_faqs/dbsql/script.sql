

-- 创建问题表
drop table if exists `tb_problem`;
CREATE TABLE `tb_problem` (
	`id` varchar(19) NOT NULL,
	`user_id` varchar(19) NOT NULL COMMENT '发布人ID',
	`nickname` varchar(32) NOT NULL COMMENT '发布人昵称',
	`title` varchar(64) NOT NULL COMMENT '问题标题',
	`content` text DEFAULT NULL COMMENT '问题内容',
	`visits` bigint(20) DEFAULT 0 COMMENT '游览量',
	`thumbup` bigint(20) DEFAULT 0 COMMENT '点赞数',
	`reply` bigint(20) DEFAULT 0 COMMENT '回复数',
	`solve` tinyint(1) default 1 comment '是否解决，0已解决 1未解决',
	`state` varchar(10) DEFAULT NULL COMMENT '状态',
	`reply_name` varchar(32) COMMENT '最新回复人',
	`reply_time` timestamp COMMENT '最新回复时间',
	`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '文章发布时间',
	`update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '文章更新时间',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '问答服务-问题表';

drop table if exists `tb_reply`;
CREATE TABLE `tb_reply` (
	`id` varchar(19) NOT NULL,
	`problem_id` varchar(19) NOT NULL COMMENT '问题ID',
	`user_id` varchar(19) NOT NULL COMMENT '回答人ID',
	`nickname` varchar(32) NOT NULL COMMENT '回答人昵称',
	`content` text DEFAULT NULL COMMENT '回答内容',
	`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '回答时间',
	`update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '问答服务-回答表';

drop table if exists `problem_label`;
CREATE TABLE `problem_label` (
	`problem_id` varchar(19) NOT NULL COMMENT '问题ID',
	`label_id` varchar(19) NOT NULL COMMENT '标签ID'
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '问答服务-问题-标签中间表';
