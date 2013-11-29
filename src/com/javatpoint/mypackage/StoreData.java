package com.javatpoint.mypackage;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StoreData {
	   static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hsqldb-ds");
	   public static void main(String[] args) {
		  //for inserting the data
		   EntityManager entityManager = emf.createEntityManager();
		   entityManager.getTransaction().begin();
		   UserDbo user=new UserDbo();
		   user.setEmail("madhukar@easility.com");
		   user.setPassword("easility");
		   entityManager.persist(user);
		   UserDbo user1=new UserDbo();
		   user1.setEmail("madhukarpandey007@gmail.com");
		   user1.setPassword("easility123");
		   entityManager.persist(user1);
		   
		   entityManager.flush();
		   entityManager.flush();
		   
		   entityManager.getTransaction().commit();
		   entityManager.close();
	     
		   // for fetching the data 	   
		   entityManager = emf.createEntityManager();
		   entityManager.getTransaction().begin();
		   List<UserDbo> result = entityManager.createQuery( "from UserDbo", UserDbo.class ).getResultList();
		   for ( UserDbo userDbo : result ) {
		       System.out.println( "UserId=" + userDbo.getId());
		       System.out.println( "User EmailId=" + userDbo.getEmail());
		       System.out.println( "User Password=" + userDbo.getPassword());
		   }
		   entityManager.getTransaction().commit();
		   entityManager.close();
	   }
}
