-- USER table data

INSERT INTO "user" (USER_ID, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD)
VALUES (1001, 'Peter', 'Parker', 'realspiderman@marvel.com',
        '$2y$12$DhqHUxhE78NndKdHYNsksuSL0uStdrFLUSaLaKCqwTDjD7c0crLum');

INSERT INTO "user" (USER_ID, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD)
VALUES (1002, 'Jack', 'Smith', 'smithj@yahoo.com',
        '$2y$12$BfVaybM7n4pBKBRnLjPTYu4tg3rjsj5Ddj7Erp95YS/G.mJ87O8yy');

INSERT INTO "user" (USER_ID, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD)
VALUES (1003, 'Walter', 'Peterson', 'wpeterson@gmail.com',
        '$2y$12$KS9ranaG.Da9SnGEC6oYIuQkfLLn509JSQht5ZSzkSWSee8z.gzam');

INSERT INTO "user" (USER_ID, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD)
VALUES (1004, 'Alex', 'Snowden', 'thesnowden@yahoo.com',
        '$2y$12$jWKTeODCJla/48xZ45.cruTp0NLBK2.tNlUKyjAWhmMVjQCOg1cLy');

INSERT INTO "user" (USER_ID, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD)
VALUES (1005, 'Anna', 'Green', 'greenanna@yahoo.com',
        '$2y$12$mjXFAGgBzTMXxvzy/4Ze2eEXA.sYjuT/fkEdNJCufSYdw.WCGWqb2');

-- ARTIST table data

INSERT INTO ARTIST (ARTIST_ID, FIRST_NAME, LAST_NAME)
VALUES (1001, 'Keanu', 'Reeves');

INSERT INTO ARTIST (ARTIST_ID, FIRST_NAME, LAST_NAME)
VALUES (1002, 'Laurence', 'Fishburne');

-- IMDB table data

INSERT INTO IMDB (IMDB_ID, RATING, VOTES)
VALUES (0133093, 8.7, 169158);

INSERT INTO IMDB (IMDB_ID, RATING, VOTES)
VALUES (0234215, 7.2, 519438);

INSERT INTO IMDB (IMDB_ID, RATING, VOTES)
VALUES (2911666, 7.4, 544746);

INSERT INTO IMDB (IMDB_ID, RATING, VOTES)
VALUES (0242653, 6.8, 451168);

-- MOVIE table data

INSERT INTO MOVIE (MOVIE_ID, TITLE, PLOT, RUNTIME, YEAR, IMDB_ID)
VALUES (301, 'The Matrix',
        'When a beautiful stranger leads computer hacker Neo to a forbidding underworld, he discovers the shocking truth--the life he knows is the elaborate deception of an evil cyber-intelligence.',
        136, 1999, 133093);

INSERT INTO MOVIE (MOVIE_ID, TITLE, PLOT, RUNTIME, YEAR, IMDB_ID)
VALUES (299, 'The Matrix Reloaded',
        'Freedom fighters Neo, Trinity and Morpheus continue to lead the revolt against the Machine Army, unleashing their arsenal of extraordinary skills and weaponry against the systematic forces of repression and exploitation.',
        138, 2003, 234215);

INSERT INTO MOVIE (MOVIE_ID, TITLE, PLOT, RUNTIME, YEAR, IMDB_ID)
VALUES (316, 'The Matrix Revolutions',
        'The human city of Zion defends itself against the massive invasion of the machines as Neo fights to end the war at another front while also opposing the rogue Agent Smith.',
        129, 2003, 242653);

INSERT INTO MOVIE (MOVIE_ID, TITLE, PLOT, RUNTIME, YEAR, IMDB_ID)
VALUES (762738, 'John Wick',
        'An ex-hit-man comes out of retirement to track down the gangsters that killed his dog and took everything from him.',
        101, 2014, 2911666);

-- COUNTRY table data

INSERT INTO COUNTRY (MOVIE_ID, COUNTRY_CODE)
VALUES (301, 'US');

INSERT INTO COUNTRY (MOVIE_ID, COUNTRY_CODE)
VALUES (299, 'US');

INSERT INTO COUNTRY (MOVIE_ID, COUNTRY_CODE)
VALUES (316, 'US');

INSERT INTO COUNTRY (MOVIE_ID, COUNTRY_CODE)
VALUES (762738, 'US');

INSERT INTO COUNTRY (MOVIE_ID, COUNTRY_CODE)
VALUES (762738, 'CH');

INSERT INTO COUNTRY (MOVIE_ID, COUNTRY_CODE)
VALUES (462606, 'US');

INSERT INTO COUNTRY (MOVIE_ID, COUNTRY_CODE)
VALUES (462938, 'US');

-- ARTIST_MOVIE table data

INSERT INTO ARTIST_MOVIE (ARTIST_ID, MOVIE_ID)
VALUES (1001, 301);

INSERT INTO ARTIST_MOVIE (ARTIST_ID, MOVIE_ID)
VALUES (1001, 299);

INSERT INTO ARTIST_MOVIE (ARTIST_ID, MOVIE_ID)
VALUES (1001, 316);

INSERT INTO ARTIST_MOVIE (ARTIST_ID, MOVIE_ID)
VALUES (1001, 762738);

INSERT INTO ARTIST_MOVIE (ARTIST_ID, MOVIE_ID)
VALUES (1002, 301);

INSERT INTO ARTIST_MOVIE (ARTIST_ID, MOVIE_ID)
VALUES (1002, 299);

INSERT INTO ARTIST_MOVIE (ARTIST_ID, MOVIE_ID)
VALUES (1002, 316);

INSERT INTO ARTIST_MOVIE (ARTIST_ID, MOVIE_ID)
VALUES (1002, 762738);