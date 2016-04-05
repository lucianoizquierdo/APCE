select * from sucursales ;
select * from usuarios;
select * from roles;
select * from usuario_rol;

select * from usuarios where tolo.id_usuario = usuarios.idusuario
(select * from usuario_rol where id_rol = 1) as tolo


select * from usuarios u, (select ur.id_usuario from usuario_rol ur where ur.id_rol=1) tolo
where u.idUsuario = tolo.id_usuario