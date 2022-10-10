--liquibase formatted sql

--changeset g00dc4t:1
CREATE USER IF NOT EXISTS 'bestuser'@'%' IDENTIFIED BY 'bestuser';
GRANT ALL PRIVILEGES ON 'my_db' . * TO 'bestuser'@'%';