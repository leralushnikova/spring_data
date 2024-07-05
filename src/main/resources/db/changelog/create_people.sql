create table people(
    id         serial not null primary key ,
    first_name varchar(20) not null,
    last_name  varchar(20) not null,
    age        integer not null
);