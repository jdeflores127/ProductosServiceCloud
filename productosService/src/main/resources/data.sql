INSERT INTO tbl_Categoria(idCategoria,nombre,descripcion) VALUES (1,'Frituras','productos a base de maiz y chile');
INSERT INTO tbl_Categoria(idCategoria,nombre,descripcion) VALUES (2,'Limpieza','productos para la limpieza del hogar');
INSERT INTO tbl_Categoria(idCategoria,nombre,descripcion) VALUES (3,'Conservas','alimentos perecederos y enlatados');

INSERT INTO tbl_Producto(idProducto,nombre,precio,descripcion,fechaRegistro,idCategoria,existencias) VALUES
(1,'Cheetos naranjas',20.00,'frituras con sabor a queso y chile',CURRENT_TIMESTAMP,1,150);

INSERT INTO tbl_Producto(idProducto,nombre,precio,descripcion,fechaRegistro,idCategoria,existencias) VALUES
(2,'Sabritas Saladas',30.00,'frituras de papa sabor a sal',CURRENT_TIMESTAMP,1,200);

INSERT INTO tbl_Producto(idProducto,nombre,precio,descripcion,fechaRegistro,idCategoria,existencias) VALUES
(3,'Doritos Diablo',17.00,'Totopos de maiz con chile acido',CURRENT_TIMESTAMP,1,2);

INSERT INTO tbl_Producto(idProducto,nombre,precio,descripcion,fechaRegistro,idCategoria,existencias) VALUES
(4,'Pinol verde',34.50,'Producto para limpieza de pisos con olor a pino',CURRENT_TIMESTAMP,2,300);

INSERT INTO tbl_Producto(idProducto,nombre,precio,descripcion,fechaRegistro,idCategoria,existencias) VALUES
(5,'Clorox normal',50.50,'Producto para hacerte la auto-morision cuando andas re sad :v',CURRENT_TIMESTAMP,2,0);

INSERT INTO tbl_Producto(idProducto,nombre,precio,descripcion,fechaRegistro,idCategoria,existencias) VALUES
(6,'Atun dolores',15.50,'Producto a base de atun en awa',CURRENT_TIMESTAMP,3,89);
