EJEMPLOS HQL:


select u from Usuario u

select r from Rol r

--Te devuelve el id del rol donde el rol = 1
select r.id_rol from Rol r where r.id_rol =1

--Te devuelve todos los usuarios que tengan id rol = 1
select u
from Usuario u
join u.roles roles
where roles.id_rol = 1

--Este no entiendo bien que hace pero lo dejo por las dudas
select u from Usuario u, Usuario u2
where u2 in elements(u.roles)

--Esto busca la sucursales que tengan como genrente general la propiedad nombre con "carlos"
session.createCriteria(Sucursal.class).createAlias("gerenteGeneral", "g")
.add(Restrictions.ilike("g.nombre", "Carlos"));

--sirve para traer cuantas veces fueron usadas los adhesivos en todas las SP
select s.adhesivo.id,count(s.adhesivo.id) from SolicitudProduccion s group by (s.adhesivo.id)

--Me trae todas las materias primas que esten en alguna solicitud de produccion
select m  from MateriaPrima m
where m.id in (
    select s.adhesivo.id from SolicitudProduccion  s 
)

--me trae la materia prima y alado un numero que indica cuantas veces se utilizo en diferentes solicitudes de produccion       
select m,
       (select count(s.adhesivo.id) from SolicitudProduccion s where s.adhesivo.id = m.id) 
       from MateriaPrima m, SolicitudProduccion ss where ss.adhesivo.id = m.id group by m
       
       
select m,
       (select count(s.adhesivo.id) from SolicitudProduccion s where s.adhesivo.id = m.id and s.fechaAlta between '2009-11-27T21:57:18.010+01:00'  and '2013-11-27T21:57:18.010+01:00' ) 
       from MateriaPrima m, SolicitudProduccion ss where ss.adhesivo.id = m.id group by m
       
       
-- Me trae una fecha, y el numero de SP creadas en esa fecha
select s2.fechaAlta as fecha,
(select count(s1.fechaAlta) from SolicitudProduccion s1 where s1.fechaAlta = s2.fechaAlta) as count 
from SolicitudProduccion s2 group by s2.fechaAlta

-- Me trae una fecha, y el numero de SP creadas en esa fecha y ademas discriminado por dos fechas
select s2.fechaAlta as fecha,
(select count(s1.fechaAlta) from SolicitudProduccion s1 where s1.fechaAlta = s2.fechaAlta and s1.fechaAlta between '2013-01-01T21:57:18.010+01:00'  and '2013-01-30T21:57:18.010+01:00') as count 
from SolicitudProduccion s2 where s2.fechaAlta between '2013-01-01T21:57:18.010+01:00'  and '2013-01-30T21:57:18.010+01:00' 
group by s2.fechaAlta order by s2.fechaAlta asc

--me trae todas las SP que no tienen una OP asociada
from SolicitudProduccion s where s not in (select op.solicitudProduccion from OrdenProduccion op) 