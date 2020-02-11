-- Table: roles
CREATE TABLE role (
                       role_id   INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(30) NOT NULL
)
    ENGINE = InnoDB;

INSERT INTO role VALUES (1, 'ROLE_USER');
INSERT INTO role VALUES (2, 'ROLE_ADMIN');

INSERT INTO user VALUES (1, 'expirence', 'Sergey', '$2a$11$oAHyPMcPr/V20h1ONdkQT.p9KV9dX7sQvDmqkjOCc/o3vnY1izyii');
insert into admin values(1);
INSERT INTO user_roles VALUES (1, 2);