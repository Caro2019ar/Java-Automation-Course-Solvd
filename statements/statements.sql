--# Statements exercise

--### Insertion
* 10 statements for insertion
INSERT INTO teachdb.Users (name, phone, email, address_id, birthday) VALUES ("Paulo da Silva", "+55 11 2356-8977","paulo@gmail.com",2, '1980-12-01');
INSERT INTO teachdb.Users (name, phone, email, address_id, birthday) VALUES ("Hernan Lopez", "+54 15 13 8999-8977","hernanzito@gmail.com",1, '1990-02-04 00:00:00');
INSERT INTO teachdb.Courses (description, version, instruments_id) VALUES ("Beginner´s course of Jazz", "v1.1",1);
INSERT INTO teachdb.Courses (description, version, instruments_id) VALUES ("Beginner´s course of Flamenco", "v1.1",2);
INSERT INTO teachdb.Courses (description, version, instruments_id) VALUES ("Intermediary´s course of Flamenco", "v3.1",2);
INSERT INTO teachdb.Instruments (name) VALUES ("Electric Guitar");
INSERT INTO teachdb.Instruments (name) VALUES ("Guitar");
INSERT INTO teachdb.Classes (description, date, remote_present_id) VALUES("Main classical chords for rhythm", '2022-08-01 10:30:00', 1);
INSERT INTO teachdb.Classes (description, date, remote_present_id) VALUES("Theory of medieval music", '2022-09-11 12:00:00', 2);
INSERT INTO teachdb.Classes (description, date, remote_present_id) VALUES("Training lesson for faster playing", '2022-09-12 16:30:00', 1);


--### Updating

* 10 statements for updating
UPDATE `teachdb`.`Users` SET `first_name` = 'Paulo', `last_name` = 'Silva' WHERE (`id` = '1');
UPDATE `teachdb`.`Users` SET `first_name` = 'Hernan', `last_name` = 'Lopez' WHERE (`id` = '2');
UPDATE `teachdb`.`Users` SET `first_name` = 'Renan Maria', `last_name` = 'de Jesus' WHERE (`id` = '3');
update teachdb.Cities set state_id=1 where (id='1');
update teachdb.Cities set state_id=2 where (id='2');
UPDATE `teachdb`.`Classes` SET `course_id` = '1' WHERE (`id` = '1');
UPDATE `teachdb`.`Classes` SET `course_id` = '2' WHERE (`id` = '2');
UPDATE `teachdb`.`Classes` SET `course_id` = '1' WHERE (`id` = '3');
UPDATE `teachdb`.`Classes` SET `course_id` = '1' WHERE (`id` = '4');
UPDATE `teachdb`.`Classes` SET `course_id` = '3' WHERE (`id` = '5');
UPDATE `teachdb`.`Classes` SET `course_id` = '3' WHERE (`id` = '6');

--### Deletion
* 10 statements for deletions.

DELETE FROM `teachdb`.`Payment` WHERE (`id` = '8');
DELETE FROM `teachdb`.`Payment` WHERE (`id` = '9');
DELETE FROM `teachdb`.`Payment` WHERE (`id` = '10');
DELETE FROM `teachdb`.`Classes` WHERE (`id` = '7');
DELETE FROM `teachdb`.`Classes` WHERE (`id` = '8');
DELETE FROM `teachdb`.`Classes` WHERE (`id` = '9');
DELETE FROM  teachdb.CoursesEvaluations WHERE id=3;
DELETE FROM  teachdb.CoursesEvaluations WHERE id=11;
DELETE FROM  teachdb.CoursesEvaluations WHERE id=12;
DELETE FROM  teachdb.CoursesEvaluations WHERE id=13;


* 5 alter table.
ALTER TABLE teachdb.Addresses rename column idAddress to id;
ALTER TABLE teachdb.Users MODIFY birthday date;
ALTER TABLE teachdb.Users MODIFY phone VARCHAR(20);
ALTER TABLE teachdb.Users rename column birthday to date_of_birth;
ALTER TABLE teachdb.Users ADD column last_name VARCHAR(20);

* 1 big statement to join all tables in the database.

SELECT us.first_name AS 'Student', AVG(ev.score) AS 'Avg Score',SUM(fi.size) AS 'Total MB shared', SUM(pa.value) AS 'Total paid' FROM Users us
INNER JOIN Addresses ad ON us.address_id = ad.id
INNER JOIN Cities ci ON ad.city_id = ci.id
INNER JOIN States st ON st.idState = ci.state_id
INNER JOIN Countries ct ON ct.id = st.country_id
INNER JOIN PaymentUsers pu ON pu.user_id = us.id
INNER JOIN Payment pa ON pa.id = pu.payment_id
INNER JOIN PaymentMethod pm ON pm.id = pa.paymethod_id
INNER JOIN UsersCourses uc ON uc.users_id = us.id
INNER JOIN Courses co ON co.id = uc.courses_id
INNER JOIN CoursesEvaluations ce ON ce.course_id = co.id
INNER JOIN Evaluations ev ON ev.id = ce.evaluation_id
INNER JOIN Instruments it ON  co.instruments_id = it.id
INNER JOIN Classes cl ON cl.course_id = co.id
INNER JOIN Remote_Present rp ON rp.id = cl.remote_present_id
INNER JOIN ClassFiles cf ON cf.class_id = cl.id
INNER JOIN Files fi ON fi.id = cf.file_id
INNER JOIN Filetypes ft ON ft.id = fi.filetype_id
GROUP BY us.id;

