package hibernate;


import java.util.List;

import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			/*Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");*/
			
			Configuration configuration = new Configuration()
					.configure("hibernate.cfg.xml")
					.addAnnotatedClass(Student.class);
			
			SessionFactory factory = configuration.buildSessionFactory();
			
			//Student student = new Student(8, "osama_test_1", 345, "cairo", 35);
			
			Session session = factory.getCurrentSession();
			
			session.beginTransaction();
			Query q = session.createQuery("select sum(id) from Student");

			
			
			
			
			System.out.println(q.list().get(0));
			
			
			
			
			System.out.println("Done.... " + configuration);
			factory.close();
			///factory.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception " + e.getMessage());
		}
		
	}

}

/*
Connection connection = DriverManager.getConnection(
"jdbc:oracle:thin:@//localhost:1521/orclpdb", "hr", "hr"
);

System.out.println("Done.... " + connection);
session.save(student);


//session.saveOrUpdate("ddsdsdsds", student);
			//Student s = session.get(Student.class, 8);
			//Student student2 =  (Student) session.get("Student", 8);
			/*Student studentRes1  = session.get(Student.class, 8);
			studentRes1.setName("Test_11");
			session.update("tt", studentRes1);
			session.getTransaction().commit();*/
			/*Student studentRes  = session.get(Student.class, 1);
			
			session.delete(studentRes);
			*/
			/*Student studentRes1  = session.get(Student.class, 1);
			studentRes1.setName("name111");
			
			Student studentRes2  = session.get(Student.class, 2);
			studentRes2.setName("name222");
			studentRes2.setId(1);
			
			session.update(studentRes1);
			session.update(studentRes2);
			//session.save(student);
			 * // from Student where id = :getId
			/*q.setFirstResult(0);
			q.setMaxResults(3);
			if (stus.size() == 0) {
				System.out.println("empty");
			}
			for(Student s : stus) {
				System.out.println("ID: " + s.getId());
				System.out.println("Name: " + s.getName());
				System.out.println("Address: " + s.getAddress());
			}
			*
			*/
