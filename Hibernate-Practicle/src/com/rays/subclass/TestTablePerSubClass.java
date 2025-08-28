package com.rays.subclass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestTablePerSubClass {

	public static void main(String[] args) {

		CreditCardPayment ccp = new CreditCardPayment();

		ccp.setAmount(3000);
		ccp.setPaymentType("credit card");
		ccp.setCcType("Rupay");

		Cheque ch = new Cheque();

		ch.setAmount(8900);
		ch.setPaymentType("cheque");
		ch.setBankName("HDFC");
		ch.setChqNumber("000052");

		Cash c = new Cash();

		c.setAmount(50000);
		c.setPaymentType("cash");

		SessionFactory sf = new Configuration().configure().buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(ccp);

		session.save(ch);

		session.save(c);

		tx.commit();

		session.close();
	}

}
