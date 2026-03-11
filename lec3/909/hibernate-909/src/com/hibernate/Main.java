package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.model.StudentEraaSoft;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration()
				.addAnnotatedClass(StudentEraaSoft.class)
				.configure("hibernate.cfg.xml");
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		Transaction transaction = session.beginTransaction();
		
		StudentEraaSoft eraaSoft1 = session.get(StudentEraaSoft.class, 1);
		session.save(eraaSoft1);
		
		
		transaction.commit();
		
		session.close();
		sessionFactory.close();
		
	}

}
/*
 
 * Transaction transaction = session.beginTransaction();
		
		StudentEraaSoft eraaSoft1 = session.get(StudentEraaSoft.class, 1);
		
		eraaSoft1.setUserName("updated username");
		
		session.delete(eraaSoft1);
		
		


Transaction transaction = session.beginTransaction();
		
		StudentEraaSoft eraaSoft1 = session.get(StudentEraaSoft.class, 1);
		
		System.out.println(eraaSoft1);
		
		eraaSoft1.setUserName("updated username");
		
		session.update(eraaSoft1);
		transaction.commit();

SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		Transaction transaction = session.beginTransaction();
		
		StudentEraaSoft eraaSoft1 = session.get(StudentEraaSoft.class, 1);
		session.save(eraaSoft1);
		
		
		transaction.commit();
 * */

