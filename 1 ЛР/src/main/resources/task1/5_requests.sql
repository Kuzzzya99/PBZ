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
        'АСОИ',
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
   'ЭВМ',
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
   'Бухучёт',
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
                                     `teacher_number`,
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


use db_kuzzzya;

SELECT * FROM teacher;

SELECT * FROM student_group WHERE specialty = 'ЭВМ';

SELECT DISTINCT teacher_number, auditory
FROM teacher_student_group
WHERE subject_number = '18П';

SELECT DISTINCT subject.subject_number, subject_name
FROM subject
JOIN teacher_student_group
ON subject.subject_number = teacher_student_group.subject_number
JOIN teacher
ON teacher_student_group.teacher_number = teacher.teacher_number
WHERE last_name='Костин';

SELECT group_number
FROM teacher_student_group
JOIN teacher
    ON teacher_student_group.teacher_number = teacher.teacher_number
WHERE last_name='Фролов';

SELECT * FROM subject
WHERE specialty = 'АСОИ';

SELECT * FROM teacher WHERE LOCATE('АСОИ', specialty);

SELECT DISTINCT last_name
FROM teacher
JOIN teacher_student_group tsg on teacher.teacher_number = tsg.teacher_number
WHERE auditory='210';

SELECT subject_name, group_name
FROM teacher_student_group
JOIN student_group g on teacher_student_group.group_number = g.group_number
JOIN subject s on teacher_student_group.subject_number = s.subject_number
WHERE auditory between 100 and 200;

SELECT DISTINCT FIRST.group_number, SECOND.group_number
FROM student_group FIRST, student_group SECOND
WHERE first.specialty = second.specialty AND
first.group_number !=  second.group_number AND
first.group_number <  second.group_number;

SELECT SUM(num_of_persons) AS general_persons
FROM student_group
WHERE specialty='ЭВМ';

SELECT DISTINCT teacher_number
FROM teacher_student_group
JOIN student_group g on teacher_student_group.group_number = g.group_number
WHERE specialty='ЭВМ';

SELECT teacher_student_group.subject_number
FROM teacher_student_group
GROUP BY teacher_student_group.subject_number
HAVING COUNT(teacher_student_group.group_number) = (SELECT COUNT(*) FROM student_group);

SELECT DISTINCT last_name
FROM teacher
JOIN `teacher_student_group` r on teacher.teacher_number = r.teacher_number
WHERE r.subject_number IN (SELECT DISTINCT subject_number/*какие ещё предметы, кроме 14П ведет*/
                           FROM `teacher_student_group`
                           WHERE teacher_student_group.teacher_number =
                                 (SELECT DISTINCT t.teacher_number /*узнали номер преподавателя, который ведет 14П*/
                                  FROM teacher_student_group
                                  JOIN teacher t on t.teacher_number =teacher_student_group.teacher_number
                                  WHERE `teacher_student_group`.subject_number = '14П'))
and (r.teacher_number NOT IN (SELECT DISTINCT t.teacher_number /*узнали номер преподавателя, который ведет 14П*/
                          FROM teacher_student_group
                            JOIN teacher t on t.teacher_number =teacher_student_group.teacher_number
                          WHERE `teacher_student_group`.subject_number = '14П'));

SELECT DISTINCT subject.*
FROM subject
right JOIN  teacher_student_group g on subject.subject_number = g.subject_number
WHERE g.subject_number not in
  (SELECT DISTINCT subject_number
FROM teacher_student_group
WHERE teacher_student_group.teacher_number = '221Л');

SELECT DISTINCT subject.*
FROM subject
Where subject_number not in (
  SELECT  DISTINCT subject_number
  FROM teacher_student_group
  JOIN student_group g on teacher_student_group.group_number = g.group_number
  where group_name = 'М-6'
);

SELECT DISTINCT teacher.*
FROM teacher
WHERE post='Доцент' and
      teacher_number in (SELECT DISTINCT teacher_student_group.teacher_number
                         FROM teacher_student_group
                           JOIN teacher t on teacher_student_group.teacher_number = t.teacher_number
                         WHERE group_number in ('3Г','8Г'));

SELECT DISTINCT subject_number, teacher.teacher_number, group_number
FROM teacher
  JOIN teacher_student_group g on teacher.teacher_number = g.teacher_number
WHERE department in ('ЭВМ') AND LOCATE('АСОИ',specialty);


SELECT DISTINCT teacher_student_group.group_number
FROM teacher_student_group
INNER JOIN teacher t on teacher_student_group.teacher_number = t.teacher_number
INNER JOIN student_group g on teacher_student_group.group_number = g.group_number
WHERE g.specialty IN (select specialty FROM teacher);


SELECT DISTINCT t.teacher_number
FROM teacher_student_group
JOIN teacher t on teacher_student_group.teacher_number = t.teacher_number
JOIN subject s on teacher_student_group.subject_number = s.subject_number
WHERE t.department ='ЭВМ' and t.specialty in (select s.specialty from subject);


SELECT DISTINCT g.specialty
FROM teacher_student_group
JOIN student_group g on teacher_student_group.group_number = g.group_number
JOIN teacher t on teacher_student_group.teacher_number = t.teacher_number
WHERE t.department ='АСУ';


SELECT DISTINCT subject_number
FROM teacher_student_group
JOIN student_group g on teacher_student_group.group_number = g.group_number
WHERE g.group_name='АС-8';


SELECT DISTINCT t2.group_number
FROM student_group
  JOIN teacher_student_group t2 on student_group.group_number = t2.group_number
  JOIN student_group g on t2.group_number = g.group_number
WHERE t2.subject_number IN (SELECT DISTINCT t2.subject_number
from teacher_student_group
WHERE g.group_name='АС-8');


SELECT DISTINCT t2.group_number
FROM student_group
  JOIN teacher_student_group t2 on student_group.group_number = t2.group_number
WHERE t2.subject_number Not IN (SELECT DISTINCT t2.subject_number
                            from teacher_student_group
                            JOIN student_group g on teacher_student_group.group_number = g.group_number
                            WHERE g.group_name='АС-8');

SELECT DISTINCT g.group_number
FROM student_group g
WHERE g.group_number NOT IN (SELECT DISTINCT teacher_student_group.group_number
  FROM teacher_student_group
  WHERE teacher_student_group.subject_number in(SELECT DISTINCT teacher_student_group.subject_number
    From teacher_student_group
    WHERE teacher_student_group.teacher_number='430Л'
  )
);


SELECT DISTINCT teacher_student_group.teacher_number
FROM teacher_student_group
JOIN student_group g on teacher_student_group.group_number = g.group_number
WHERE g.group_name='Э-15'and teacher_student_group.teacher_number NOT in(
  Select DISTINCT teacher_number
  FROM teacher_student_group
  Where subject_number='12П');





