package com.hibernate.main;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.model.Course906;
import com.hibernate.model.Email;
import com.hibernate.model.StudentGroup906;
import com.hibernate.model.StudentGroupDetails906;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration()
				.addAnnotatedClass(StudentGroup906.class)
				.addAnnotatedClass(StudentGroupDetails906.class)
				.addAnnotatedClass(Email.class)
				.addAnnotatedClass(Course906.class)
				.configure("hibernate.cfg.xml");
		
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
				
		//session.update(studentGroup906Res);
		//transaction.commit();
		session.close();
		sessionFactory.close();
		
	}

}

/*
 
		Transaction transaction = session.beginTransaction();
		
		StudentGroup906 studentGroup906Res = session.get(StudentGroup906.class, 2);
		
		studentGroup906Res.setName("updated name 12345");

 * StudentGroup906 studentGroup906 = new StudentGroup906("ahmed", 22, "alex");
session.save(studentGroup906);*/

/*StudentGroup906 studentGroup906Res = session.get(StudentGroup906.class, 1);

System.out.println("---->" + studentGroup906Res.toString());

studentGroup906Res.setName("test_update");
session.update(studentGroup906Res);

System.out.println("---->" + studentGroup906Res.toString());*/

/*StudentGroup906 studentGroup906Res = session.get(StudentGroup906.class, 1);
session.delete(studentGroup906Res);*/
