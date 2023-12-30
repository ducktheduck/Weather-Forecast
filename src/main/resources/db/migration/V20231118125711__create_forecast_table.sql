CREATE TABLE IF NOT EXISTS weatherforecast."forecast"
(
    id                     integer                  NOT NULL,
    database_version       integer                  NOT NULL,
    create_date            timestamp with time zone NOT NULL,
    update_date            timestamp with time zone,
    temperature            integer    NOT NULL,
    description            character varying(64),
    location_id            integer,

    CONSTRAINT forecast_pkey PRIMARY KEY (id),
    CONSTRAINT fk_location FOREIGN KEY (location_id)
    REFERENCES weatherforecast."location" (id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    )