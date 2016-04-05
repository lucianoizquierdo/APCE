package com.apce.persistencia.inicializacion;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class InicializarSpring {
	
	public InicializarSpring() {
		// TODO Auto-generated constructor stub
		//Inicializo el contexto buscando en todo el classpath
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/**/applicationContext-dao.xml");
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/**/applicationContext-transaction.xml");
//		System.out.println("ctx: " + ctx.getBean("PruebaHolaDAO"));
//		System.out.println("ctx: " + ctx.getBean("materiaPrimaDAO"));
		System.out.println("ctx: " + ctx.getBean("cintaDAO"));
		//System.out.println("ctx: " + ctx.getBean("PruebaHolaDAO"));
		//System.out.println("ctx: " + ctx.getBean("propertyConfigurer"));
		//PropertyPlaceholderConfigurer a1 = (PropertyPlaceholderConfigurer) ctx.getBean("propertyConfigurer");
		//PropertyPlaceholderConfigurer a1 = (PropertyPlaceholderConfigurer) ctx.getBean("propertyConfigurerHibernate");
//		CreateUser user = (CreateUser) ctx.getBean("createUser");
//		user.displayUser();
		
//		UsuarioDAO u = (UsuarioDAOImpl)ctx.getBean("usuarioDAO");
//		u.existeUser("luckyzener", 1);
//		
		
		
//		String url = "jdbc:postgresql://localhost/apce_desa";
//		Properties props = new Properties();
//		props.setProperty("user","postgres");
//		props.setProperty("password","Strato21");
//		//props.setProperty("ssl","true");
//		try {
//			Connection conn = DriverManager.getConnection(url, props);
//
//			// Get a statement from the connection
//		      Statement stmt = conn.createStatement() ;
//
//		      // Execute the query
//		      ResultSet rs = stmt.executeQuery( "SELECT * FROM usuarios" ) ;
//
//		      // Loop through the result set
//		      while( rs.next() )
//		         System.out.println( rs.getString(2) ) ;
//
//		      // Close the result set, statement and the connection
//		      rs.close() ;
//		      stmt.close() ;
//		      conn.close() ;
//			
//			
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//

		
		
		
	}

}

