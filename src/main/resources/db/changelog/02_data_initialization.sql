INSERT INTO access_type (id, access)
VALUES (1, 'ADMIN');

INSERT INTO access_type (id, access)
VALUES (2, 'USER');

INSERT INTO usrs (id, username, points, access_type_id, email, password)
VALUES (1, 'admin', 0, 1, 'mail@me.com', '$2a$12$X8vcM9/tvvjNDBmaIVr.3OGtc2Vxnh/ixM3ytgRYWYPLMT.RvMzFu');