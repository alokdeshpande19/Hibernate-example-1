package com.javatpoint.mypackage;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.FlushMode;
import org.hibernate.Session;

public class StoreData {
	static EntityManagerFactory emf;

	public static void main(String[] args) {
		try {
			Class.forName("net.sf.log4jdbc.DriverSpy");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		emf = Persistence.createEntityManagerFactory("hsqldb-ds");
		// for inserting the data
		EntityManager entityManager = emf.createEntityManager();
		Session session = (Session) entityManager.getDelegate();  
	    session.setFlushMode(FlushMode.MANUAL);
	    
		entityManager.getTransaction().begin();
		// entityManager.setFlushMode(FlushModeType.MANUAL);

		UserDbo user = new UserDbo();
		user.setEmail("madhukar@easility.com");
		user.setPassword("easility");

		CompanyDbo companyDbo = new CompanyDbo();

		user.setCompany(companyDbo);
		companyDbo.addUser(user);

		entityManager.persist(companyDbo);
		entityManager.persist(user);
		entityManager.flush();

//		UserDbo user1 = new UserDbo();
//		user1.setEmail("madhukarpandey007@gmail.com");
//		user1.setPassword("easility123");
//		entityManager.persist(user1);

		entityManager.flush();
		entityManager.flush();
		
		entityManager.getTransaction().commit();
		entityManager.close();

		// for fetching the data
		entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		List<UserDbo> result = entityManager.createQuery("from UserDbo",
				UserDbo.class).getResultList();
		for (UserDbo userDbo : result) {
			System.out.println("UserId=" + userDbo.getId());
			System.out.println("User EmailId=" + userDbo.getEmail());
			System.out.println("User Password=" + userDbo.getPassword());
		}
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
