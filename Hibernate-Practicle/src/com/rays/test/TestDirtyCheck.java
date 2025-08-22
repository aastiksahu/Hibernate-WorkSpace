package com.rays.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.auction.AuctionItem;

public class TestDirtyCheck {
	
	public static void main(String[] args) {
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		AuctionItem aucItem = (AuctionItem) session.get(AuctionItem.class, 1002);
		
		aucItem.setDescription("VikramSolar IPO");
		
		tx.commit();
		
		session.close();
		
		
	}

}
