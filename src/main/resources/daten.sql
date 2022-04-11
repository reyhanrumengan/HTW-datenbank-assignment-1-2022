-- Brose, SS 2022
-- basiert auf: https://db.in.tum.de/teaching/bookDBMSeinf/daten/
--

INSERT INTO uni.studierende(matr_nr, name, vorname, geburtsdatum, geburtsort, anzahl_semester, studienbeginn)
VALUES
    (24002, 'Xenokrates', 'Anon', '01-01-1998', 'Athen', 2, 'WS 2021'),
    (25403, 'Rubens', 'Peter', '01-01-1997', 'Antwerpen', 3, 'SS 2020'),
    (25555, 'Diotima', 'Anon', '01-01-2000', 'Berlin', 6, 'WS 2019'),
    (26120, 'Lovelace', 'Ada', '01-01-2000', 'London', 3, 'SS 2020'),
    (26830, 'Babbage', 'Charles', '01-01-1999', 'Berlin', 4, 'WS 2020'),
    (27550, 'Schopenhauer', 'Friedrich', '01-01-2000', 'Berlin', 4, 'WS 2020'),
    (28106, 'Turing', 'Alan', '01-01-2001', 'London', 4, 'WS 2020'),
    (29120, 'Theophrastos', 'Anon', '01-01-2000', 'Berlin', 4, 'WS 2020'),
    (29555, 'Feuerbach', 'Ludwig', '01-01-2000', 'Berlin', 4, 'WS 2020');

INSERT INTO uni.professoren(pers_nr, name, rang, raum, gehalt)
VALUES
    (2125, 'Sokrates', 'C4', 226, 58000),
    (2126, 'Russel', 'C4', 232, 60000),
    (2127, 'Kopernikus', 'C3', 310, 60000),
    (2133, 'Popper', 'C3', 052, 60000),
    (2134, 'Augustinus', 'C3', 309, 55000),
    (2136, 'Curie', 'C4', 036, 62000),
    (2137, 'Kant', 'C4', 007, 59000),
    (2138, 'Meitner', 'C4', 407, 65000);

INSERT INTO uni.mitarbeiter(pers_nr, name, fachgebiet, gehalt, arbeitet_fuer_professor)
VALUES
    (3002, 'Platon', 'Ideenlehre', 45500, 2125),
    (3003, 'Aristoteles', 'Syllogistik', 45500, 2125),
    (3004, 'Wittgenstein', 'Sprachtheorie', 48500, 2126),
    (3005, 'Rhetikus', 'Planetenbewegung', 50000, 2127),
    (3006, 'Newton', 'Keplersche Gesetze', 52500, 2127),
    (3007, 'Spinoza', 'Gott und Natur', 45000, 2134),
    (3008, 'Arendt', 'Totale Herrschaft', 48800, 2126);

INSERT INTO uni.lehrveranstaltungen(lv_nr, titel, leistungs_punkte, gehalten_von_professor)
VALUES
    (5001, 'Grundzuege', 4, 2137),
    (5041, 'Ethik', 4, 2125),
    (5043, 'Erkenntnistheorie', 3, 2126),
    (5049, 'Maeeutik', 2, 2125),
    (4052, 'Logik', 4, 2125),
    (5052, 'Wissenschaftstheorie', 3, 2126),
    (5216, 'Bioethik', 2, 2126),
    (5259, 'Der Wiener Kreis', 2, 2133),
    (5022, 'Glaube und Wissen', 2, 2134),
    (4630, 'Die 3 Kritiken', 4, 2137);

INSERT INTO uni.teilnehmen(matr_nr, lv_nr)
VALUES
    (26120, 5001),
    (27550, 5001),
    (27550, 4052),
    (28106, 5041),
    (28106, 5052),
    (28106, 5216),
    (28106, 5259),
    (29120, 5001),
    (29120, 5041),
    (29120, 5049),
    (29555, 5022),
    (25403, 5022),
    (29555, 5001);

INSERT INTO uni.voraussetzen(vorgaenger, nachfolger)
VALUES
    (5001, 5041),
    (5001, 5043),
    (5001, 5049),
    (5041, 5216),
    (5043, 5052),
    (5041, 5052),
    (5052, 5259);

INSERT INTO uni.pruefen(matr_nr, lv_nr, pers_nr, note)
VALUES
    (28106, 5001, 2126, 1.0),
    (25403, 5041, 2125, 2.0),
    (27550, 4630, 2137, 2.0);