* 5 statements with left, right, inner, outer joins.
SELECT * FROM Addresses a LEFT JOIN Cities c ON a.city_id = c.id;
SELECT * FROM States s RIGHT JOIN Countries co ON s.country_id = co.id;
SELECT * FROM States s INNER JOIN Countries co ON s.country_id = co.id;
SELECT * FROM Addresses a LEFT JOIN Cities c ON a.city_id = c.name; -- OUTER JOIN
SELECT u.*, ci.name AS 'state', co.name AS 'country' FROM Users u INNER JOIN Addresses a ON a.id = u.address_id
INNER JOIN Cities ci ON a.city_id = ci.id
INNER JOIN States st ON st.idState = ci.state_id
INNER JOIN Countries co ON co.id = st.country_id
WHERE co.name = 'Brazil';

* 7 statements with aggregate functions and group by and without having.
SELECT ce.course_id, co.description, AVG(e.score) FROM  CoursesEvaluations ce LEFT JOIN Evaluations e  ON e.id = ce.evaluation_id
INNER JOIN Courses co ON co.id = ce.course_id
GROUP BY ce.course_id;

SELECT ce.course_id, co.description, AVG(e.score) FROM  CoursesEvaluations ce LEFT JOIN Evaluations e  ON e.id = ce.evaluation_id
INNER JOIN Courses co ON co.id = ce.course_id
GROUP BY ce.course_id;

SELECT co.id, co.description AS 'Course s name', COUNT(*) AS 'Sum of classes' FROM Courses co
LEFT JOIN Classes cla ON co.id=cla.course_id GROUP BY co.id;

SELECT cf.class_id, cla.description, COUNT(*) AS 'Sum of Files' FROM ClassFiles cf INNER JOIN Files f ON cf.file_id = f.id
INNER JOIN Classes cla ON cla.id = cf.class_id
GROUP BY cf.class_id ORDER BY cf.class_id;

SELECT co.instruments_id, i.name, COUNT(*) AS 'Sum of classes' FROM Courses co
INNER JOIN Classes cla ON co.id=cla.course_id
INNER JOIN Instruments i ON i.id = co.instruments_id
GROUP BY co.instruments_id;

SELECT ft.id, ft.description, COUNT(*) AS 'Sum of Classes' FROM Files f INNER JOIN Filetypes ft ON f.filetype_id = ft.id GROUP BY ft.id;

SELECT pm.id, pm.description, COUNT(*) AS 'Payments'FROM PaymentMethod pm INNER JOIN Payment p ON pm.id=p.paymethod_id GROUP BY pm.id;

* 7 statements with aggregate functions and group by and with having.

SELECT pm.id, pm.description, SUM(p.value)  AS 'Payments'FROM PaymentMethod pm
INNER JOIN Payment p ON pm.id=p.paymethod_id GROUP BY pm.id HAVING SUM(p.value) > 200.00;

SELECT  COUNT(*) AS 'Files', ft.description FROM Files f INNER JOIN Filetypes ft ON f.filetype_id = ft.id
GROUP BY ft.id HAVING Files >2;

SELECT i.name AS ' Instrument', COUNT(*) AS 'Sum of classes' FROM Courses co
INNER JOIN Classes cla ON co.id=cla.course_id
INNER JOIN Instruments i ON i.id = co.instruments_id
GROUP BY co.instruments_id HAVING name='Guitar';

SELECT cf.class_id, cla.description, COUNT(*) AS 'Sum of Files' FROM ClassFiles cf INNER JOIN Files f ON cf.file_id = f.id
INNER JOIN Classes cla ON cla.id = cf.class_id
GROUP BY cf.class_id HAVING description LIKE '%Theory%';


SELECT pu.user_id, u.first_name, u.last_name , SUM(value) AS 'Total amount' FROM PaymentUsers pu
INNER JOIN Payment p ON pu.payment_id=p.id
INNER JOIN Users u ON u.id=pu.user_id
GROUP BY pu.user_id HAVING SUM(value) > 100.00;

SELECT ce.course_id, co.description, AVG(e.score) AS 'Average score' FROM  CoursesEvaluations ce LEFT JOIN Evaluations e  ON e.id = ce.evaluation_id
INNER JOIN Courses co ON co.id = ce.course_id
GROUP BY ce.course_id HAVING description LIKE '%Intermediary%';

SELECT co.id, co.description AS 'Course s name', COUNT(*) AS 'Sum of classes' FROM Courses co
LEFT JOIN Classes cla ON co.id=cla.course_id GROUP BY co.id HAVING COUNT(*)>2;
