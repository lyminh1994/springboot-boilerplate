DROP TABLE IF EXISTS permission;
CREATE TABLE permission
(
    permission_id int NOT NULL AUTO_INCREMENT,
    name          varchar(255),
    description   varchar(255),
    create_by     varchar(255),
    create_date   datetime,
    update_by     varchar(255),
    update_date   datetime,
    CONSTRAINT permission_pk PRIMARY KEY (permission_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = COMPACT;