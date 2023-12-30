CREATE TABLE weatherforecast.location
(
    id integer NOT NULL,
    database_version integer NOT NULL,
    create_date time with time zone NOT NULL,
    update_date time with time zone,
    country character varying(64) NOT NULL,
    county character varying(64),
    city character varying(64) NOT NULL,
    PRIMARY KEY (id)
);