SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS permission;
CREATE TABLE permission (
    id BIGINT(64) NOT NULL COMMENT 'Primary key' PRIMARY KEY,
    name VARCHAR(50) NOT NULL COMMENT 'Permission name',
    url VARCHAR(1000) NULL COMMENT 'When the type is page, it represents the front-end routing address, and when the type is button, it represents the back-end INTerface address',
    type INT(2) NOT NULL COMMENT 'Permission type, page-1, button-2',
    permission VARCHAR(50) NULL COMMENT 'Permission expression',
    method VARCHAR(50) NULL COMMENT 'Backend interface access method',
    sort INT NOT NULL COMMENT 'Sort order',
    parent_id BIGINT(64) NOT NULL COMMENT 'Parent id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Permission table';

-- ----------------------------
-- Records of permission
-- ----------------------------
-- INSERT INTO permission(id, name, url, type, permission, method, sort, parent_id) VALUES (1, 'Test page', '/test', 1, 'page:test', NULL, 1, 0);
-- INSERT INTO permission(id, name, url, type, permission, method, sort, parent_id) VALUES (2, 'Test page-query', '/**/test', 2, 'btn:test:query', 'GET', 1, 1);
-- INSERT INTO permission(id, name, url, type, permission, method, sort, parent_id) VALUES (3, 'Test page-add', '/**/test', 2, 'btn:test:insert', 'POST', 2, 1);
-- INSERT INTO permission(id, name, url, type, permission, method, sort, parent_id) VALUES (4, 'Monitor online user pages', '/monitor', 1, 'page:monitor:online', NULL, 2, 0);
-- INSERT INTO permission(id, name, url, type, permission, method, sort, parent_id) VALUES (5, 'Online user page-query', '/**/api/monitor/online/user', 2, 'btn:monitor:online:query', 'GET', 1, 4);
-- INSERT INTO permission(id, name, url, type, permission, method, sort, parent_id) VALUES (6, 'Online user page-kick out', '/**/api/monitor/online/user/kick-out', 2, 'btn:monitor:online:kick-out', 'DELETE', 2, 4);
-- COMMIT;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS role;
CREATE TABLE role (
    id BIGINT(64) NOT NULL COMMENT 'Primary key' PRIMARY KEY,
    name VARCHAR(50) NOT NULL COMMENT 'Role name',
    description VARCHAR(100) NULL COMMENT 'Description',
    create_time BIGINT(13) NOT NULL COMMENT 'Create time',
    update_time BIGINT(13) NOT NULL COMMENT 'Update time',
    CONSTRAINT name UNIQUE (name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Role table';

-- ----------------------------
-- Records of role
-- ----------------------------
-- INSERT INTO role(id, name, description, create_time, update_time) VALUES (1, 'Admin', 'Super Administrator', 1544611947239, 1544611947239);
-- INSERT INTO role(id, name, description, create_time, update_time) VALUES (2, 'User', 'General User', 1544611947246, 1544611947246);
-- COMMIT;

-- ----------------------------
-- Table structure for role_permissions
-- ----------------------------
DROP TABLE IF EXISTS role_permissions;
CREATE TABLE role_permissions (
    role_id BIGINT(64) NOT NULL COMMENT 'Role primary key',
    permission_id BIGINT(64) NOT NULL COMMENT 'Permission primary key',
    PRIMARY KEY (role_id, permission_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Role permission relationship table';

-- ----------------------------
-- Records of role_permissions
-- ----------------------------
-- INSERT INTO role_permissions(role_id, permission_id) VALUES (1, 1);
-- INSERT INTO role_permissions(role_id, permission_id) VALUES (1, 2);
-- INSERT INTO role_permissions(role_id, permission_id) VALUES (1, 3);
-- INSERT INTO role_permissions(role_id, permission_id) VALUES (1, 4);
-- INSERT INTO role_permissions(role_id, permission_id) VALUES (1, 5);
-- INSERT INTO role_permissions(role_id, permission_id) VALUES (1, 6);
-- INSERT INTO role_permissions(role_id, permission_id) VALUES (2, 1);
-- INSERT INTO role_permissions(role_id, permission_id) VALUES (2, 2);
-- COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS user;
CREATE TABLE user (
    id BIGINT(64) NOT NULL COMMENT 'Primary key' PRIMARY KEY,
    username VARCHAR(50) NOT NULL COMMENT 'Username',
    password VARCHAR(60) NOT NULL COMMENT 'Password',
    nickname VARCHAR(255) NULL COMMENT 'Nickname',
    phone VARCHAR(11) NULL COMMENT 'Phone number',
    email VARCHAR(50) NULL COMMENT 'Mailbox',
    birthday BIGINT(13) NULL COMMENT 'Birthday',
    sex INT(2) NULL COMMENT 'Gender, male-1, female-2',
    status INT(2) default 1 NOT NULL COMMENT 'Status, enable-1, disable-0',
    create_time BIGINT(13) NOT NULL COMMENT 'Create time',
    update_time BIGINT(13) NOT NULL COMMENT 'Update time',
    CONSTRAINT email UNIQUE (email),
    CONSTRAINT phone UNIQUE (phone),
    CONSTRAINT username UNIQUE (username)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='User table';

-- ----------------------------
-- Records of user
-- ----------------------------
-- INSERT INTO user(id, username, password, nickname, phone, email, birthday, sex, status, create_time, update_time) VALUES (1, 'admin', '$2a$10$64iuSLkKNhpTN19jGHs7xePvFsub7ZCcCmBqEYw8fbACGTE3XetYq', 'Administrator', 17300000000, 'admin@xkcoding.com', 785433600000, 1, 1, 1544611947032, 1544611947032);
-- INSERT INTO user(id, username, password, nickname, phone, email, birthday, sex, status, create_time, update_time) VALUES (2, 'user', '$2a$10$OUDl4thpcHfs7WZ1kMUOb.ZO5eD4QANW5E.cexBLiKDIzDNt87QbO', 'General User', 17300001111, 'user@xkcoding.com', 785433600000, 1, 1, 1544611947234, 1544611947234);
-- COMMIT;

-- ----------------------------
-- Table structure for user_roles
-- ----------------------------
DROP TABLE IF EXISTS user_roles;
CREATE TABLE user_roles (
    user_id BIGINT(64) NOT NULL COMMENT 'User primary key',
    role_id BIGINT(64) NOT NULL COMMENT 'Role primary key',
    PRIMARY KEY (user_id, role_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='User role relationship table';

-- ----------------------------
-- Records of user_roles
-- ----------------------------
-- INSERT INTO user_roles(user_id, role_id) VALUES (1, 1);
-- INSERT INTO user_roles(user_id, role_id) VALUES (2, 2);
-- COMMIT;

SET FOREIGN_KEY_CHECKS = 1;