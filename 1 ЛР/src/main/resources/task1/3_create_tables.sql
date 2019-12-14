use db_kuzzzya;

CREATE TABLE `teacher`
(
`teacher_number` VARCHAR(225) PRIMARY KEY NOT NULL,
`last_name`      VARCHAR(225)            NOT NULL,
`post`           VARCHAR(225)            NOT NULL,
`department`     VARCHAR(225)            NOT NULL,
`specialty`      VARCHAR(225)            NOT NULL,
`phone`          INT(12)     UNIQUE     NOT NULL
);

CREATE TABLE `subject`
(
`subject_number` VARCHAR(225) PRIMARY KEY NOT NULL,
`subject_name`   VARCHAR(225)            NOT NULL,
`hours`          INT (5)                NOT NULL,
`specialty`      VARCHAR(225)            NOT NULL,
`semester`       INT(12)                NOT NULL
);

CREATE TABLE `student_group`
(
`group_number`      VARCHAR(225) PRIMARY KEY NOT NULL,
`group_name`        VARCHAR(225)            NOT NULL,
`num_of_persons`    INT (5)                NOT NULL,
`specialty`         VARCHAR(225)            NOT NULL,
`headman`           VARCHAR(225)            NOT NULL
);

CREATE TABLE `teacher_student_group`
(
`group_number`   VARCHAR(225) NOT NULL,
`subject_number` VARCHAR(225) NOT NULL,
`teacher_number` VARCHAR(225) NOT NULL,
`auditory`       INT(5)     NOT NULL,

FOREIGN KEY (`subject_number`) REFERENCES `subject` (`subject_number`)
ON UPDATE CASCADE
ON DELETE CASCADE,

FOREIGN KEY (`group_number`) REFERENCES `student_group` (`group_number`)
ON UPDATE CASCADE
ON DELETE CASCADE,

FOREIGN KEY (`teacher_number`) REFERENCES `teacher` (`teacher_number`)
ON UPDATE CASCADE
ON DELETE CASCADE
);


