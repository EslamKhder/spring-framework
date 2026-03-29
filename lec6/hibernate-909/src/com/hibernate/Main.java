package com.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.model.CourseEraaSoft;
import com.hibernate.model.EmailEraaSoft;
import com.hibernate.model.StudentDetailsEraaSoft;
import com.hibernate.model.StudentEraaSoft;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration()
				.addAnnotatedClass(StudentEraaSoft.class)
				//.addAnnotatedClass(CourseEraaSoft.class)
				.addAnnotatedClass(StudentDetailsEraaSoft.class)
				//.addAnnotatedClass(EmailEraaSoft.class)
				.configure("hibernate.cfg.xml");
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		Transaction transaction = session.beginTransaction();
		
		//StudentDetailsEraaSoft studentDetailsEraaSoft = session.get(StudentDetailsEraaSoft.class, 2);
		
		//StudentEraaSoft studentEraaSoft = new StudentEraaSoft("ahmed", "123");

		StudentDetailsEraaSoft studentDetailsEraaSoft = session.get(StudentDetailsEraaSoft.class, 2);
		
	
		
		/*
		System.out.println("-------------------------");
		System.out.println(studentDetailsEraaSoft);
		System.out.println("-------------------------");
		studentDetailsEraaSoft.setAddress("tt133");
		studentDetailsEraaSoft.setPhoneNumber("ppppp");
		
		studentDetailsEraaSoft.getStudentEraaSoft().setPassword("p123");
		studentDetailsEraaSoft.getStudentEraaSoft().setUserName("us123");
		
		System.out.println("-------------------------");
		System.out.println(studentDetailsEraaSoft);
		System.out.println("-------------------------");
		session.detach(studentDetailsEraaSoft);
		
		
		session.refresh(studentDetailsEraaSoft);
		
		System.out.println("-------------------------");
		System.out.println(studentDetailsEraaSoft);
		System.out.println("-------------------------");
		*/
		transaction.commit();
		
		session.close();
		sessionFactory.close();
		
	}
	

}

/**
 * 
 * 
 * 
studentDetailsEraaSoft.setAddress("tt133");
		studentDetailsEraaSoft.getStudentEraaSoft().setPassword("tt1333");
		
		session.detach(studentDetailsEraaSoft);
		//session.detach(studentDetailsEraaSoft);
		//session.update(studentDetailsEraaSoft);
		//session.merge(studentDetailsEraaSoft);
		session.merge(studentDetailsEraaSoft);
  StudentEraaSoft studentEraaSoft = new StudentEraaSoft("ahmed", "123");
		
		EmailEraaSoft emailEraaSoft1 = new EmailEraaSoft("email1");
		EmailEraaSoft emailEraaSoft2 = new EmailEraaSoft("email2");
		
		
		List<EmailEraaSoft> emailEraaSofts = new ArrayList();
		emailEraaSofts.add(emailEraaSoft1);
		emailEraaSofts.add(emailEraaSoft2);
		studentEraaSoft.setEmailEraaSofts(emailEraaSofts);
 * 
 * StudentEraaSoft studentEraaSoft = new StudentEraaSoft("ahmed", "123");
		
		EmailEraaSoft emailEraaSoft1 = new EmailEraaSoft("email1");
		EmailEraaSoft emailEraaSoft2 = new EmailEraaSoft("email2");
		
		session.save(emailEraaSoft1);
		session.save(emailEraaSoft2);
		
		List<EmailEraaSoft> emailEraaSofts = new ArrayList<EmailEraaSoft>();
		emailEraaSofts.add(emailEraaSoft1);
		emailEraaSofts.add(emailEraaSoft2);
		
		studentEraaSoft.setEmailEraaSofts(emailEraaSofts);
		
		session.save(studentEraaSoft);
 */
/*
 * 
 * StudentEraaSoft studentEraaSoft = new StudentEraaSoft("ahmed", "123");

StudentDetailsEraaSoft studentDetailsEraaSoft = new StudentDetailsEraaSoft("alex", "011");
studentEraaSoft.setStudentDetailsEraaSoft(studentDetailsEraaSoft);
//studentDetailsEraaSoft.setStudentEraaSoft(studentEraaSoft);

// save studentDetailsEraaSoft(studentEraaSoft)
session.persist(studentEraaSoft);StudentEraaSoft studentEraaSoft = new StudentEraaSoft("ahmed", "123");

StudentDetailsEraaSoft studentDetailsEraaSoft = new StudentDetailsEraaSoft("alex", "011");
studentDetailsEraaSoft.setStudentEraaSoft(studentEraaSoft);

// save studentDetailsEraaSoft(studentEraaSoft)
session.persist(studentDetailsEraaSoft);*/
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
		
		
		/*emailEraaSoft1.setStudentEraaSoft(studentEraaSoft);
		emailEraaSoft2.setStudentEraaSoft(studentEraaSoft);
		*/
		
		//session.persist(studentEraaSoft);
		/*StudentEraaSoft studentEraaSoft = new StudentEraaSoft("ahmed", "123");
		
		EmailEraaSoft emailEraaSoft1 = new EmailEraaSoft("email1");
		EmailEraaSoft emailEraaSoft2 = new EmailEraaSoft("email2");
	
		
		emailEraaSoft1.setStudentEraaSoft(studentEraaSoft);
		emailEraaSoft2.setStudentEraaSoft(studentEraaSoft);
		
		session.persist(emailEraaSoft1);
		session.persist(emailEraaSoft2);*/
		
		


