# Statements exercise

### Insertion

[//]: # (  10 statements for insertion.)

[//]: # (  10 statements for updating.)

[//]: # (  10 statements for deletions.)

[//]: # (  5 alter table.)

[//]: # (  1 big statement to join all tables in the database.)

[//]: # (  5 statements with left, right, inner, outer joins.)

[//]: # (  7 statements with aggregate functions and group by and without having.)

[//]: # (  7 statements with aggregate functions and group by and with having.)

* 10 statements for insertion
INSERT INTO sakila.city (city_id, city, country_id, last_update) VALUES (601, 'Buenos Aires', 6, '2022-09-08 11:12:25');
INSERT INTO sakila.city (city_id, city, country_id, last_update) VALUES (602, 'Pilar', 6, '2022-09-08 11:19:00');
INSERT INTO sakila.city (city_id, city, country_id, last_update) VALUES (603, 'Gualeguay', 6, '2022-09-08 11:20:00');
INSERT INTO sakila.category (category_id, name, last_update) values (17, 'Food', '2022-09-08 11:25:27');
INSERT INTO sakila.category (category_id, name, last_update) values (18, 'Animal', '2022-09-08 11:26:27');
INSERT INTO sakila.category (category_id, name, last_update) values (19, '80s', '2022-09-08 11:27:00');
INSERT INTO sakila.actor (actor_id, first_name, last_name, last_update) VALUES (201, 'ANGELINA', 'JOLIE', '2022-09-08 00:00:33');
INSERT INTO sakila.actor (actor_id, first_name, last_name, last_update) VALUES (202, 'WILL', 'SMITH', '2022-09-08 11:05:20');
INSERT INTO sakila.actor (actor_id, first_name, last_name, last_update) VALUES (203, 'TOM', 'CRUISE', '2022-09-08 00:05:00');
INSERT INTO sakila.actor (actor_id, first_name, last_name, last_update) VALUES (204, 'WINONA', 'RIDER', '2022-09-08 00:07:02');

### Updating

* 10 statements for updating
  UPDATE sakila.customer SET last_name = 'JOHN' WHERE customer_id=2;
  UPDATE sakila.customer SET email = 'MARY.OHN@gmail.com' WHERE customer_id=592;
  UPDATE sakila.customer SET active = 0 WHERE first_name = 'AARON';
  UPDATE sakila.address SET postal_code = 16293 WHERE address_id=539;
  UPDATE sakila.address SET address = '1817 Livorno Way' WHERE address_id=488;
  UPDATE sakila.address SET last_update = '2022-09-25 22:32:09' WHERE address_id=391;
  UPDATE sakila.film SET rental_rate = 4.80 WHERE film_id=789;
  UPDATE sakila.film SET last_update = '2022-09-15 05:03:42' WHERE film_id=4;
  UPDATE sakila.film SET description = 'A Fateful Reflection of a Waitress And a Boat' WHERE film_id=998;
  UPDATE sakila.film SET release_year = 2007 WHERE film_id=882;

### Deletion
* 10 statements for deletions.

* 5 alter table.

* 1 big statement to join all tables in the database.

* 5 statements with left, right, inner, outer joins.

* 7 statements with aggregate functions and group by and without having.

* 7 statements with aggregate functions and group by and with having.
