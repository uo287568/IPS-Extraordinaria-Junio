--Primero se deben borrar todas las tablas (de detalle a maestro) y lugo anyadirlas (de maestro a detalle)
--(en este caso en cada aplicacion se usa solo una tabla, por lo que no hace falta)

--Para giis.demo.tkrun:
drop table Envios;
drop table Transportistas;
drop table PedidosTransportista;
drop table Movimientos;

create table Envios (
    nref int primary key not null, 
    nombreEmisor varchar(20), 
    correoEmisor varchar(50),
    direccionEmisor varchar(100),
    nombreReceptor varchar(20), 
    correoReceptor varchar(50),
    direccionReceptor varchar(100),
    largo int,
    ancho int,
    alto int,
    peso int,
    precio int,
    instrExtra varchar(100)
);

create table Transportistas (
    id int primary key not null
);

create table PedidosTransportista (
    id int primary key not null
    nref int primary key not null, 
    direccionEmisor varchar(100),
    nombreReceptor varchar(20), 
    correoReceptor varchar(50),
    direccionReceptor varchar(100),
    fechaEntrega date not null
);

create table Movimientos (
    id int primary key not null
    nref int primary key not null, 
    movimiento varchar(20),
    ubicacion varchar(100),
    fechaMov date not null
);