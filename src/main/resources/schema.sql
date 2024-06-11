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
    largo decimal(4,2),
    ancho decimal(4,2),
    alto decimal(4,2),
    peso decimal(4,2),
    precio decimal(4,2),
    instrExtra varchar(100)
);

create table Transportistas (
    id int primary key not null
);

create table PedidosTransportista (
    id int not null,
    nref int not null, 
    fechaEntrega date not null,
    PRIMARY KEY (id, nref)
);

create table Movimientos (
    id int not null,
    nref int not null, 
    movimiento varchar(20),
    ubicacion varchar(100),
    fechaMov date not null,
    PRIMARY KEY (id, nref)
);