create table ips(
    id         serial not null primary key ,
    ip         varchar(20) not null,
    time       date not null
);