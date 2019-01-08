
-- 创建文章表
drop table if exists `article`;
CREATE TABLE `article` (
	`id` varchar(19) NOT NULL,
	`column_id` varchar(19) COMMENT '专栏ID',
	`channel_id` varchar(19) COMMENT '频道ID',
	`user_id` varchar(19) NOT NULL COMMENT '用户ID',
	`nickname` varchar(32) NOT NULL COMMENT '用户昵称',
	`title` varchar(32) NOT NULL COMMENT '文章标题',
	`content` text DEFAULT NULL COMMENT '文章内容',
	`image` varchar(32) NOT NULL COMMENT '文章封面图片路径',
	`create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发表时间',
	`update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
	`openly` tinyint(1) NOT NULL COMMENT '是否公开 0:不公开,1:公开',
	`istop` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否置顶 0:否,1:是',
	`visits` bigint(20) DEFAULT 0 COMMENT '游览量',
	`thumbup` bigint(20) DEFAULT 0 COMMENT '点赞数',
	`comment` bigint(20) DEFAULT 0 COMMENT '评论数',
	`state` tinyint(1) default 1 comment '审核状态，0未审核 1已审核',
	`type` tinyint(1) COMMENT '文章类型，0:分享 1:专栏',
	`url` varchar(64) NOT NULL COMMENT '文章URL地址',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT '文章服务-文章表';