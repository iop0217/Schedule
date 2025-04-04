create table schedule
(
    id         bigint auto_increment PRIMARY KEY,
    userName   varchar(10),
    title      varchar(20),
    contents   varchar(300),
    createDate timestamp,
    updateDate timestamp
);

create table user
(
    id         bigint auto_increment primary key,
    userName   varchar(10),
    email      varchar(30),
    password   varchar(20),
    createDate timestamp,
    updateDate timestamp
)
