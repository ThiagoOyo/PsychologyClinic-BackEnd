create table psychologists
(

    id           bigint       not null auto_increment,
    first_name    varchar(100) not null,
    last_name     varchar(100) not null,
    email        varchar(100) not null unique,
    crp          varchar(6)   not null unique,
    specialty    varchar(100) not null,
    street       varchar(100) not null,
    district     varchar(100) not null,
    cep          varchar(9)   not null,
    complement   varchar(100),
    address_number varchar(20),
    uf           char(2)      not null,
    city         varchar(100) not null,

    primary key (id)

);