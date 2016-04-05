package com.apce.persistencia.interfaz;

import java.util.List;

import com.apce.modelo.Cinta;
import com.apce.modelo.Usuario;
import com.apce.modelo.kendo.DataSourceRequest;
import com.apce.modelo.kendo.DataSourceResult;


public interface CintaDAO extends BaseDAO {
	
	
//	public Usuario getCinta(Long idCinta);
//	
//	public void altaCinta(Cinta cin);
//	
//	public void bajaCinta(Cinta cin);
//	
//	public void bajaCinta(Long idCinta);
//	
//	public void modificarUsuario(Usuario usu);
//	
//	public void modificarUsuario(Integer idusuario);
//
//	public boolean existeUser(String aliasUsuario, Integer idSucursal);
//
//	public List<Usuario> getUsuariosNoActivos(Integer IdSucrusal);
//
//	public Usuario getUsuario(String user);
//
//	public List<Usuario> getUsuariosGerentes();
//
//	public Usuario getUsuario(Integer idUsuario);
	
	//Kendo
//	public DataSourceResult getLista(DataSourceRequest dsr);

	public void saveOrUptade(Cinta cin);

}
