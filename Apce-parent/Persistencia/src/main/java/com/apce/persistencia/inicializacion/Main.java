package com.apce.persistencia.inicializacion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.apce.modelo.Color;
import com.apce.modelo.Material;
import com.apce.modelo.Produccion;
import com.apce.persistencia.interfaz.MaterialDAO;


public class Main {
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Inicializo Spring y sus servicios
		//new InicializarSpring();
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/**/applicationContext-dao.xml");
//		CintaDAO cintaDao = (CintaDAO)ctx.getBean("cintaDAO");
//		SolicitudProduccionDAO spDao = (SolicitudProduccionDAO)ctx.getBean("solicitudProduccionDAO");
//		MaterialDAO mDao = (MaterialDAO)ctx.getBean("materialDAO");
//		MaterialDAO pDao = (MaterialDAO)ctx.getBean("produccionDAO");
		
//		Cinta cinta = new Cinta();
		List<Color> colores = new ArrayList<Color>();
		colores.add(Color.AZUL);
		colores.add(Color.ROJO);
//		cinta.setColores(colores);
//		cinta.setDescripcion("descripcion de una cinta");
//		cinta.setEmpaque(10L);
//		cinta.setFechaAlta(new Date());
//		cinta.setFormato1(Formato.F12MM);
//		cinta.setFormato2(Formato.F1000MTS);
//		cinta.setImpreso(10);
//		cinta.setNombre("Cinta de papel");
//		
//		cintaDao.saveOrUptade(cinta);
		
//		SolicitudProduccion sp = new SolicitudProduccion();
//		
//		sp.setColores(colores);
//		sp.setDescripcion("descripcion solicitud de produccion");
//		sp.setEmpaque(10L);
//		sp.setFechaAlta(new Date());
//		sp.setFormato1(Formato.F12MM);
//		sp.setFormato2(Formato.F1000MTS);
//		sp.setImpreso(10);
//		sp.setNombre("solicitud de produccion nombre");
//		spDao.saveOrUptade(sp);
		
//		Material material = new Material();
//		material.setCantidad(10);
//		material.setKilos(10);
//		material.setLitros(10);
//		
//		mDao.saveOrUptade(material);
		
		
		

	}

}
