--liquibase formatted sql

--changeset g00dc4t:1
USE my_db;
CREATE TABLE IF NOT EXISTS people
(
    id      int auto_increment
        primary key,
    name    varchar(50) null,
    surname varchar(50) null,
    year    int         null
)
    engine = InnoDB;
--rollback DROP TABLE people;

--changeset g00dc4t:2

CREATE TABLE IF NOT EXISTS books
(
    id        int auto_increment
        primary key,
    name      varchar(50) null,
    author    varchar(50) null,
    year      int         null,
    people_id int         null,
    constraint books_ibfk_1
        foreign key (people_id) references people (id)
            on delete set null
)
    engine = InnoDB;
--rollback DROP TABLE books;