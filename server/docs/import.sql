drop database if exists portfolioServer;
Create DATABASE portfolioServer;
use portfolioServer;
create table admins
(
    id            int auto_increment primary key,
    username      varchar(20) unique not null,
    password      varchar(20)        not null,
    CreateTime    DATE DEFAULT CURRENT_DATE,
    LastLoginTime DATE DEFAULT CURRENT_DATE
);
create table logs
(
    admin_id   int                       not null,
    type       char(10)                  not null,
    CreateTime DATE DEFAULT CURRENT_DATE not null,
    info       text                      not null,
    foreign key (admin_id) references admins (id)
);
create table projects
(
    id          int auto_increment primary key,
    title       varchar(50)               not null,
    description text                      not null,
    CreateTime  DATE DEFAULT CURRENT_DATE not null,
    Foto        blob                      not null,
    Url         text                      not null
);
create table projectTypes
(
    id        int auto_increment primary key,
    ProjectId int         not null,
    Type      varchar(20) not null,
    foreign key (ProjectId) references projects (id)
);
create table Clients
(
    id          int auto_increment primary key,
    ip          varchar(20)               not null,
    CurrentTime DATE DEFAULT CURRENT_DATE not null
);
insert into admins (username, password)
values ('admin', 'admin');