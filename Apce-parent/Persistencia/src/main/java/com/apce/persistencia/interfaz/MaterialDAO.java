package com.apce.persistencia.interfaz;

import com.apce.modelo.Material;

public interface MaterialDAO  extends BaseDAO {
	
	

	public void saveOrUptade(Material m);

}