create database if not exists e_commerce_center_db;

use e_commerce_center_db;

create table if not exists member
(
    id     bigint not null auto_increment comment 'id',
    name   varchar(64) comment '用户名',
    pwd    char(32) comment '密码',
    mobile varchar(20) comment '手机号码',
    email  varchar(64) comment '邮箱',
    gender tinyint comment '性别，1 - 男，0 - 女',
    primary key (id)
);

INSERT INTO member (name, pwd, mobile, email, gender)
VALUES ('Alice', MD5('12345678'), '555-1234', 'alice@example.com', 0),
       ('Bob', MD5('12345678'), '555-5678', 'bob@example.com', 1),
       ('Charlie', MD5('12345678'), '555-9101', 'charlie@example.com', 1),
       ('David', MD5('12345678'), '555-1212', 'david@example.com', 0),
       ('Eve', MD5('12345678'), '555-1313', 'eve@example.com', 0);


