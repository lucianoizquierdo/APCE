package prueba;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Calendar;

import com.apce.modelo.Sucursal;

public class Prueba {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException {
		// TODO Auto-generated method stub

//		Class cls = Class.forName(Sucursal.class.getName());
//		Object obj = cls.newInstance();
// 
//		//call the printIt method
//		Method method = cls.getDeclaredMethod("getGerenteGeneral", null);
//		Class<?> clazz = method.getReturnType();
//		 System.out.println(clazz);
		
	
		Calendar c = Calendar.getInstance();
		
		System.out.println(c.get(Calendar.YEAR));
		
	}

}
