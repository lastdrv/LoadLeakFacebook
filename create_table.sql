create table test.facebook
(
    phone       bigint       not null primary key,
    id          bigint       not null,
    first_name  varchar(100) null,
    second_name varchar(100) null,
    sex         varchar(100) null,
    city        varchar(500) null,
    region      varchar(500) null,
    status      varchar(100) null,
    work        varchar(500) null,
    date        varchar(100) null,
    unknown     varchar(500) null,
    birthday    varchar(100) null
);

create index facebook_phone_IDX
    on test.facebook (phone);