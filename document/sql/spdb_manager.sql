create table spdb_manager (
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY COMMENT 'Primary key',
  manager_id CHAR(36) NOT NULL COMMENT 'Manager ID',
  email VARCHAR(50) NOT NULL COMMENT 'Email account',
  password VARCHAR(64) NOT NULL COMMENT 'Password',
  nickname VARCHAR(50) NULL COMMENT 'Nickname',
  avatar VARCHAR(255) NULL COMMENT 'Avatar path',
  signin_time DATETIME NULL COMMENT 'Sign in time',
  create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Create time',
  update_time DATETIME NULL ON UPDATE CURRENT_TIMESTAMP COMMENT 'Modified time',
  UNIQUE KEY spdb_manager_unique_email(email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Manager table';

ALTER TABLE spdb_manager ADD INDEX idx_spdb_manager_id (manager_id);
ALTER TABLE spdb_manager ADD INDEX idx_spdb_manager_email (email, password);
ALTER TABLE spdb_manager ADD INDEX idx_spdb_create_time (create_time);