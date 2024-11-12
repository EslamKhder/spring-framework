-- Creating users table in Oracle
CREATE TABLE users (
  username VARCHAR2(50) NOT NULL,
  password VARCHAR2(50) NOT NULL,
  enabled NUMBER(1) NOT NULL,
  PRIMARY KEY (username)
);

-- Inserting data into users table
INSERT INTO users (username, password, enabled) 
VALUES 
('eslam', '{noop}test123', 1);

INSERT INTO users (username, password, enabled) 
VALUES 
('ahmed', '{noop}test123', 1);

INSERT INTO users (username, password, enabled) 
VALUES 
('osama', '{noop}test123', 1);

-- Creating authorities table in Oracle
CREATE TABLE authorities (
  username VARCHAR2(50) NOT NULL,
  authority VARCHAR2(50) NOT NULL,
  CONSTRAINT authorities_idx_1 UNIQUE (username, authority),
  CONSTRAINT authorities_ibfk_1 FOREIGN KEY (username) REFERENCES users (username)
);

-- Inserting data into authorities table
INSERT INTO authorities (username, authority) 
VALUES ('eslam', 'ROLE_EMPLOYEE');

INSERT INTO authorities (username, authority) 
VALUES ('ahmed', 'ROLE_EMPLOYEE');

INSERT INTO authorities (username, authority) 
VALUES ('jo', 'ROLE_MANAGER');

INSERT INTO authorities (username, authority) 
VALUES ('osama', 'ROLE_EMPLOYEE');

INSERT INTO authorities (username, authority) 
VALUES ('osama', 'ROLE_MANAGER');

INSERT INTO authorities (username, authority) 
VALUES ('osama', 'ROLE_ADMIN');
