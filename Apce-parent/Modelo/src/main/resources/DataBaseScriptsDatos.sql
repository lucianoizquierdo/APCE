-----Esto es para la carga de DATOS----------------
----------------------------------------SUCURSALES------------------------------------------------------------

INSERT INTO sucursales (idsucursal, ciudad, provincia, direccion, gerente_general, activa, telefono) VALUES (1, 'Capital Federal', 'Buenos Aires', 'Vieytes 913', 1, true, 46405478);
INSERT INTO sucursales (idsucursal, ciudad, provincia, direccion, gerente_general, activa, telefono) VALUES (2, 'General Roca', 'Rio Negro', 'Cangalle 2343', 1, true, 294144582);
INSERT INTO sucursales (idsucursal, ciudad, provincia, direccion, gerente_general, activa, telefono) VALUES (3, 'General Alvear', 'Mendoza', 'Viena 35', 1, true, 26257208);
INSERT INTO sucursales (idsucursal, ciudad, provincia, direccion, gerente_general, activa, telefono) VALUES (4, 'Carlos Paz', 'Cordoba', 'Junin 107', 1, true, 265998789);

----------------------------------------USUARIOS----------------------------------------------------

INSERT INTO usuarios (idusuario, nombre, apellido, aliasusuario, dni, idsucursal, fecha_nacimiento, telefono, direccion, activo, pass) VALUES (1, 'Jorge ', 'Barbagallo', 'jbarbagallo', 30154587, 1, '2012-08-27', 1168598989, 'Alberdi 1052', true, 'jbarbagallo');
INSERT INTO usuarios (idusuario, nombre, apellido, aliasusuario, dni, idsucursal, fecha_nacimiento, telefono, direccion, activo, pass) VALUES (2, 'Carlos', 'Lopez', 'clopez', 30154589, 1, '2012-08-20', 1168598981, 'Ruiz de los Llanos 3434', true, 'clopez');
INSERT INTO usuarios (idusuario, nombre, apellido, aliasusuario, dni, idsucursal, fecha_nacimiento, telefono, direccion, activo, pass) VALUES (3, 'Jorge', 'Napolitano', 'jnapolitano', 30154581, 2, '1878-08-20', 1168598982, 'Marcos Sastre 34', true, 'jnapolitano');
INSERT INTO usuarios (idusuario, nombre, apellido, aliasusuario, dni, idsucursal, fecha_nacimiento, telefono, direccion, activo, pass) VALUES (4, 'Carlos', 'Fiorda', 'cfiorda', 30154582, 3, '1855-08-20', 1168598983, 'Nogoya 3435', true, 'cfiorda');
INSERT INTO usuarios (idusuario, nombre, apellido, aliasusuario, dni, idsucursal, fecha_nacimiento, telefono, direccion, activo, pass) VALUES (5, 'Eduardo', 'Lopez', 'elopez', 30154583, 4, '1880-08-20', 1168598984, 'Baigorria 21', true, 'elopez');


-----------------------------------------ROLES----------------------------------------------------------------------------------------------------------------------

INSERT INTO roles (id_rol, descripcion) VALUES (1, 'Perfil de Administrador Supremo');

-----------------------------------------PERMISOS---------------------------------------------------------------------------------------------------------------------------------------------------------------------------

INSERT INTO permisos (id_permiso, descripcion) VALUES (1, 'LoginController');

------------------------------------------PERFILES--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

INSERT INTO perfiles (id_perfil, descripcion) VALUES (1, 'Alta de usuarios en el sistema');
INSERT INTO perfiles (id_perfil, descripcion) VALUES (2, 'Alta de materias primas en el sistema');

------------------------------------------MATERIAS PRIMAS--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

INSERT INTO materias_primas (codigo_materia_prima, tipo, tamanio, color, descripcion, kilos, litros, activa) VALUES ('codigo1', 'rollo', '40 cm', 'rojo', 'rollo de papel', 60, 60, false);

