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
				
		Transaction transaction =  session.beginTransaction();
		
		StudentGroupDetails906 studentGroupDetails906 = session.get(StudentGroupDetails906.class, 1);
		
		
		System.out.println("==> " + studentGroupDetails906.getStudentGroup906().getUserName() + " - " + studentGroupDetails906.getStudentGroup906().getPassword());
		
	
		
		/*Email email1 = new Email();
		email1.setEmail("email1");
		email1.setStudentGroup906(studentGroup906);
		
		Email email2 = new Email();
		email2.setEmail("email2");
		email2.setStudentGroup906(studentGroup906);
		
		Email email3 = new Email();
		email3.setEmail("email3");
		email3.setStudentGroup906(studentGroup906);
		
		session.save(studentGroup906);
		session.save(email1);
		session.save(email2);
		session.save(email3);*/
		
		
		
		
		transaction.commit();
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





/*System.out.println("==> " + studentGroupDetails906.getId() + " - " + studentGroupDetails906.getAddress());

System.out.println("==> " + studentGroupDetails906.getStudentGroup906().getUserName() + " - " + studentGroupDetails906.getStudentGroup906().getPassword());
*/
//session.merge(studentGroupDetails906);

// * student  
//StudentGroup906 studentGroup906 = new StudentGroup906("eslam", 123);

// * student details + student
/*StudentGroupDetails906 studentGroupDetails906 = 
		new StudentGroupDetails906(15,"alex");

studentGroupDetails906.setStudentGroup906(studentGroup906);

//session.save(studentGroup906);

//session.save(studentGroupDetails906);

session.persist(studentGroupDetails906);*/

/*
 * 
 * StudentGroupDetails906 studentGroupDetails906 = session.get(StudentGroupDetails906.class, 3);
		
		System.out.println("==> " + studentGroupDetails906.getId() + " - " + studentGroupDetails906.getAddress());
		
		System.out.println("==> " + studentGroupDetails906.getStudentGroup906().getUserName() + " - " + studentGroupDetails906.getStudentGroup906().getPassword());
		
		studentGroupDetails906.setAddress("updated Address7");
		
		studentGroupDetails906.getStudentGroup906().setUserName("updated username7");
		
		session.detach(studentGroupDetails906);
		*/
