
CREATE DATABASE  IF NOT EXISTS `UserDB`;
USE `UserDB`;

create table users
(
    id         int unsigned auto_increment primary key,
    h_no       varchar(50)  not null,
    sicil_no   int          not null,
    username   varchar(100) not null,
    password   varchar(100) not null,
    firstname  varchar(100) not null,
    lastname   varchar(100) not null,
    role_id    int unsigned not null,
    status     varchar(10)  not null,
    attributes text         not null,
    inserttime int unsigned not null,
    updatetime int unsigned not null
)
    comment 'System users' charset = utf8;


create table user_roles
(
    id          int unsigned auto_increment primary key,
    name        varchar(20)  not null,
    permissions text         not null,
    status      varchar(10)  not null,
    level       float        not null,
    inserttime  int unsigned not null,
    updatetime  int unsigned not null
)
    comment 'System user roles' charset = utf8;

insert into user_roles (id, name, permissions, status, level, inserttime, updatetime) values (1, 'ADMIN', '', 'active', 1, 1675239749, 1675239749);
insert into user_roles (id, name, permissions, status, level, inserttime, updatetime) values (2, 'BASMUDURLUK VKT', '', 'active', 2, 1675239749, 1675239749);
insert into user_roles (id, name, permissions, status, level, inserttime, updatetime) values (3, 'MERKEZ VKT', '', 'active', 3, 1675239749, 1675239749);
insert into user_roles (id, name, permissions, status, level, inserttime, updatetime) values (4, 'GİŞE PERSONELİ', '', 'active', 4, 1675239749, 1675239749);
insert into user_roles (id, name, permissions, status, level, inserttime, updatetime) values (8, 'ÇAĞRI MERKEZİ', '', 'active', 10, 1675239749, 1675239749);