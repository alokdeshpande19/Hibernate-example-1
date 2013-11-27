package com.javatpoint.mypackage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class StoreData {
	   public static void main(String[] args) {
		Configuration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		UserDbo user = new UserDbo();
		user.setEmail("ma@gmail.com");
		user.setPassword("hh");
		session.persist(user);
		session.flush();
		t.commit();
		session.close();
		System.out.println("successfully saved");

	}
}
