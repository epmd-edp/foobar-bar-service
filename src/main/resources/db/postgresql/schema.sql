CREATE TABLE test (
  id serial,
  value character varying(30),
  CONSTRAINT pk_test PRIMARY KEY (id)
);

CREATE TABLE orders (
  id serial,
  user_id integer,
  price double precision
);