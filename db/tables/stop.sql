DROP TABLE IF EXISTS stop;
CREATE TABLE stop
(
    stop_id     int NOT NULL AUTO_INCREMENT,
    code        varchar(255),
    name        varchar(255),
    details     varchar(255),
    create_by   varchar(255),
    create_date datetime,
    update_by   varchar(255),
    update_date datetime,
    CONSTRAINT stop_pk PRIMARY KEY (stop_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = COMPACT;

