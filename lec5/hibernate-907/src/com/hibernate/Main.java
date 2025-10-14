package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.model.Student_907;

public class Main {

	public static void main(String[] args) {
		Configuration configuration = new Configuration()
				.addAnnotatedClass(Student_907.class)
				.configure("hibernate.cfg.xml");
		
		SessionFactory factory = configuration.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		

		Transaction transaction = session.beginTransaction();
		
		Student_907 s1 = new Student_907("ahmed123", "pass123", 22, "Cairo");
		Student_907 s2 = new Student_907("sara_ali", "sara@456", 24, "Alexandria");
		Student_907 s3 = new Student_907("mohamed_h", "mh2025", 21, "Giza");
		Student_907 s4 = new Student_907("fatma99", "ftmPass", 23, "Mansoura");
		Student_907 s5 = new Student_907("karim_dev", "kdev!78", 25, "Tanta");
		
		session.save(s1);
		session.save(s2);
		session.save(s3);
		session.save(s4);
		session.save(s5);
		transaction.commit();
		
		session.close();
		factory.close();
		

	}

}


/*Student_907 s1 = new Student_907(1L, "ahmed123", "pass123", 22, "Cairo");
Student_907 s2 = new Student_907(2L, "sara_ali", "sara@456", 24, "Alexandria");
Student_907 s3 = new Student_907(1L, "mohamed_h", "mh2025", 21, "Giza");
Student_907 s4 = new Student_907(4L, "fatma99", "ftmPass", 23, "Mansoura");
Student_907 s5 = new Student_907(5L, "karim_dev", "kdev!78", 25, "Tanta");

session.save(s1);
session.save(s2);
session.save(s3);
session.save(s4);
session.save(s5);
System.out.println("--------------------");
		System.out.println(student_907.toString());
		
		
		student_907.setUserName("updated user name");
		
		session.update(student_907);
*
*
*/
