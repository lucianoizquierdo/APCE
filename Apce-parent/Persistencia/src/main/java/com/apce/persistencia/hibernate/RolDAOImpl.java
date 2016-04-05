package com.apce.persistencia.hibernate;

import java.util.List;

import javax.annotation.Resource;

import com.apce.modelo.Rol;
import com.apce.persistencia.interfaz.RolDAO;

@Resource
public class RolDAOImpl extends BaseDaoImpl implements RolDAO{

	public RolDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	public List<Rol> getRoles() {
		// TODO Auto-generated method stub
		List<Rol> roles = getHibernateTemplate().find("select r from Rol r");
			return roles;
	}

	@Override
	public Rol getRol(Integer idRol) {
		// TODO Auto-generated method stub
		List<Rol> roles = getHibernateTemplate().find("select r from Rol r where r.id_rol=" + idRol);
		return roles.get(0);
	}
}
