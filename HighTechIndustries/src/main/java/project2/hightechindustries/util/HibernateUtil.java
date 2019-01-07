package project2.hightechindustries.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	private static final String filename = "connection.project2.properties";
	/**
	 *@Author(name="Eddy, SBG")
	 *the getSessionFactory method will check if there exists a current SessionFactory
	 *if there is not then a ClassLoader will be generated, it will read
	 *connection.project2.properties and generate properties from that file
	 *then the hibernate configuration file will be updated to include
	 *the new properties, from those properties a new SessionFactory will be built
	 *the only exception that will be throw will be an IOException
	 *
	 * 
	 **/
	public static SessionFactory getSessionFactory() {
		
		if (HibernateUtil.sessionFactory == null) {
			Properties props = new Properties();
			ClassLoader cl = Thread.currentThread().getContextClassLoader();
			try (InputStream in = cl.getResourceAsStream(HibernateUtil.filename)) {
				props.load(in);
				Configuration config = new Configuration();
				config.configure("hibernate.cfg.xml");
				config.addProperties(props);
				HibernateUtil.sessionFactory = config.buildSessionFactory();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return HibernateUtil.sessionFactory;
	}
}
