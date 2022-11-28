INSERT INTO access_type (id, access)
VALUES ('1'::integer, 'admin'::character varying);

INSERT INTO access_type (id, access)
VALUES ('2'::integer, 'user'::character varying);

INSERT INTO users (name, points, access_type_id, email, password, id)
VALUES ('admin'::character varying, '0'::integer, '1'::integer, 'mail@me.com'::character varying, '0'::character varying, '1'::bigint);