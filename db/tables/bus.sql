DROP TABLE IF EXISTS bus;
CREATE TABLE bus
(
    bus_id      int NOT NULL AUTO_INCREMENT,
    code        varchar(255),
    capacity    int,
    make        varchar(255),
    agency_id   int,
    create_by   varchar(255),
    create_date datetime,
    update_by   varchar(255),
    update_date datetime,
    CONSTRAINT bus_pk PRIMARY KEY (bus_id),
    CONSTRAINT bus_fk FOREIGN KEY (agency_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = COMPACT;