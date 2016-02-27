drop database if exists spring;
create database spring charset 'utf8';
use spring;
create table user (id int primary key auto_increment, name varchar(225), password varchar(75))