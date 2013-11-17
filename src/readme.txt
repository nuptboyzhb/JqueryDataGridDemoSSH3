1.创建数据库表：
create table student
(
   id varchar2(36) primary key,
   name varchar2(32) not null,
   course varchar2(64) not null,
   score number not null,
   remarks varchar2(512)
);