DROP DATABASE IF EXISTS `DB_Kuzzzya`;

CREATE DATABASE `DB_Kuzzzya` DEFAULT character set utf8;


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
  `private_number` VARCHAR(225) NOT NULL,
  `auditory`       INT(5)     NOT NULL,
  FOREIGN KEY (`subject_number`) REFERENCES `subject` (`subject_number`)
    ON UPDATE CASCADE
    ON DELETE CASCADE,

  FOREIGN KEY (`group_number`) REFERENCES `student_group` (`group_number`)
    ON UPDATE CASCADE
    ON DELETE CASCADE,

  FOREIGN KEY (`private_number`) REFERENCES `teacher` (`teacher_number`)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);


use db_kuzzzya;

INSERT INTO `teacher` (`teacher_number`,
                       `last_name`,
                       `post`,
                       `department`,
                       `specialty`,
                       `phone`)
VALUES ('221Л',
        'Фролов',
        'Доцент',
        'ЭВМ',
        'АСОИ, ЭВМ',
        487),
        ('222Л',
         'Костин',
         'Доцент',
         'ЭВМ',
         'ЭВМ',
         543),
        ('225Л',
         'Бойко',
         'Профессор',
         'АСУ',
         'АСОИ, ЭВМ',
         112),
        ('430Л',
         'Глазов',
         'Ассистент',
         'ТФ',
         'СД',
         421),
        ('110Л',
         'Петров',
         'Ассистент',
         'Экономики',
         'Международная экономика',
         324);

INSERT INTO `subject` (`subject_number`,
                       `subject_name`,
                       `hours`,
                       `specialty`,
                       `semester`)
VALUES ('12П',
        'Мини ЭВМ',
        36,
        'ЭВМ',
        1),
        ('14П',
         'ПЭВМ',
         72,
         'ЭВМ',
         2),
        ('17П',
         'СУБД ПК',
         48,
         'АСОИ',
         4),
        ('18П',
         'ВКСС',
         52,
         'АСОИ',
         6),
        ('34П',
         'Физика',
         30,
         'СД',
         6),
        ('22П',
         'Аудит',
         24,
         'Бухучута',
         3);

INSERT INTO `student_group` (`group_number`,
                              `group_name`,
                              `num_of_persons`,
                              `specialty`,
                              `headman`)
VALUES ('8Г',
        'Э-12',
        18,
        'ЭВМ',
        'Иванова'),
        ('7Г',
         'Э-15',
         22,
         'ЭВМ',
         'Сеткин'),
        ('4Г',
         'АС-9',
         24,
         'АСОИ',
         'Балабанов'),
        ('3Г',
         'АС-8',
         20,
         'АСОИ',
         'Чижов'),
        ('17Г',
         'С-14',
         29,
         'СД',
         'Амросов'),
        ('12Г',
         'М-6',
         16,
         'Международная экономика',
         'Трубин'),
        ('10Г',
         'Б-4',
         21,
         'Бухучет',
         'Зязюткин');

INSERT INTO `teacher_student_group` (`group_number`,
                                     `subject_number`,
                                     `private_number`,
                                     `auditory`)
VALUES ('8Г',
        '12П',
        '222Л',
        112),
        ('8Г',
         '14П',
         '221Л',
         220),
        ('8Г',
         '17П',
         '222Л',
         112),
        ('7Г',
         '14П',
         '221Л',
         220),
        ('7Г',
         '17П',
         '222Л',
         241),
        ('7Г',
         '18П',
         '225Л',
         210),
        ('4Г',
         '12П',
         '222Л',
         112),
        ('4Г',
         '18П',
         '225Л',
         210),
        ('3Г',
         '12П',
         '222Л',
         112),
        ('3Г',
         '17П',
         '221Л',
         241),
        ('3Г',
         '18П',
         '225Л',
         210),
        ('17Г',
         '12П',
         '222Л',
         112),
        ('17Г',
         '22П',
         '110Л',
         220),
        ('17Г',
         '34П',
         '430Л',
         118),
        ('12Г',
         '12П',
         '222Л',
         112),
        ('12Г',
         '22П',
         '110Л',
         210),
        ('10Г',
         '12П',
         '222Л',
         210),
        ('10Г',
         '22П',
         '110Л',
         210);