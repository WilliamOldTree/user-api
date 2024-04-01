create schema if not exists users;
create table users.user (
                            id bigserial primary key,
                            name varchar(100) not null,
                            txId varchar(100) not null,
                            andress varchar(100) not null,
                            email varchar(100) not null,
                            phoneNumber varchar(100) not null,
                            dateTimeInput timestamp not null
);