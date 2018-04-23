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
