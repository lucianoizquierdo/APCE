package com.apce.servicios.inicializacion;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import com.apce.servicio.impl.PruebaHola;
import com.apce.servicio.servicoInterfaz.MateriaPrimaService;

public class InicializarSpring {
	

	
	public InicializarSpring() {
		// TODO Auto-generated constructor stub
		//Inicializo el contexto buscando en todo el classpath
		ApplicationContext  ctx = new ClassPathXmlApplicationContext("classpath*:applicationContext-service.xml");
		System.out.println("ctx: " + ctx);
//		Resource Resource = ctx.getResource("classpath*:applicationContext-service.xml");
//		System.out.println("R: "  + Resource);
//		System.out.println("loginService: " + ctx.getBean("loginService"));
//		
		
		@SuppressWarnings("unused")
		PruebaHola p = (PruebaHola)ctx.getBean("materiaPrimaServiceImpl2");
		@SuppressWarnings("unused")
		MateriaPrimaService s = (MateriaPrimaService)ctx.getBean("materiaPrimaServiceImpl");
		System.out.println("tolo");
	}

	
}
