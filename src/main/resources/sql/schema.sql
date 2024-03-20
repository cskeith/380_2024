CREATE TABLE IF NOT EXISTS guestbook (
    id BIGINT GENERATED ALWAYS AS IDENTITY,
    date TIMESTAMP,
    message VARCHAR(255),
    name VARCHAR(255),
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users;
CREATE TABLE users (
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    PRIMARY KEY (username)
);
CREATE TABLE IF NOT EXISTS user_roles (
    user_role_id INTEGER GENERATED ALWAYS AS IDENTITY,
    username VARCHAR(50) NOT NULL,
    role VARCHAR(50) NOT NULL,
    PRIMARY KEY (user_role_id),
    FOREIGN KEY (username) REFERENCES users(username)
);
