package project2.hightechindustries.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	private static final String filename = "connection.project2.properties";
	
	public static SessionFactory getSessionFactory() {
		
//		if (HibernateUtil.sessionFactory == null) {
//			//if no SessionFactory has been created, create one
//			Configuration c = new Configuration();
//			c.setProperty("hibernate.connection.username", System.getenv("BEARS_DB_USERNAME"));
//			c.setProperty("hibernate.connection.password", System.getenv("BEARS_DB_PASS"));
//			c.setProperty("hibernate.connection.url", System.getenv("BEARS_DB_URL"));
//			c.configure(); //by default, looks for hibernate.cfg.xml in srs/main/resources
//			HibernateUtil.sessionFactory = c.buildSessionFactory();
//		}
//		return HibernateUtil.sessionFactory;
		
		if (HibernateUtil.sessionFactory == null) {
			Properties props = new Properties();
			//this class will do some stuff.
			ClassLoader cl = Thread.currentThread().getContextClassLoader();
			//Eddy was talking about this java class being real good at grabbing inputs
			//ClassLoader is the input grabber
			//Thread where'd it come from?
			//The currentThread() returns an instance of the Thread class
			//getContextClassLoader() returns a ClassLoader
			try (InputStream in = cl.getResourceAsStream(HibernateUtil.filename)) {
				props.load(in);
				Configuration config = new Configuration();
				//The hell this one do?
				config.configure("hibernate.cfg.xml");
				config.addProperties(props);
				HibernateUtil.sessionFactory = config.buildSessionFactory();
			} catch (IOException e) {
				e.printStackTrace();
				//this'll be the only exception for the try w/ resources
			}
		}
		
		return HibernateUtil.sessionFactory;
		
	}
}
