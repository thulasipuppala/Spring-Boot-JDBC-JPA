CREATE TABLE MOVIE(ID INT PRIMARY KEY, TITLE VARCHAR(255),
RUNTIME INT, GENRE VARCHAR(255), IMDB_SCORE DOUBLE, RATING VARCHAR(255));

INSERT INTO MOVIE
VALUES (1, 'Howard the Duck', 110, 'Sci-Fi', 4.6, 'PG');

INSERT INTO MOVIE
VALUES (2, 'Lavalantula', 83, 'Horror', 4.7, 'TV-14');

INSERT INTO MOVIE
VALUES (3, 'Starship Troopers', 129, 'Sci-Fi', 7.2, 'PG-13');

INSERT INTO MOVIE
VALUES (4, 'Waltz With Bashir', 90	, 'Documentary', 8.0, 'R');

INSERT INTO MOVIE
VALUES (5, 'Spaceballs', 96, 'Comedy', 7.1, 'PG');

INSERT INTO MOVIE
VALUES (6, 'Monsters Inc.', 92, 'Animation', 8.1, 'G');

INSERT INTO MOVIE
VALUES (7, 'The Princess Bride.', 100, 'Awesome', 10.0, 'PG');

INSERT INTO MOVIE
VALUES (8, 'Elf', 95, 'Christmas', 9.5, 'PG');

Select * FROM MOVIE
Where GENRE = 'Sci-Fi';

Select * FROM MOVIE
Where IMDB_SCORE > 6.5;

Select * FROM MOVIE
Where RUNTIME < 100
AND RATING = 'PG'
OR RATING = 'G';

Select GENRE, AVG(RUNTIME) FROM MOVIE
GROUP BY GENRE;

UPDATE MOVIE
SET Rating = 'R'
WHERE TITLE = 'Starship Troopers';

SELECT ID FROM MOVIE
WHERE GENRE = 'Horror'
OR GENRE = 'Documentary';

Select RATING, AVG(IMDB_SCORE), MAX(IMDB_SCORE), MIN(IMDB_SCORE)
FROM MOVIE
GROUP BY RATING;

Select RATING, AVG(IMDB_SCORE), MAX(IMDB_SCORE), MIN(IMDB_SCORE)
FROM MOVIE
GROUP BY RATING
HAVING COUNT(*) >1;

DELETE FROM MOVIE
WHERE RATING = 'R';