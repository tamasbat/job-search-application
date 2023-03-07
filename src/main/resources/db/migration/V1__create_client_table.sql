CREATE TABLE client
(
    id     LONG         NOT NULL AUTO_INCREMENT,
    name   VARCHAR(100) NOT NULL,
    email  VARCHAR(100) NOT NULL,
    apikey VARCHAR(36)  NOT NULL
);
INSERT INTO client (id, name, email, apikey)
VALUES (1, 'Borselli Máté', 'bmate@umail.io', '43f24650-941b-4a8a-b3b6-899735c6ec6e');
INSERT INTO client (id, name, email, apikey)
VALUES (2, 'Ochmann Gézáné', 'ochmanne@mailer.tuv', RANDOM_UUID());
INSERT INTO client (id, name, email, apikey)
VALUES (3, 'Fajsz Péterné', 'fajszne@mail.tk', RANDOM_UUID());
INSERT INTO client (id, name, email, apikey)
VALUES (4, 'Vibreg Itell', 'vitell@mpl.com', RANDOM_UUID());
INSERT INTO client (id, name, email, apikey)
VALUES (5, 'Yper Ervin', 'ypervin@k.st', RANDOM_UUID());
