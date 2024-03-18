create
    database oauth2;
use
    oauth2;
CREATE TABLE client
(
    id            INT          NOT NULL AUTO_INCREMENT,
    client_id     VARCHAR(100) NOT NULL,
    client_secret VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE users
(
    id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50)  NOT NULL,
    password VARCHAR(500) NOT NULL,
    enabled  BOOLEAN      NOT NULL
);

CREATE TABLE authorities
(
    id        INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username  VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    CONSTRAINT fk_authorities_users FOREIGN KEY (id) REFERENCES users (id)
);

CREATE UNIQUE INDEX ix_auth_username ON authorities (username, authority);


INSERT INTO users(username, password, enabled) VALUES ('admin', '$2a$12$K9Q821FTeFy1bRX1Mggib.PdYW8EAaIdX3L28zQiCw9LdEXj/dTtK', 1);
INSERT INTO authorities(username, authority) VALUES ('admin', 'ADMIN');


