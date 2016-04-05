package com.apce.servicio.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apce.modelo.Usuario;
import com.apce.modelo.kendo.DataSourceRequest;
import com.apce.modelo.kendo.DataSourceResult;
import com.apce.persistencia.interfaz.BaseDAO;
import com.apce.persistencia.interfaz.UsuarioDAO;
import com.apce.servicio.servicoInterfaz.UsuarioService;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

	@Inject
	private UsuarioDAO dao;

	@Override
	public void setDao(BaseDAO dao) {
		// TODO Auto-generated method stub
		this.dao = (UsuarioDAO)dao;
	}

	@Override
	public boolean existeUser(String aliasUsuario, Integer idSucursal) {
		// TODO Auto-generated method stub
		
		boolean existeUsuario = this.dao.existeUser(aliasUsuario,idSucursal);
		return existeUsuario;
	}

	@Override
	public Usuario getUsuario(String user, String pass, Integer sucursal) {
		// TODO Auto-generated method stub
		return dao.getUsuario(user, pass, sucursal);
	}

	@Override
	public void altaUsuario(Usuario usu) {
		// TODO Auto-generated method stub
		dao.altaUsuario(usu);
	}

	@Override
	public void bajaUsuario(Usuario usu) {
		// TODO Auto-generated method stub
		dao.bajaUsuario(usu);
	}

	@Override
	public void modificarUsuario(Usuario usu) {
		// TODO Auto-generated method stub
		dao.modificarUsuario(usu);
	}

	@Override
	public List<Usuario> getUsuariosNoActivos(Integer idSucursal) {
		// TODO Auto-generated method stub
		return dao.getUsuariosNoActivos(idSucursal);
	}

	@Override
	public Usuario getUsuario(String user) {
		// TODO Auto-generated method stub
		return dao.getUsuario(user);
	}

	@Override
	public Object getUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> getUsuariosGerentes() {
		// TODO Auto-generated method stub
		return dao.getUsuariosGerentes();
	}

	@Override
	public Usuario getUsuario(Integer idUsuario) {
		// TODO Auto-generated method stub
		return dao.getUsuario(idUsuario);
		
	}

	/*
	@Override
	public UserDetails loadUserByUsername(String user)
			throws UsernameNotFoundException, DataAccessException {
		// TODO Auto-generated method stub
		
		dao.getUsuario(user);
		return null;
	}
*/
	
	@Override
	public DataSourceResult getLista(DataSourceRequest request) {
		// TODO Auto-generated method stub
		return dao.getLista(request);
	}

	@Override
	public void saveOrUpdate(Usuario usu) {

		dao.saveOrUpdate(usu);
		
	}

}
