use student_database;
DROP TABLE users;
DROP TABLE authorities;

CREATE TABLE student (

Sid INT,
First_name VARCHAR(30),
Last_name  VARCHAR(30),
Father_name VARCHAR(30),
Email VARCHAR(30),
Student_class VARCHAR(30),
age VARCHAR(30)
);

create table users (
    username varchar(50) not null primary key,
    password varchar(120) not null,
    enabled boolean not null
);

create table authorities (
    username varchar(50) not null,
    authority varchar(50) not null,
    foreign key (username) references users (username)
);

insert into users(username, password, enabled)values('ajay','ajay@1308',true);
insert into authorities(username,authority)values('ajay','ROLE_ADMIN');
 
insert into users(username, password, enabled)values('ajaya','ajaya@1308',true);
insert into authorities(username,authority)values('ajaya','ROLE_USER');