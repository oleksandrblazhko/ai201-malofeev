drop table sculpture_material CASCADE;
drop table materials CASCADE;
drop table users_sculpture CASCADE;
drop table sculpture CASCADE;
drop table sculpture_types CASCADE;
drop table roles_authorities CASCADE;
drop table authorities CASCADE;
drop table users CASCADE;
drop table roles CASCADE;

CREATE TABLE roles(
	role_id INT PRIMARY KEY,
	role_name VARCHAR
);

CREATE TABLE users(
	user_id INT PRIMARY KEY,
	role_id INT REFERENCES roles(role_id),
	user_name VARCHAR,
	surname VARCHAR,
	balance DECIMAL(10, 2),
	email VARCHAR CHECK(email ~* '^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$'),
	mobile VARCHAR CHECK (mobile ~* '^\+?3?8?(0[\s\.-]\d{2}[\s\.-]\d{3}[\s\.-]\d{2}[\s\.-]\d{2})$')
);

CREATE TABLE authorities(
	authority_id INT PRIMARY KEY,
	authority_name VARCHAR
);

CREATE TABLE roles_authorities(
	role_id INT REFERENCES roles(role_id),
	authority_id INT REFERENCES authorities(authority_id),
	PRIMARY KEY(role_id, authority_id)
);

CREATE TABLE sculpture_types(
	sculpture_type_id INT PRIMARY KEY,
	sculpture_name VARCHAR
);

CREATE TABLE sculpture(
	sculpture_id INT PRIMARY KEY,
	sculpture_name VARCHAR,
	description VARCHAR,
	sculpture_type_id INT REFERENCES sculpture_types(sculpture_type_id),
	sculpture_cost DECIMAL(10, 3),
	author_id INT REFERENCES users(user_id)
);

CREATE TABLE users_sculpture(
	user_id INT REFERENCES users(user_id),
	sculpture_id INT REFERENCES sculpture(sculpture_id),
	obtained DATE,
	PRIMARY KEY(user_id, sculpture_id)
);

CREATE TABLE materials(
	material_id INT PRIMARY KEY,
	material_name VARCHAR
);

CREATE TABLE sculpture_material(
	sculpture_id INT REFERENCES sculpture(sculpture_id),
	material_id INT REFERENCES materials(material_id),
	PRIMARY KEY(sculpture_id, material_id)
);
