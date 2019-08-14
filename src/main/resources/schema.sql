drop table contacto if exists;

create table contacto (
    id integer not null,
    apellido varchar(255),
    ciudad varchar(255),
    codigo_postal varchar(255),
    domicilio varchar(255),
    estado varchar(255),
    pais varchar(255),
    email varchar(255),
    movil varchar(255),
    nacimiento date,
    nombre varchar(255),
    telefono varchar(255),
    primary key (id));
