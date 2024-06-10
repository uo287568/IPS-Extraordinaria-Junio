--Datos para carga inicial de la base de datos

delete from envios;

insert into envios(nref,nombreEmisor,correoEmisor,direccionEmisor,nombreReceptor, correoReceptor, direccionReceptor, largo, ancho, alto, peso, precio, instrExtra) values 
	(1, "Juan", "juan@gmail.com", "Calle Uría 53, 4B", "Marisa", "marisa@gmail.com", "Calle Julián Clavería 13, 2C", 7.6, 2.3, 8.9, 4.75, 9.45, ""),
	(2, "Lucía", "lucia@gmail.com", "Calle Alejandro Casona 21, 3A", "Nora", "nora@gmail.com", "Avenida Buenavista 4, 1B", 11.7, 5.1, 7.4, 7.8, 11.35, "Si nadie contesta en el destino, dejar el paquete al portero Miguel");
