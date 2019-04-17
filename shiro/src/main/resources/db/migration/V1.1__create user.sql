DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`
(
  `user_id`     int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `username`    varchar(20) NOT NULL COMMENT '账号',
  `password`    varchar(50) NOT NULL COMMENT '密码',
  `nick_name`   varchar(20) DEFAULT NULL COMMENT '昵称',
  `real_name`   varchar(20) DEFAULT NULL COMMENT '真实姓名',
  `status`      int(1) unsigned zerofill NOT NULL DEFAULT '0' COMMENT '状态 0 正常 1 冻结',
  `lock_status` int(1) unsigned zerofill NOT NULL DEFAULT '0' COMMENT '锁定状态 0 未锁定 1 锁定',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;