package com.rays.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rays.auction.AuctionItem;

public class TestDetachToPersistance {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		AuctionItem aucItem = (AuctionItem) session.get(AuctionItem.class, 1002);

		session.close();

		aucItem.setDescription("VikramnSolar IPO");

		Session session2 = sf.openSession();

		Transaction tx = session2.beginTransaction();

		session2.update(aucItem);

		tx.commit();

		session2.close();

	}

}
