DROP DATABASE IF EXISTS `DB_Kuzzzya`;

CREATE DATABASE `DB_Kuzzzya` DEFAULT character set utf8;

use db_kuzzzya;

create table supplier (
    id varchar(10)  primary key not null,
    supplier_name varchar(30) not null,
    status int(4) not null,
    city varchar(30) not null
);

create table detail (
  id varchar(10) primary key not null,
  detail_name varchar(30) not null,
  color varchar(30),
  size int(4) not null,
  city varchar(30) not null
);

create table project (
  id varchar(10) primary key not null,
  project_name varchar(30) not null,
  city varchar(30)
);

create table supplier_details_project (
  supplier_id varchar(10),
  detail_id varchar(10),
  project_id varchar(10),
  details_number int(4) not null,
  primary key (supplier_id, detail_id, project_id),
  foreign key (supplier_id) references supplier(id),
  foreign key (detail_id) references detail(id),
  foreign key (project_id) references project(id)
);



INSERT INTO supplier (
  id,
  supplier_name,
  status,
  city
)
    VALUES (
      'П1',
      'Петров',
      20,
      'Москва'
    ),
      (
        'П2',
        'Синицин',
        10,
        'Таллинн'
      ),
      (
        'П3',
        'Федоров',
        30,
        'Таллинн'
      ),
      (
        'П4',
        'Чаянов',
        20,
        'Минск'
      ),
      (
        'П5',
        'Крюков',
        30,
        'Киев'
      );



INSERT INTO detail (
  id,
  detail_name,
  color,
  size,
  city
)
    VALUES (
        'Д1',
        'Болт',
        'Красный',
        12,
        'Москва'
    ),
      (
        'Д2',
        'Гайка',
        'Зеленый',
        17,
        'Минск'
      ),
      (
        'Д3',
        'Диск',
        'Черный',
        17,
        'Вильнюс'
      ),
      (
        'Д4',
        'Диск',
        'Черный',
        14,
        'Москва'
      ),
      (
        'Д5',
        'Корпус',
        'Красный',
        12,
        'Минск'
      ),
      (
        'Д6',
        'Крышки',
        'Красный',
        19,
        'Москва'
      );

INSERT INTO project (
id,
project_name,
city
)
    VALUES (
      'ПР1',
      'ИПР1',
      'Минск'
    ),
      (
        'ПР2',
        'ИПР2',
        'Таллинн'
      ),
      (
        'ПР3',
        'ИПР3',
        'Псков'
      ),
      (
        'ПР4',
        'ИПР4',
        'Псков'
      ),
      (
        'ПР5',
        'ИПР4',
        'Москва'
      ),
      (
        'ПР6',
        'ИПР6',
        'Саратов'
      ),
      (
        'ПР7',
        'ИПР7',
        'Москва'
      );

INSERT INTO supplier_details_project (
  supplier_id,
  detail_id,
  project_id,
  details_number
)
  VALUES (
    'П1',
    'Д1',
    'ПР1',
    200
  ),
    (
      'П1',
      'Д1',
      'ПР2',
      700
    ),
    (
      'П2',
      'Д3',
      'ПР1',
      400
    ),
    (
      'П2',
      'Д2',
      'ПР2',
      200
    ),
    (
      'П2',
      'Д3',
      'ПР3',
      200
    ),
    (
      'П2',
      'Д3',
      'ПР4',
      500
    ),
    (
      'П2',
      'Д3',
      'ПР5',
      600
    ),
    (
      'П2',
      'Д3',
      'ПР6',
      400
    ),
    (
      'П2',
      'Д3',
      'ПР7',
      800
    ),
    (
      'П2',
      'Д5',
      'ПР2',
      100
    ),
    (
      'П3',
      'Д3',
      'ПР1',
      200
    ),
    (
      'П3',
      'Д4',
      'ПР2',
      500
    ),
    (
      'П4',
      'Д6',
      'ПР3',
      300
    ),
    (
      'П4',
      'Д6',
      'ПР7',
      300
    ),
    (
      'П5',
      'Д2',
      'ПР2',
      200
    ),
    (
      'П5',
      'Д2',
      'ПР4',
      100
    ),
    (
      'П5',
      'Д5',
      'ПР5',
      500
    ),
    (
      'П5',
      'Д5',
      'ПР7',
      100
    ),
    (
      'П5',
      'Д6',
      'ПР2',
      200
    ),
    (
      'П5',
      'Д1',
      'ПР2',
      100
    ),
    (
      'П5',
      'Д3',
      'ПР4',
      200
    ),
    (
      'П5',
      'Д4',
      'ПР4',
      800
    ),
    (
      'П5',
      'Д5',
      'ПР4',
      400
    ),
    (
      'П5',
      'Д6',
      'ПР4',
      500
    );

#4
SELECT * FROM supplier_details_project
WHERE details_number BETWEEN 300 AND 750;

#7
select sdp.detail_id, sdp.supplier_id, sdp.project_id from supplier_details_project sdp
join project p on sdp.project_id = p.id
join detail d on sdp.detail_id = d.id
join supplier s on sdp.supplier_id = s.id
where d.city!= p.city and p.city!= s.city and s.city != d.city;

#11
SELECT DISTINCT s.city, p.city from supplier_details_project
inner join supplier s on supplier_details_project.supplier_id = s.id
inner join project p on supplier_details_project.project_id = p.id;

#15
SELECT COUNT(project_id)
FROM supplier_details_project
WHERE supplier_id IN ('П1');

#21
SELECT DISTINCT detail_id
FROM supplier_details_project
WHERE project_id IN (SELECT project.id
FROM project
WHERE project.city = 'Лондон');

#22
SELECT project_id
FROM supplier_details_project
WHERE supplier_id in ('П1');


#25
SELECT * FROM project
WHERE city = (SELECT city FROM project ORDER BY city ASC LIMIT 1);

#29
SELECT project.id FROM project
WHERE NOT project.id IN (
  SELECT DISTINCT  supplier_details_project.project_id FROM  supplier_details_project
  WHERE  supplier_details_project.supplier_id IN (
    SELECT supplier.id FROM supplier
    WHERE NOT supplier.id = 'П1'));


#33
SELECT detail.city
FROM detail
UNION SELECT supplier.city FROM supplier
UNION SELECT project.city FROM project;

#36
SELECT supplier_id, supplier_id
FROM (
       SELECT a.supplier_id, GROUP_CONCAT(DISTINCT a.detail_id ORDER BY detail_id)
         AS details
       FROM `supplier_details_project` a
       GROUP BY supplier_id) s
GROUP BY details
HAVING count(supplier_id) > 1;


WITH t1 AS (
  SELECT supplier_id, GROUP_CONCAT(detail_id) as det FROM supplier_details_project
  GROUP BY supplier_id
)
SELECT t1.supplier_id, t2.supplier_id FROM t1
CROSS JOIN (SELECT supplier_id,GROUP_CONCAT(detail_id) as det1 FROM supplier_details_project
    GROUP BY supplier_id) AS t2
WHERE det = det1 AND t1.supplier_id!=t2.supplier_id;


