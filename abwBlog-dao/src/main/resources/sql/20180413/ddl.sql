
#创建数据块
CREATE DATABASE `abw_blog` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

create table abw_user(
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  user_name VARCHAR(200) DEFAULT  null COMMENT '用户姓名',
  nick_name VARCHAR(200) DEFAULT  null COMMENT '用户昵称',
  mobie VARCHAR(20) DEFAULT null COMMENT '手机号',
  email VARCHAR(100) DEFAULT NULL COMMENT '邮箱',
  current_address VARCHAR(200) DEFAULT NULL COMMENT '当前地址',
  born_address VARCHAR(200) DEFAULT NULL COMMENT '出生地址',
  loves VARCHAR(500) DEFAULT NULL COMMENT '多个喜好，以竖线|分割',
  password VARCHAR(100) DEFAULT NULL COMMENT '密码,使用md5加密',
  signature VARCHAR(400) DEFAULT NULL COMMENT '个性签名',
  status VARCHAR(1) DEFAULT '0' COMMENT '用户状态：0-禁用，1-已激活，2-已实名',
  role_id BIGINT(20) DEFAULT null COMMENT '角色ID',
  source_id VARCHAR(40) DEFAULT  NULL COMMENT '注册渠道',
  fans_count BIGINT(20) DEFAULT 0 COMMENT '粉丝(关注)数',
  support_count BIGINT(20) DEFAULT 0 COMMENT '点赞数',
  comment_count BIGINT(20) DEFAULT 0 COMMENT '评论数',
  gender VARCHAR(2) DEFAULT NULL  COMMENT '性别：M-男，F-女',
  last_login_time timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '上一次登陆时间',
  `avatar` varchar(255) DEFAULT '/assets/images/ava/default.png' COMMENT '用户图像',
  `create_by` varchar(64) DEFAULT 'sys' COMMENT '创建人',
  `create_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
  `modify_by` varchar(64) DEFAULT 'sys' COMMENT '修改人',
  `modify_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '修改时间',
  remark  varchar(200) DEFAULT 'sys' COMMENT '备注',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB  DEFAULT CHARSET=utf8;



create table abw_content(
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  source VARCHAR(20) DEFAULT "orginal" COMMENT '内容来源:orginal-原创，reproduce-转载',
  category VARCHAR(20) DEFAULT NULL COMMENT '内容分类:博客，提问等',
  title VARCHAR(200) DEFAULT  null COMMENT '标题',
  theme_image VARCHAR(800) DEFAULT NULL COMMENT '主题图片',
  theme_video VARCHAR(800) DEFAULT NULL COMMENT '主题视频',
  content TEXT DEFAULT null COMMENT '内容',
  tags VARCHAR(200) DEFAULT NULL COMMENT '标签，多个以|分割',
  user_id bigint(20) NOT NULL COMMENT '用户ID',
  `create_by` varchar(64) DEFAULT 'sys' COMMENT '创建人',
  `create_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
  `modify_by` varchar(64) DEFAULT 'sys' COMMENT '修改人',
  `modify_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '修改时间',
  PRIMARY KEY (`id`)
)ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT '内容表';


CREATE TABLE `abw_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `config_type` varchar(100) DEFAULT '' COMMENT '配置类型:nav',
  `config_type_name` varchar(100) DEFAULT '' COMMENT '配置类型名:导航',
  `config_key` varchar(200) NOT NULL COMMENT '配置key',
  `config_val` varchar(300) DEFAULT '' COMMENT '配置val',
  `priority` bigint(20) DEFAULT '0' COMMENT '优先级',
  `parent_config_id` bigint(20) DEFAULT NULL,
  `ext_map` varchar(500) DEFAULT '' COMMENT '配置扩展,形如: k1=v1|k2=v2',
  `create_by` varchar(64) DEFAULT 'sys' COMMENT '创建人',
  `create_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
  `modify_by` varchar(64) DEFAULT 'sys' COMMENT '修改人',
  `modify_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='配置表';

#abw_config中config_type和config_key添加唯一联合索引
alter table abw_config add UNIQUE index index_config_type_key (config_type,config_key);


#add at 20180503
create table abw_comment(
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  comment_user_id bigint(20) NOT NULL COMMENT '评论者用户ID',
  comment_user_name VARCHAR(200) DEFAULT  null COMMENT '评论者用户姓名',
  comment_content TEXT DEFAULT null COMMENT '评论内容',
  to_user_id bigint(20) NOT NULL COMMENT '被评论的用户ID',
  to_user_name VARCHAR(200) DEFAULT  null COMMENT '用户姓名',
  to_comment_id bigint(20) DEFAULT NULL COMMENT '被评论的评论Id',
  content_id bigint(20) NOT NULL COMMENT '被评论的内容Id',
  floor_num bigint(20) NOT NULL COMMENT '楼层数',
  forbid_flag VARCHAR(1) DEFAULT 'N' COMMENT '是否被禁止：Y-禁用，N-可用',
  `create_by` varchar(64) DEFAULT 'sys' COMMENT '创建人',
  `create_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) COMMENT '创建时间',
  `modify_by` varchar(64) DEFAULT 'sys' COMMENT '修改人',
  `modify_time` timestamp(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3) ON UPDATE CURRENT_TIMESTAMP(3) COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评论表';

ALTER TABLE abw_content ADD view_num bigint(20) DEFAULT 0 COMMENT '阅读数';
ALTER TABLE abw_content ADD comment_num bigint(20) DEFAULT 0 COMMENT '评论数';

#add by fhb at 20180504
ALTER TABLE abw_content ADD user_name VARCHAR(200) DEFAULT  null COMMENT '用户姓名';
ALTER TABLE abw_comment ADD comment_class VARCHAR(4) not  null default 'R' COMMENT '评论层次:R-根评论(Root),C-子评论(Child)';
ALTER TABLE abw_content ADD curr_floor_num bigint(20) NOT NULL DEFAULT 0 COMMENT '当前楼数';


