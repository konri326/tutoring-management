CREATE TABLE student
(
    id          INT         NOT NULL PRIMARY KEY AUTO_INCREMENT,
    first_name  VARCHAR(50) NOT NULL,
    last_name   VARCHAR(50) NOT NULL,
    language_id INT         NOT NULL,
    teacher_id  INT         NOT NULL,
    active      TINYINT
);