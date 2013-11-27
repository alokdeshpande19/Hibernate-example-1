package com.javatpoint.mypackage;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class StoreData {
	 private static SessionFactory factory; 
	   public static void main(String[] args) {
		Configuration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		 factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		UserDbo user = new UserDbo();
		user.setEmail("madhukar@easility.com");
		user.setPassword("hibernate");
		session.persist(user);
		session.flush();
		t.commit();
		session.close();
		System.out.println("successfully saved");
		StoreData s=new StoreData();
		s.listUsers();
	}
	   public void listUsers(){
		      Session session = factory.openSession();
		      Transaction tx = null;
		      try{
		         tx = session.beginTransaction();
		         List users = session.createQuery("FROM UserDbo").list(); 
		         for (Iterator iterator = 	 users.iterator(); iterator.hasNext();){
		            UserDbo user = (UserDbo) iterator.next(); 
		            System.out.println("emailId: " + user.getEmail()); 
		            System.out.println("  id: " + user.getId()); 
		            System.out.println("  password: " + user.getPassword()); 
		         }
		         tx.commit();
		      }catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      }finally {
		         session.close(); 
		      }
		   }
}
