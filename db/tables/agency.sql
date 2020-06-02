DROP TABLE IF EXISTS agency;
CREATE TABLE agency
(
    agency_id   int NOT NULL AUTO_INCREMENT,
    code        varchar(255),
    name        varchar(255),
    details     varchar(255),
    user_id     int,
    create_by   varchar(255),
    create_date datetime,
    update_by   varchar(255),
    update_date datetime,
    CONSTRAINT agency_pk PRIMARY KEY (agency_id),
    CONSTRAINT agency_fk FOREIGN KEY (user_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = COMPACT;