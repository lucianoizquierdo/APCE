package com.apce.persistencia.interfaz;

import com.apce.modelo.Color;
import com.apce.modelo.EstandarProduccion;
import com.apce.modelo.Film;
import com.apce.modelo.Formato;

public interface EstandarProduccionDAO extends BaseDAO {
	
	public void saveOrUpdate(EstandarProduccion ep);
	
	public EstandarProduccion getEstandarProduccionById(Long id);
	
	public EstandarProduccion findEstandarProduccionByIdfindEstandarProduccionByUnique(Formato formato1, Formato formato2, Color fondo, Film film, Integer impreso);

}
