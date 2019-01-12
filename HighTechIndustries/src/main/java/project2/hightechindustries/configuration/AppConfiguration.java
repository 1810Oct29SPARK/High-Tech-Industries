package project2.hightechindustries.configuration;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import static org.hibernate.cfg.Environment.*;

@Configuration
@PropertySource("connection.project2.properties")
@EnableTransactionManagement
@ComponentScans(value = {
		@ComponentScan("project2.hightechindustries.dao"),
		@ComponentScan("project2.hightechindustries.service")
})
public class AppConfiguration {
	
	@Autowired
	static Environment env;
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		Properties props = new Properties();
		
		/**
		 * @author (name=Sean)
		 * This part here will be different for us, because we are using a different type of DB connection method
		 * 
		 */
		//setting up JDBC Properties
		props.put(URL, env.getProperty("hibernate.connection.url"));
		props.put(USER, env.getProperty("hibernate.connection.username"));
		props.put(PASS, env.getProperty("hibernate.connection.password"));
		
		//setting up Hibernate Properties
		
		
		
		//setting up C3P0 Properties
		
		
		
		factoryBean.setHibernateProperties(props);
		factoryBean.setPackagesToScan("project2.hightechindustries.beans");
		
		return factoryBean;
	}
	
	

}
