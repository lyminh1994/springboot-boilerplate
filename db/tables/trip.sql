DROP TABLE IF EXISTS trip;
CREATE TABLE trip
(
    trip_id      int NOT NULL AUTO_INCREMENT,
    fare         int,
    journey_time datetime,
    agency_id    int,
    bus_id       int,
    stop_id      int,
    create_by    varchar(255),
    create_date  datetime,
    update_by    varchar(255),
    update_date  datetime,
    CONSTRAINT trip_pk PRIMARY KEY (trip_id),
    CONSTRAINT trip_fk FOREIGN KEY (agency_id, bus_id, stop_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = COMPACT;

