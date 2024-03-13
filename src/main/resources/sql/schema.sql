CREATE TABLE IF NOT EXISTS guestbook (
    id BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(50),
    message VARCHAR(255),
    date TIMESTAMP,
    PRIMARY KEY (id)
);