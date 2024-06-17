--Datos para carga inicial de la base de datos

delete from envios;
delete from transportistas;
delete from pedidosTransportista;
delete from movimientos;

insert into envios(nref,nombreEmisor,correoEmisor,direccionEmisor,nombreReceptor, correoReceptor, direccionReceptor, largo, ancho, alto, peso, precio, instrExtra) values 
	(1, "Juan", "juan@gmail.com", "Calle Uría 53, 4B", "Marisa", "marisa@gmail.com", "Calle Julián Clavería 13, 2C", 7.6, 2.3, 8.9, 4.75, 9.45, ""),
	(2, "Lucía", "lucia@gmail.com", "Calle Alejandro Casona 21, 3A", "Nora", "nora@gmail.com", "Avenida Buenavista 4, 1B", 11.7, 5.1, 7.4, 7.8, 11.35, "Si nadie contesta en el destino, dejar el paquete al portero Miguel"),
	(3, "Marta", "marta@gmail.com", "Calle Fernando Alonso 33, 3C", "Julia", "julia@gmail.com", "Calle de Argüelles 11, 4A", 46.8, 23.6, 7.98, 4.67, 38.45, ""),
	(4, "Felipe", "felipe@gmail.com", "Calle Ramiro I Rey 2, bajo izda", "Sara", "sara@gmail.com", "Calle Quintana 6, 5C", 3.6, 3.7, 2.4, 6.25, 18.34, ""),
	(5, "Daniel", "daniel@gmail.com", "Calle Sta Susana 9, 1B", "Hector", "hector@gmail.com", "Calle Luis Braille 7, 2A", 9.56, 37.8, 5.24, 12.62, 27.73, ""),
	(6, "Carla", "carla@gmail.com", "Calle Prao Picón 3, 2A", "Andres", "andres@gmail.com", "Calle Villar 5, 1C", 5.89, 26.48, 4.7, 12.57, 37.98, ""),
	(7, "Begoña", "begoña@gmail.com", "Calle Celestino Álvarez 7, 1C", "Jorge", "jorge@gmail.com", "Calle Adolfo Posada 13, 3B", 36.78, 6.2, 8.9, 4.76, 36.46, "Dejar paquete debajo del felpudo"),
	(8, "Manuela", "manuela@gmail.com", "Calle Cervantes 11, 4B", "Jacobo", "jacobo@gmail.com", "Calle Otero 21, 4C", 8.4, 7.35, 29.98, 4.8, 41.08, ""),
	(9, "Covadonga", "covadonga@gmail.com", "Calle Caveda 4, 2C", "Ines", "ines@gmail.com", "Calle Burriana 18, 6A", 58.9, 45.23, 17.9, 15.56, 65.76, "");

insert into transportistas(id) values
	(1),
	(2),
	(3);

insert into pedidosTransportista(id,nref,nombreEmisor,correoEmisor,direccionEmisor,direccionReceptor,fechaEntrega) values
	(1, 1, "Juan", "juan@gmail.com", "Calle Uría 53, 4B", "Calle Julián Clavería 13, 2C", "2024-06-22"),
	(1, 4, "Felipe", "felipe@gmail.com", "Calle Ramiro I Rey 2, bajo izda", "Calle Quintana 6, 5C", "2024-07-08"),
	(1, 9, "Covadonga", "covadonga@gmail.com", "Calle Caveda 4, 2C", "Calle Burriana 18, 6A", "2024-06-26"),
	(2, 3, "Marta", "marta@gmail.com", "Calle Fernando Alonso 33, 3C", "Calle de Argüelles 11, 4A", "2024-07-14"),
	(2, 5, "Daniel", "daniel@gmail.com", "Calle Sta Susana 9, 1B", "Calle Luis Braille 7, 2A", "2024-07-03"),
	(2, 6, "Carla", "carla@gmail.com", "Calle Prao Picón 3, 2A", "Calle Villar 5, 1C", "2024-07-07"),
	(3, 2, "Lucía", "lucia@gmail.com", "Calle Alejandro Casona 21, 3A", "Avenida Buenavista 4, 1B", "2024-06-30"),
	(3, 7, "Begoña", "begoña@gmail.com", "Calle Celestino Álvarez 7, 1C", "Calle Adolfo Posada 13, 3B", "2024-07-22"),
	(3, 8, "Manuela", "manuela@gmail.com", "Calle Cervantes 11, 4B", "Calle Otero 21, 4C", "2024-07-11");

insert into movimientos(id,nref,movimiento,ubicacion,fechaMov) values
	(1, 1, "Carga", "Calle Julián Clavería 13, 2C", "2024-06-03 10:41:37"),
	(1, 1, "Descarga", "Almacén San Francisco de la Vera", "2024-06-03 16:34:12"),
	(1, 1, "Carga", "Almacén San Francisco de la Vera", "2024-06-05 11:08:46"),
	(1, 1, "Descarga", "Oficina Correos Calle Santo Ángel, Oviedo", "2024-06-05 18:24:29"),
	(2, 5, "Carga", "Calle Sta Susana 9, 1B", "2024-06-08 16:56:31"),
	(2, 5, "Descarga", "Almacén San Francisco de la Vera", "2024-06-08 19:34:15"),
	(3, 7, "Carga", "Calle Celestino Álvarez 7, 1C", "2024-06-11 12:09:34"),
	(3, 7, "Descarga", "Oficina Correos Calle Santo Ángel, Oviedo", "2024-06-11 15:19:52"),
	(3, 7, "Carga", "Almacén San Francisco de la Vera", "2024-06-16 10:28:49");