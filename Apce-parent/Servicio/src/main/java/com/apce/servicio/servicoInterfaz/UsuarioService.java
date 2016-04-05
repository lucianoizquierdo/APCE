package com.apce.servicio.servicoInterfaz;

import java.util.List;

import com.apce.modelo.Usuario;
import com.apce.modelo.kendo.DataSourceRequest;
import com.apce.modelo.kendo.DataSourceResult;

/**
 * Clase que se encarga de los usuarios de la aplicacion
 * @author lizquier
 *
 */
public interface UsuarioService extends BaseService{
	
	/**
	 * Devuelve true si el usuario existe para esa sucursal, de caso contrario devuelve false
	 * @param user
	 * @param pass
	 * @param sucursal
	 * @return
	 */
	public boolean existeUser(String aliasUsuario, Integer idSucursal);
	
	/**
	 * Devuelve un usuario o null si el usuario no existe.
	 * @param user
	 * @param pass
	 * @param sucursal
	 * @return
	 */
	public Usuario getUsuario(String user, String pass, Integer sucursal);
	
	/**
	 * Devuelve un usuario o null si el usuario no existe.
	 * @param user
	 * @return Usuario
	 */
	public Usuario getUsuario(String user);
	
	public List<Usuario> getUsuariosGerentes();
	
	public void altaUsuario(Usuario usu); 

	public void bajaUsuario(Usuario usu) ;

	public void modificarUsuario(Usuario usu);
	
	public List<Usuario> getUsuariosNoActivos(Integer idSucursal);

	public Object getUsuarios();

	public Usuario getUsuario(Integer idUsuario);
	
	public DataSourceResult getLista(DataSourceRequest request);
	
	public void saveOrUpdate(Usuario usu);
}
