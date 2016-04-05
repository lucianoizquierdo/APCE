#########################################
############ ESQUEMA PUBLIC #############
#########################################
-------------------------------------CREACION DE LA BASE-------------------------------------------

-- Database: apce_desa

-- DROP DATABASE apce_desa;

CREATE DATABASE apce_desa
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'Spanish_Spain.1252'
       LC_CTYPE = 'Spanish_Spain.1252'
       CONNECTION LIMIT = -1;
GRANT ALL ON DATABASE apce_desa TO public;
GRANT ALL ON DATABASE apce_desa TO postgres;
COMMENT ON DATABASE apce_desa IS 'Base de apce de desarrollo';


---------------------------------------orden_produccion secuencer -----------------------------------------
-- Sequence: orden_produccion_seq

-- DROP SEQUENCE orden_produccion_seq;

CREATE SEQUENCE orden_produccion_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
---------------------------------------estandar produccion secuencer -----------------------------------------
-- Sequence: estandar_produccion_seq

-- DROP SEQUENCE estandar_produccion_seq;

CREATE SEQUENCE estandar_produccion_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

---------------------------------------usuarios secuencer -----------------------------------------
-- Sequence: usuarios_seq

-- DROP SEQUENCE usuarios_seq;

CREATE SEQUENCE usuarios_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
  
  ---------------------------------------material_seq -----------------------------------------
-- Sequence: material_seq

-- DROP SEQUENCE material_seq;

CREATE SEQUENCE material_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
--------------------------------------- sucursales secuencer -----------------------------------------
-- Sequence: usuarios_seq

-- DROP SEQUENCE sucursales_seq;

CREATE SEQUENCE sucursales_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

--------------------------------------- materias primas secuencer -----------------------------------------

-- Sequence: materias_primas_seq

-- DROP SEQUENCE materias_primas_seq;

CREATE SEQUENCE materias_primas_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 9
  CACHE 1;


--------------------------------------- tipo materia prima secuencer -----------------------------------------

-- Sequence: tipo_materia_prima_seq

-- DROP SEQUENCE tipo_materia_prima_seq;

CREATE SEQUENCE tipo_materia_prima_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 9
  CACHE 1;

---------------------------------------solicitud produccion secuencer -----------------------------------------
-- Sequence: solicitud_produccion_seq

-- DROP SEQUENCE solicitud_produccion_seq;

CREATE SEQUENCE solicitud_produccion_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

---------------------------------------produccion secuencer -----------------------------------------
-- Sequence: produccion_seq

-- DROP SEQUENCE produccion_seq;

CREATE SEQUENCE produccion_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

---------------------------------------cinta secuencer -----------------------------------------
-- Sequence: cinta_seq

-- DROP SEQUENCE cinta_seq;

CREATE SEQUENCE cinta_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

--------------------------------------sucursales---------------------------------------------------
-- Table: sucursales

-- DROP TABLE sucursales;


