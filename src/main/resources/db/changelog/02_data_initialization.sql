INSERT INTO access_type (id, access)
VALUES (1, 'admin');

INSERT INTO access_type (id, access)
VALUES (2, 'user');

INSERT INTO users (id, name, points, access_type_id, email, password)
VALUES (1, 'admin', 0, 1, 'mail@me.com', '0');