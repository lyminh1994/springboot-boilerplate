DROP TABLE IF EXISTS role_permissions;
CREATE TABLE role_permissions
(
    role_permissions_id int NOT NULL AUTO_INCREMENT,
    role_id             int,
    permission_id       int,
    create_by           varchar(255),
    create_date         datetime,
    update_by           varchar(255),
    update_date         datetime,
    CONSTRAINT role_permissions_pk PRIMARY KEY (role_permissions_id),
    CONSTRAINT role_permissions_fk FOREIGN KEY (role_id, permission_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = COMPACT;