CREATE TABLE sucursales
(
  idsucursal smallint NOT NULL  DEFAULT nextval('sucursales_seq'),
  ciudad text,
  provincia text,
  direccion text,
  gerente_general integer,
  activa boolean,
  CONSTRAINT sucursales_pkey PRIMARY KEY (idsucursal)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE sucursales ADD COLUMN telefono integer;
ALTER TABLE sucursales OWNER TO postgres;
GRANT ALL ON TABLE sucursales TO postgres;
GRANT ALL ON TABLE sucursales TO public;

---------------------------------------estandar_produccion-----------------------------------------------------
-- Table: estandar_produccion

-- DROP TABLE estandar_produccion;

CREATE TABLE estandar_produccion
(
  id bigint NOT NULL DEFAULT nextval('estandar_produccion_seq'::regclass),
  formato1 text,
  formato2 text,
  fondo text,
  film text,
  impreso smallint,
  tintaLitros bigint,
  adhesivoKilos bigint,
  pigmentoKilos bigint,
  diluyenteLitros bigint,
  aditivoKilos bigint,
  fecha_alta date,
  tiempo_estimado bigint,
  CONSTRAINT pk_estandar_produccion_id PRIMARY KEY (id),
  CONSTRAINT "UQ_estandar_produccion" UNIQUE (formato1,formato2,fondo,film,impreso)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE cinta
  OWNER TO postgres;

  ---------------------------------------orden_produccion-----------------------------------------------------
-- Table: orden_produccion

-- DROP TABLE orden_produccion;

CREATE TABLE orden_produccion
(
  id bigint NOT NULL DEFAULT nextval('orden_produccion_seq'::regclass),
  nombre text,
  descripcion text,
  observaciones text,
  id_solicitud_produccion bigint,
  empaque integer,
  tinta1_litros bigint,
  tinta2_litros bigint,
  tinta3_litros bigint,
  adhesivo_kilos bigint,
  pigmento_kilos bigint,
  diluyente_litros bigint,
  aditivo_kilos bigint,
  tiempo_estimado bigint, --en minutos
  fecha_alta date,
  fecha_procesada date,
  procesada boolean,
  id_usuario integer,
  CONSTRAINT pk_orden_produccion_id PRIMARY KEY (id),
   CONSTRAINT fk_orden_produccion_solicitud_produccion FOREIGN KEY (id_solicitud_produccion)
      REFERENCES solicitud_produccion (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE orden_produccion
  OWNER TO postgres;
---------------------------------------cinta-----------------------------------------------------
-- Table: cinta

-- DROP TABLE cinta;

CREATE TABLE cinta
(
  id bigint NOT NULL DEFAULT nextval('cinta_seq'::regclass),
  formato1 text,
  formato2 text,
  nombre text,
  descripcion text,
  empaque numeric,
  impreso smallint,
  fecha_alta date,
  CONSTRAINT pk_cinta_id PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE cinta
  OWNER TO postgres;


---------------------------------------colorxcinta-----------------------------------------------------
-- Table: colorxcinta

-- DROP TABLE colorxcinta;

CREATE TABLE colorxcinta
(
  id_cinta bigint,
  color text,
  CONSTRAINT fk_colorxcinta_cinta FOREIGN KEY (id_cinta)
      REFERENCES cinta (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "UQ_colorxcinta" UNIQUE (id_cinta, color)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE colorxcinta
  OWNER TO postgres;
  
  ---------------------------------------solicitud_produccion-----------------------------------------------------
-- Table: solicitud_produccion

-- DROP TABLE solicitud_produccion;

CREATE TABLE solicitud_produccion
(
  id bigint NOT NULL DEFAULT nextval('solicitud_produccion_seq'::regclass),
  fecha_alta date,
  id_usuario integer,
  nombre text,
  descripcion text,
  observaciones text,
  formato1 text,
  formato2 text,
  fondo text,
  film text,
  impreso integer,
  caja text,
  color1 text,
  color2 text,
  color3 text,
  id_tinta1 bigint,
  id_tinta2 bigint,
  id_tinta3 bigint,
  id_adhesivo bigint,
  id_pigmento bigint,
  id_diluyente bigint,
  id_aditivo bigint,
  cantidad_rollos integer,
  id_orden_produccion bigint,
  CONSTRAINT pksolicitud_produccion_id PRIMARY KEY (id),
  CONSTRAINT fk_orden_produccion FOREIGN KEY (id_orden_produccion)
      REFERENCES orden_produccion (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
  )
WITH (
  OIDS=FALSE
);
ALTER TABLE solicitud_produccion
  OWNER TO postgres;
  
---------------------------------------colorxsolicitud_produccion-----------------------------------------------------
-- Table: colorxsolicitud_produccion

-- DROP TABLE colorxsolicitud_produccion;

CREATE TABLE colorxsolicitud_produccion
(
  id_solicitud_produccion bigint,
  color text,
  CONSTRAINT fk_colorxsolicitud_produccion_solicitud_produccion FOREIGN KEY (id_solicitud_produccion)
      REFERENCES solicitud_produccion (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "UQ_colorxsolicitud_produccion" UNIQUE (id_solicitud_produccion, color)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE colorxsolicitud_produccion
  OWNER TO postgres;
  
  
  ---------------------------------------material-----------------------------------------------------
-- Table: material

-- DROP TABLE material;
/*
 * Esta tabla sirve para poner la cantidad de material o materia prima que tiene un estandar de produccion en especial.
 */

CREATE TABLE material
(
  id bigint NOT NULL DEFAULT nextval('material_seq'::regclass),
  kilos integer,
  litros integer,
  cantidad integer,
  id_materia_prima bigint,
  id_produccion bigint,  
  CONSTRAINT pk_material_id PRIMARY KEY (id),
  CONSTRAINT fk_material_materias_primas FOREIGN KEY (id_materia_prima)
      REFERENCES materias_primas (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
      CONSTRAINT fk_material_produccion FOREIGN KEY (id_produccion)
      REFERENCES produccion (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
  
)
WITH (
  OIDS=FALSE
);
ALTER TABLE material
  OWNER TO postgres;


---------------------------------------produccion-----------------------------------------------------
-- Table: produccion

-- DROP TABLE produccion;
	
CREATE TABLE produccion
(
  id bigint NOT NULL DEFAULT nextval('produccion_seq'::regclass),
  id_cinta bigint,
  CONSTRAINT pk_produccion_id PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE produccion
  OWNER TO postgres;


---------------------------------------usuarios-----------------------------------------------------
-- Table: usuarios

-- DROP TABLE usuarios;

CREATE TABLE usuarios
(
  "idusuario" integer NOT NULL  DEFAULT nextval('usuarios_seq'),
  nombre text,
  apellido text,
  "aliasusuario" text,
  dni numeric,
  "idsucursal" smallint,
  fecha_nacimiento date,
  telefono numeric,
  direccion text,
  activo boolean,
  pass text,
  rol smallint,
  CONSTRAINT usuarios_pkey PRIMARY KEY ("idusuario"),
  CONSTRAINT "usuarios_idSucursal_fkey" FOREIGN KEY ("idsucursal")
      REFERENCES sucursales ("idsucursal") MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE usuarios OWNER TO postgres;


---------------------------------------materias_primas-----------------------------------------------------

-- Table: materias_primas

-- DROP TABLE materias_primas;

CREATE TABLE materias_primas
(
  id bigint NOT NULL DEFAULT nextval('materias_primas_seq'::regclass),
  codigo_materia_prima text NOT NULL,
  tipo_materia_prima text,
  color text,
  descripcion text,
  activa boolean,
  CONSTRAINT codigo_materia_prima PRIMARY KEY (id),
  CONSTRAINT "UK_codigo_materia_prima" UNIQUE (codigo_materia_prima)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE materias_primas
  OWNER TO postgres;
  
  ---------------------------------------tipo_materia_prima-----------------------------------------------------

-- Table: tipo_materia_prima

-- DROP TABLE tipo_materia_prima;

CREATE TABLE tipo_materia_prima
(
  id bigint NOT NULL DEFAULT nextval('tipo_materia_prima_seq'::regclass),
  nombre text,
  descripcion text,
  CONSTRAINT id PRIMARY KEY (id),
  CONSTRAINT "UK_nombre" UNIQUE (nombre)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE tipo_materia_prima
  OWNER TO postgres;


---------------------------------------ROLES----------------------------------------------------------
-- Table: roles

-- DROP TABLE roles;

CREATE TABLE roles
(
  id_rol smallint NOT NULL,
  descripcion text,
  CONSTRAINT roles_pkey PRIMARY KEY (id_rol)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE roles OWNER TO postgres;
COMMENT ON TABLE roles IS 'tabla de roles';
--------------------------------------PERFILES---------------------------------------------------------
-- Table: perfiles

-- DROP TABLE perfiles;

CREATE TABLE perfiles
(
  "id_perfil" smallint NOT NULL,
  descripcion text,
  controller text,
  CONSTRAINT perfiles_pkey PRIMARY KEY ("id_perfil")
)
WITH (
  OIDS=FALSE
);
ALTER TABLE perfiles OWNER TO postgres;
--------------------------------------PERMISOS---------------------------------------------------------
-- Table: permisos

-- DROP TABLE permisos;

CREATE TABLE permisos
(
  id_permiso integer NOT NULL,
  descripcion text,
  CONSTRAINT pl_id_permiso PRIMARY KEY (id_permiso)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE permisos OWNER TO postgres;
-------------------------------------PERFIL-PERMISO------------------------------------
-- Table: perfil_permiso

-- DROP TABLE perfil_permiso;

CREATE TABLE perfil_permiso
(
  id_perfil smallint,
  id_permiso integer,
  CONSTRAINT fk_id_perfil FOREIGN KEY (id_perfil)
      REFERENCES perfiles (id_perfil) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_id_permiso FOREIGN KEY (id_permiso)
      REFERENCES permisos (id_permiso) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE perfil_permiso OWNER TO postgres;
------------------------------------ROL-PERFIL---------------------------------------------------
-- Table: rol_perfil

-- DROP TABLE rol_perfil;

CREATE TABLE rol_perfil
(
  id_rol smallint,
  id_perfil smallint,
  CONSTRAINT fk_id_perfil FOREIGN KEY (id_perfil)
      REFERENCES perfiles (id_perfil) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_id_rol FOREIGN KEY (id_rol)
      REFERENCES roles (id_rol) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE rol_perfil OWNER TO postgres;
-----------------------------------USUARIO-ROL----------------------------------------------------
-- Table: usuario_rol

-- DROP TABLE usuario_rol;

CREATE TABLE usuario_rol
(
  id_usuario integer NOT NULL,
  id_rol smallint NOT NULL,
  CONSTRAINT pk_id_usuario_and_pk_id_rol PRIMARY KEY (id_usuario, id_rol),
  CONSTRAINT fk_id_rol FOREIGN KEY (id_rol)
      REFERENCES roles (id_rol) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_id_usuario FOREIGN KEY (id_usuario)
      REFERENCES usuarios (idusuario) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE usuario_rol OWNER TO postgres;
----------------------------------FUNCIONES------------------------------------------------------
-- Table: funciones

-- DROP TABLE funciones;

CREATE TABLE funciones
(
  id_funcion integer NOT NULL,
  descripcion text,
  link text,
  CONSTRAINT pk_id_funcion PRIMARY KEY (id_funcion)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE funciones OWNER TO postgres;
----------------------------------ROL_FUNCION------------------------------------------------------
-- Table: rol_funcion

-- DROP TABLE rol_funcion;

CREATE TABLE rol_funcion
(
  id_rol smallint NOT NULL,
  id_funcion integer NOT NULL,
  CONSTRAINT "pk_id_rol-and-id_funcion" PRIMARY KEY (id_rol, id_funcion),
  CONSTRAINT "fk-_id_rol" FOREIGN KEY (id_rol)
      REFERENCES roles (id_rol) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT "fk-id_funcion" FOREIGN KEY (id_funcion)
      REFERENCES funciones (id_funcion) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE rol_funcion OWNER TO postgres;
----------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------
----------------------------------------------------------------------------------------


