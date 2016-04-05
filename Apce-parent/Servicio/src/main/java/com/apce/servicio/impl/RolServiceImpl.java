package com.apce.servicio.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apce.modelo.Rol;
import com.apce.persistencia.interfaz.BaseDAO;
import com.apce.persistencia.interfaz.RolDAO;
import com.apce.servicio.servicoInterfaz.RolService;

@Service
@Transactional
public class RolServiceImpl implements RolService {

	
	@Inject
	private RolDAO dao;
	
	
	@Override
	public void setDao(BaseDAO dao) {
		// TODO Auto-generated method stub
		this.dao = (RolDAO)dao;
	}

	@Override
	public List<Rol> getRoles() {
		// TODO Auto-generated method stub
		return dao.getRoles();
	}

	@Override
	public Rol getRol(Integer idRol) {
		// TODO Auto-generated method stub
		return dao.getRol(idRol);
	}
}
