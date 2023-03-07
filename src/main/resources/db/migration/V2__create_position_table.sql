CREATE TABLE position
(
    id       LONG        NOT NULL AUTO_INCREMENT,
    name     VARCHAR(50) NOT NULL,
    location VARCHAR(50) NOT NULL
);
INSERT INTO position (id, name, location)
VALUES (1, 'DevOps engineer', 'Pétervására');
INSERT INTO position (id, name, location)
VALUES (2, 'full stack web developer', 'Achau');
INSERT INTO position (id, name, location)
VALUES (3, 'Java backend developer', 'Budapest');
INSERT INTO position (id, name, location)
VALUES (4, 'full stack Java developer', 'Tarvisio');
INSERT INTO position (id, name, location)
VALUES (5, 'lead Javascript engineer', 'Budapest');
INSERT INTO position (id, name, location)
VALUES (6, 'Java backend developer', 'Mulhouse');
INSERT INTO position (id, name, location)
VALUES (7, 'frontend developer (Angular)', 'Budapest');