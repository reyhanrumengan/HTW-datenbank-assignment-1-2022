-- Brose, SS 2022
-- basiert auf: https://db.in.tum.de/teaching/bookDBMSeinf/daten/
--
--DROP SCHEMA uni CASCADE;

CREATE SCHEMA uni;                          -- not in MS SQL Server!

CREATE DOMAIN uni.d_semester      AS CHAR(7); -- MS SQL server: CREATE TYPE SEMESTER FROM [char](7) NULL

CREATE DOMAIN uni.d_semester_anzahl AS SMALLINT CHECK (VALUE BETWEEN 1 and 16); -- MS SQL server: CREATE TYPE SEMESTER_ZAHL FROM SMALLINT

CREATE TABLE uni.studierende (
        matr_nr                 INTEGER         PRIMARY KEY,
        name                    VARCHAR(30)     NOT NULL,
        vorname                 VARCHAR(30)     NOT NULL,
        geburtsdatum            DATE            NOT NULL,
        geburtsort              VARCHAR(30)     NOT NULL,
        anzahl_semester         uni.d_semester_anzahl,
        studienbeginn           uni.d_semester  NOT NULL
);

CREATE TABLE uni.professoren (
        pers_nr                 INTEGER         PRIMARY KEY,
        name                    VARCHAR(30)     NOT NULL,
        rang                    CHAR(2)         CHECK (rang in ('C2', 'C3', 'C4')),
        raum                    INTEGER         UNIQUE,
        gehalt                  INTEGER
);

CREATE TABLE uni.mitarbeiter (
        pers_nr                 INTEGER         PRIMARY KEY,
        name                    VARCHAR(30)     NOT NULL,
        fachgebiet              VARCHAR(30),
        gehalt                  INTEGER,
        arbeitet_fuer_professor INTEGER         REFERENCES uni.professoren ON DELETE SET NULL
);

CREATE TABLE uni.lehrveranstaltungen (
        lv_nr                   INTEGER         PRIMARY KEY,
        titel                   VARCHAR(30),
        leistungs_punkte        INTEGER,
        semester                uni.d_semester,
        gehalten_von_professor  INTEGER         REFERENCES uni.professoren ON DELETE SET NULL
);

CREATE TABLE uni.teilnehmen (
        matr_nr                 INTEGER         REFERENCES uni.studierende ON DELETE CASCADE,
        lv_nr                   INTEGER         REFERENCES uni.lehrveranstaltungen ON DELETE CASCADE,
        PRIMARY KEY    (matr_nr, lv_nr)
);

CREATE TABLE uni.voraussetzen (
        vorgaenger              INTEGER         REFERENCES uni.lehrveranstaltungen ON DELETE CASCADE,
        nachfolger              INTEGER         REFERENCES uni.lehrveranstaltungen ON DELETE CASCADE,
        PRIMARY KEY    (vorgaenger, nachfolger)
);

CREATE TABLE uni.pruefen (
        matr_nr                 INTEGER         REFERENCES uni.studierende ON DELETE CASCADE,
        lv_nr                   INTEGER         REFERENCES uni.lehrveranstaltungen,
        pers_nr                 INTEGER         REFERENCES uni.professoren ON DELETE SET NULL,
        note                    NUMERIC(2,1)    CHECK (note between 0.7 and 5.0),
        PRIMARY KEY    (matr_nr, lv_nr)
);
