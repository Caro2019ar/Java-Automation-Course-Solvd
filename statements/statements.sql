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


--### Deletion
* 10 statements for deletions.

* 5 alter table.
ALTER TABLE teachdb.Addresses rename column idAddress to id;
ALTER TABLE teachdb.Users MODIFY birthday date;
ALTER TABLE teachdb.Users MODIFY phone VARCHAR(20);
ALTER TABLE teachdb.Users rename column birthday to date_of_birth;
ALTER TABLE teachdb.Users ADD column last_name VARCHAR(20);

* 1 big statement to join all tables in the database.

* 5 statements with left, right, inner, outer joins.
SELECT * FROM Addresses a LEFT JOIN Cities c on a.city_id = c.id;
SELECT * FROM States s RIGHT JOIN Countries co on s.country_id = co.id;
SELECT * FROM States s INNER JOIN Countries co on s.country_id = co.id;
SELECT * FROM Addresses a LEFT JOIN Cities c on a.city_id = c.name; -- OUTER JOIN
SELECT u.*, ci.name as 'state', co.name as 'country' FROM Users u INNER JOIN Addresses a on a.id = u.address_id
INNER JOIN Cities ci on a.city_id = ci.id
INNER JOIN States st on st.idState = ci.state_id
INNER JOIN Countries co on co.id = st.country_id
where co.name = 'Brazil';

* 7 statements with aggregate functions and group by and without having.

* 7 statements with aggregate functions and group by and with having.
