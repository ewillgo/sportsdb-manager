create table spdb_manager (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT '主键',
  email VARCHAR(50) NOT NULL COMMENT '邮箱账号',
  password VARCHAR(64) NOT NULL COMMENT '密码',
  nickname VARCHAR(50) NULL COMMENT '昵称',
  avatar VARCHAR(255) NULL COMMENT '头像地址',
  create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time DATETIME NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'
) DEFAULT CHARSET=utf8;

ALTER TABLE spdb_manager ADD INDEX idx_spdb_manager_email (email, password);
ALTER TABLE spdb_manager ADD INDEX idx_spdb_create_time (create_time);