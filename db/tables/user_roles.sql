DROP TABLE IF EXISTS user_roles;
CREATE TABLE user_roles
(
    user_roles_id int NOT NULL AUTO_INCREMENT,
    user_id       int,
    role_id       int,
    create_by     varchar(255),
    create_date   datetime,
    update_by     varchar(255),
    update_date   datetime,
    CONSTRAINT user_roles_pk PRIMARY KEY (user_roles_id),
    CONSTRAINT user_roles_fk FOREIGN KEY (user_id, role_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = COMPACT;