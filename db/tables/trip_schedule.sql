DROP TABLE IF EXISTS trip_schedule;
CREATE TABLE trip_schedule
(
    trip_schedule_id   int NOT NULL AUTO_INCREMENT,
    trip_schedule_date datetime,
    available_seats    int,
    trip_id            int,
    create_by          varchar(255),
    create_date        datetime,
    update_by          varchar(255),
    update_date        datetime,
    CONSTRAINT trip_schedule_pk PRIMARY KEY (trip_schedule_id),
    CONSTRAINT trip_schedule_fk FOREIGN KEY (trip_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = COMPACT;

