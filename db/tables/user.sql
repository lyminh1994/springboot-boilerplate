DROP TABLE IF EXISTS user;
CREATE TABLE user
(
    user_id      int NOT NULL AUTO_INCREMENT,
    email        varchar(255),
    password     varchar(255),
    first_name   varchar(255),
    last_name    varchar(255),
    mobile_phone varchar(255),
    create_by    varchar(255),
    create_date  datetime,
    update_by    varchar(255),
    update_date  datetime,
    CONSTRAINT user_pk PRIMARY KEY (user_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = COMPACT;