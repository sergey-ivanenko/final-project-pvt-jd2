-- Table: roles
CREATE TABLE role (
                       role_id   INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(30) NOT NULL
)
    ENGINE = InnoDB;

INSERT INTO role VALUES (1, 'ROLE_USER');
INSERT INTO role VALUES (2, 'ROLE_ADMIN');