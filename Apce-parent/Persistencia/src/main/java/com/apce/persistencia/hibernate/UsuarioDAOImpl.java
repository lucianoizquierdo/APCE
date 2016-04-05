package com.apce.persistencia.hibernate;

import java.util.List;

import com.apce.modelo.Usuario;
import com.apce.modelo.kendo.DataSourceRequest;
import com.apce.modelo.kendo.DataSourceResult;
import com.apce.persistencia.interfaz.UsuarioDAO;

public class UsuarioDAOImpl extends BaseDaoImpl implements UsuarioDAO{

	public UsuarioDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	public void altaUsuario(Usuario usu) {
		// TODO Auto-generated method stub
		usu.setActivo(true);
		getHibernateTemplate().save(usu);
	}

	public void bajaUsuario(Usuario usu) {
		// TODO Auto-generated method stub
		//Lo borro logicamente
		usu.setActivo(false);
		getHibernateTemplate().saveOrUpdate(usu);
	}

	public void bajaUsuario(Integer idUsuario) {
		// TODO Auto-generated method stub

	}

	public void modificarUsuario(Usuario usu) {
		// TODO Auto-generated method stub
		getHibernateTemplate().saveOrUpdate(usu);

	}

	public void modificarUsuario(Integer idusuario) {
		// TODO Auto-generated method stub

	}

	public boolean existeUser(String alias, Integer idSucursal) {
		// TODO Auto-generated method stub
		List<Usuario> usuarios = getHibernateTemplate().find("select u from Usuario u where u.aliasUsuario = " +  "'" + alias + "'" +  "AND u.idSucursal = " + "'" +  idSucursal + "'");
		if(usuarios.size() != 0)
			return true;
		else
			return false;
	}


	public Usuario getUsuario(String user, String pass, Integer idSucursal) {
		// TODO Auto-generated method stub
		List<Usuario> usuarios = getHibernateTemplate().find("select u from Usuario u where u.aliasUsuario = " + user + " AND u.pass =" + pass  + " AND u.idSucursal = " + idSucursal);
		if(usuarios.size() != 0)
			return usuarios.get(0);
		else
			return null;

	}

	@Override
	public List<Usuario> getUsuariosNoActivos(Integer idSucursal) {
		// TODO Auto-generated method stub
		List<Usuario> usuarios = getHibernateTemplate().find("select u from Usuario u where u.idSucursal = " + idSucursal + " AND u.activo = 'false'");
		if(usuarios.size() != 0)
			return usuarios;
		else
			return null;

	}

	@Override
	public Usuario getUsuario(String user) {
		// TODO Auto-generated method stub
		List<Usuario> usuarios = getHibernateTemplate().find("select u from Usuario u where u.aliasUsuario = " +  "'" + user +  "'" );
		if(usuarios.size() != 0)
			return usuarios.get(0);
		else
			return null;
	}

	@Override
	public List<Usuario> getUsuariosGerentes() {
		// TODO Auto-generated method stub
		//Rol 1 o el que sea deberia ser el rol de gerente general
		List<Usuario> usuarios = getHibernateTemplate().find("select u from Usuario u join u.roles roles where roles.id_rol = 1" );

		return usuarios;
	}

	@Override
	public Usuario getUsuario(Integer idUsuario) {
		// TODO Auto-generated method stub
		List<Usuario> usuarios = getHibernateTemplate().find("select u from Usuario u where u.idUsuario = " +  "'" + idUsuario +  "'" );
		if(usuarios.size() != 0)
			return usuarios.get(0);
		else
			return null;
	}
	
	@Override
	public DataSourceResult getLista(DataSourceRequest request) {
		return request.toDataSourceResult(getHibernateTemplate().getSessionFactory().getCurrentSession(), Usuario.class);
	}

	@Override
	public void saveOrUpdate(Usuario usu) {
		// TODO Auto-generated method stub
		 getHibernateTemplate().saveOrUpdate(usu);
	}
}
