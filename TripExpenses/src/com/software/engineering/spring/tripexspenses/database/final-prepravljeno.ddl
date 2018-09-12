-- Generated by Oracle SQL Developer Data Modeler 18.1.0.082.1035
--   at:        2018-09-12 09:14:22 CEST
--   site:      Oracle Database 12c
--   type:      Oracle Database 12c



CREATE TABLE authorities (
    authority        VARCHAR2(20),
    users_username   VARCHAR2(20) NOT NULL
);

CREATE UNIQUE INDEX authorities__idx ON
    authorities (
        users_username
    ASC );

CREATE TABLE bills (
    billid                 INTEGER NOT NULL,
    billitem               VARCHAR2(40),
    price                  NUMBER,
    billdate               DATE,
    tripbills_tripbillid   INTEGER NOT NULL
);

ALTER TABLE bills ADD CONSTRAINT bills_pk PRIMARY KEY ( billid );

CREATE TABLE businesstrips (
    bustripid              INTEGER NOT NULL,
    fromdate               DATE,
    todate                 DATE,
    dayscount              INTEGER,
    locations_locid        INTEGER NOT NULL,
    employees_employeeid   INTEGER NOT NULL,
    triptotallow           INTEGER
);

ALTER TABLE businesstrips ADD CONSTRAINT businesstrips_pk PRIMARY KEY ( bustripid );

CREATE TABLE employees (
    employeeid   INTEGER NOT NULL,
    fullname     VARCHAR2(40),
    email        VARCHAR2(40),
    persidnum    INTEGER,
    passnum      VARCHAR2(15),
    haslicence   NUMBER
);

ALTER TABLE employees ADD CONSTRAINT employees_pk PRIMARY KEY ( employeeid );

CREATE TABLE locations (
    locid               INTEGER NOT NULL,
    locname             VARCHAR2(40),
    loccountry          VARCHAR2(40),
    locdailyallowance   NUMBER,
    locdistance         INTEGER
);

ALTER TABLE locations ADD CONSTRAINT locations_pk PRIMARY KEY ( locid );

CREATE TABLE tripbills (
    tripbillid                INTEGER NOT NULL,
    totalamount               NUMBER,
    businesstrips_bustripid   INTEGER NOT NULL
);

CREATE UNIQUE INDEX tripbills__idx ON
    tripbills (
        businesstrips_bustripid
    ASC );

ALTER TABLE tripbills ADD CONSTRAINT tripbills_pk PRIMARY KEY ( tripbillid );

CREATE TABLE users (
    username               VARCHAR2(20) NOT NULL,
    password               VARCHAR2(20),
    enabled                NUMBER,
    employees_employeeid   INTEGER NOT NULL
);

CREATE UNIQUE INDEX users__idx ON
    users (
        employees_employeeid
    ASC );

ALTER TABLE users ADD CONSTRAINT users_pk PRIMARY KEY ( username );

ALTER TABLE authorities
    ADD CONSTRAINT authorities_users_fk FOREIGN KEY ( users_username )
        REFERENCES users ( username );

ALTER TABLE bills
    ADD CONSTRAINT bills_tripbills_fk FOREIGN KEY ( tripbills_tripbillid )
        REFERENCES tripbills ( tripbillid );

ALTER TABLE businesstrips
    ADD CONSTRAINT businesstrips_employees_fk FOREIGN KEY ( employees_employeeid )
        REFERENCES employees ( employeeid );

ALTER TABLE businesstrips
    ADD CONSTRAINT businesstrips_locations_fk FOREIGN KEY ( locations_locid )
        REFERENCES locations ( locid );

ALTER TABLE tripbills
    ADD CONSTRAINT tripbills_businesstrips_fk FOREIGN KEY ( businesstrips_bustripid )
        REFERENCES businesstrips ( bustripid );

-- Error - Foreign Key Users_Authorities_FK has no columns

ALTER TABLE users
    ADD CONSTRAINT users_employees_fk FOREIGN KEY ( employees_employeeid )
        REFERENCES employees ( employeeid );



-- Oracle SQL Developer Data Modeler Summary Report: 
-- 
-- CREATE TABLE                             7
-- CREATE INDEX                             3
-- ALTER TABLE                             12
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- TSDP POLICY                              0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   1
-- WARNINGS                                 0
