package com.rays.user;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestUserDTO {
	
	public static void main(String[] args) {
		
		UserDTO dto = new UserDTO();
		
		dto.setId(1);
		dto.setFirstName("aastik");
		dto.setLastName("sahu");
		dto.setAddress("40/1 pandariba Ujjain");
		dto.setDob(new Date());
		dto.setLoginId("aastiksahu8@gmail.com");
		dto.setPassword("123");
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.save(dto);
		
		tx.commit();
		
		session.close();
	}

}
