package com.rays.oneone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestOneOne {
	
	public static void main(String[] args) {
		
			Address empAdress = new Address();
			
			empAdress.setId(2);
			empAdress.setStreet("LIG Square");
			empAdress.setCity("Indore");
			
			Employee e = new Employee();
			
			e.setId(2);
			e.setName("Chetan");
			e.setEmpAddress(empAdress);
			
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			
			Session session = sf.openSession();
			
			Transaction tx = session.beginTransaction();
			
			session.save(e);
			
			tx.commit();
			
			session.close();
	}

}
