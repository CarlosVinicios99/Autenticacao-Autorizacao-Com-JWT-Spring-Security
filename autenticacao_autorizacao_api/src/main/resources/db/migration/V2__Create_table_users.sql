CREATE TABLE users (
	id INTEGER PRIMARY_KEY AUTO_INCREMENT NOT NULL,
	login VARCHAR NOT NULL UNIQUE KEY,
	password VARCHAR NOT NULL,
	role VARCHAR NOT NULL
);