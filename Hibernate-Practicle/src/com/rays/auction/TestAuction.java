package com.rays.auction;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestAuction {
	
	public static void main(String[] args) {
		
		Bids bids = new Bids();
		bids.setId(4);
		bids.setAmount(15000);
		bids.setTimeStamp("aastik");
		
		Bids bids1 = new Bids();
		bids1.setId(5);
		bids1.setAmount(14790);
		bids1.setTimeStamp("chetan");
		
		Bids bids2 = new Bids();
		bids2.setId(6);
		bids2.setAmount(14888);
		bids2.setTimeStamp("akbar");
		
		Set allbid = new HashSet();
		allbid.add(bids);
		allbid.add(bids1);
		allbid.add(bids2);
		
		AuctionItem aucItem = new AuctionItem();
		aucItem.setId(1001);
		aucItem.setDescription("VikramSolar IPO");
		aucItem.setBids(allbid);
		
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.save(aucItem);
		
		tx.commit();
		
		session.close();
	}

}
