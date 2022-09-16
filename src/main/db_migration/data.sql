CREATE USER 'bestuser'@'localhost' IDENTIFIED BY 'bestuser';
GRANT ALL PRIVILEGES ON * . * TO 'bestuser'@'localhost';

CREATE SCHEMA my_db;

USE my_db;
CREATE TABLE people
(
    id      int auto_increment
        primary key,
    name    varchar(50) null,
    surname varchar(50) null,
    year    int         null
)
    engine = InnoDB;
CREATE TABLE books
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