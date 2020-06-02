DROP TABLE IF EXISTS ticket;
CREATE TABLE ticket
(
    ticket_id        int NOT NULL AUTO_INCREMENT,
    seat_number      varchar(255),
    cancelable       boolean,
    customer_id      int,
    trip_schedule_id int,
    create_by        varchar(255),
    create_date      datetime,
    update_by        varchar(255),
    update_date      datetime,
    CONSTRAINT ticket_pk PRIMARY KEY (ticket_id),
    CONSTRAINT ticket_fk FOREIGN KEY (customer_id, trip_schedule_id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  ROW_FORMAT = COMPACT;