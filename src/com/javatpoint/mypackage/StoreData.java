package com.javatpoint.mypackage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class StoreData {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Configuration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		UserDbo user = new UserDbo();
		user.setEmail("ma@gmail.com");
		user.setPassword("hh");
		user.setAdmin(true);
		session.persist(user);
		session.flush();
		System.out.println("hhh");
		t.commit();
		session.close();

		System.out.println("successfully saved");

	}
}
