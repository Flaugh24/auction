DROP SCHEMA public CASCADE;
CREATE SCHEMA public;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;

CREATE TABLE permission (
  id   SERIAL,
  name VARCHAR(20) NOT NULL,
  PRIMARY KEY (id)
);

CREATE UNIQUE INDEX permission_name_unique
  ON permission (upper(name));

CREATE TABLE role (
  id   SERIAL,
  name VARCHAR(10) NOT NULL,
  PRIMARY KEY (id)
);

CREATE UNIQUE INDEX role_name_unique
  ON role (upper(name));

CREATE TABLE role_permission (
  role_id       INT NOT NULL,
  permission_id INT NOT NULL,
  FOREIGN KEY (role_id) REFERENCES role (id),
  FOREIGN KEY (permission_id) REFERENCES permission (id)
);

CREATE TABLE users (
  id          SERIAL,
  email       VARCHAR(50) NOT NULL,
  password    VARCHAR(20) NOT NULL,
  role_id     INT         NOT NULL,
  first_name  VARCHAR(20) NOT NULL,
  second_name VARCHAR(20) NOT NULL,
  rating      INT         NOT NULL DEFAULT 0,
  PRIMARY KEY (id),
  FOREIGN KEY (role_id) REFERENCES role (id)
);

CREATE UNIQUE INDEX users_email_unique
  ON users (upper(email));


CREATE TABLE lot_category (
  id   SERIAL,
  name VARCHAR(40) NOT NULL,
  PRIMARY KEY (id)
);

CREATE UNIQUE INDEX lot_category_name_unique
  ON lot_category (upper(name));

CREATE TABLE lot (
  id          SERIAL,
  name        VARCHAR(40)      NOT NULL,
  description VARCHAR(200)     NOT NULL,
  bid         DOUBLE PRECISION NOT NULL CHECK (bid >= 0),
  start_date  TIMESTAMP        NOT NULL DEFAULT current_timestamp,
  finish_date TIMESTAMP        NOT NULL,
  category_id INT              NOT NULL,
  seller_id   INT              NOT NULL,
  buyer_id    INT,
  status      BOOLEAN,
  PRIMARY KEY (id),
  FOREIGN KEY (seller_id) REFERENCES users (id),
  FOREIGN KEY (buyer_id) REFERENCES users (id),
  FOREIGN KEY (category_id) REFERENCES lot_category (id)
);

CREATE TABLE tread (
  id               SERIAL,
  lot_id           INT       NOT NULL UNIQUE,
  administrator_id INT       NOT NULL,
  date             TIMESTAMP NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (lot_id) REFERENCES lot (id),
  FOREIGN KEY (administrator_id) REFERENCES users (id)
);

CREATE TABLE letter (
  id                 SERIAL,
  previous_letter_id INT,
  from_id            INT NOT NULL,
  to_id              INT NOT NULL,
  content            VARCHAR(500),
  PRIMARY KEY (id),
  FOREIGN KEY (previous_letter_id) REFERENCES letter (id),
  FOREIGN KEY (from_id) REFERENCES users (id),
  FOREIGN KEY (to_id) REFERENCES users (id)
);