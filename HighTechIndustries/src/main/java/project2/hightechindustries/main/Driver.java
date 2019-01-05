package project2.hightechindustries.main;

import project2.hightechindustries.util.HibernateUtil;

public class Driver {
	
	public static void main(String[] args) {
		
		System.out.println(HibernateUtil.getSessionFactory());
		
	}

}
