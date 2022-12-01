INSERT INTO access_type (id, access)
VALUES (1, 'ADMIN');

INSERT INTO access_type (id, access)
VALUES (2, 'USER');

INSERT INTO users (id, username, points, access_type_id, email, password)
VALUES (1, 'admin', 0, 1, 'mail@me.com', '$2a$12$8Z42gJ84Oq259FYG4yCNW.yKib4TtaZUZTf/jP9tTx67w/ASAbqNi
');