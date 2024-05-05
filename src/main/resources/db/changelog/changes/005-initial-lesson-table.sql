CREATE TABLE lesson
(
    id          INT      NOT NULL PRIMARY KEY AUTO_INCREMENT,
    date_time   DATETIME NOT NULL,
    language_id INT      NOT NULL,
    student_id  INT      NOT NULL,
    teacher_id  INT      NOT NULL
);