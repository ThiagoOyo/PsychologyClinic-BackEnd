create table patients
(

    id           bigint       not null auto_increment,
    first_name   varchar(100) not null,
    last_name    varchar(100) not null,
    email        varchar(100) not null unique,
    cellphone    varchar(20) not null,
    cpf          varchar(11)   not null unique,
    street       varchar(100) not null,
    district     varchar(100) not null,
    cep          varchar(9)   not null,
    complement   varchar(100),
    address_number varchar(20),
    uf           char(2)      not null,
    city         varchar(100) not null,

    primary key (id)

);