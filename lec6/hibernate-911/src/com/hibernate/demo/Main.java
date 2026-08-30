package com.hibernate.demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Order;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.model.Course;
import com.hibernate.demo.model.Orders;
import com.hibernate.demo.model.Student;
import com.hibernate.demo.model.Team;
import com.hibernate.demo.model.User;
import com.hibernate.demo.model.UserDetails;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration configuration = new Configuration()
				//.addAnnotatedClass(Team.class)
				.addAnnotatedClass(User.class)
				//.addAnnotatedClass(UserDetails.class)
				.addAnnotatedClass(Orders.class)
				//.addAnnotatedClass(Student.class)
				//.addAnnotatedClass(Course.class)
				.configure("hibernate.cfg.xml");
		
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		Transaction transaction = session.getTransaction();
		transaction.begin();
		
		User user = new User("ahmed", "123456");
		
		List<Orders> orders = new ArrayList();
		orders.add(new Orders("ORD-001", 150.0));
		orders.add(new Orders("ORD-002", 250.0));
		orders.add(new Orders("ORD-003", 350.0));
		orders.add(new Orders("ORD-004", 450.0));
		
		user.setOrders(orders);
		orders.stream().forEach(order -> order.setUser(user));
		
		session.persist(user);
		
		
		transaction.commit();
		
		session.close();
		factory.close();
		System.out.println("end program");
	}

}

/*
 * 
 * 
 * 
 * 
 * 
 * 
 * User user = new User("ahmed", "123456");
		
		List<Orders> orders = new ArrayList();
		orders.add(new Orders(1L, "ORD-001", 150.0));
		orders.add(new Orders(2L, "ORD-002", 250.0));
		orders.add(new Orders(3L, "ORD-003", 350.0));
		orders.add(new Orders(4L, "ORD-004", 450.0));
		
		session.save(user);
		
		orders.stream().forEach(order -> {
			order.setUser(user);
			session.save(order);
		});
		
		UserDetails userDetails = session.get(UserDetails.class, 2L);
		
		session.remove(userDetails);
 * userDetails.setAddress("test3");
		userDetails.setFirstName("test3");
		userDetails.setLastName("test3");
		
		userDetails.getUser().setUsername("test3");
		userDetails.getUser().setPassword("test3");
		
		session.detach(userDetails);
		session.merge(userDetails);
 * User user = new User("ahmed", "123456");
		UserDetails userDetails = new UserDetails("Ahmed", "Ali", "Cairo");
		
		userDetails.setUser(user);
		//userDetails.setUser(user);
		
		session.persist(userDetails);
 * User user = new User("ahmed", "123456");
		UserDetails userDetails = new UserDetails("Ahmed", "Ali", "Cairo");
		
		user.setUserDetails(userDetails);
		//userDetails.setUser(user);
		
		session.persist(user);
eam team = session.get(Team.class, 1L);
		session.detach(team);
		
		team.setPlayerCount(80);
		session.update(team);
		
 * Team team1 = new Team(1L, "Real Madrid", 25, true, "Florentino Perez");
		session.save(team1);
		
		// select
		Team team = session.get(Team.class, 1L);
		System.out.println("--> " + team);
		
		// update
		team.setPlayerCount(7);
		session.update(team);
		
		
		Team team = session.get(Team.class, 1L);
		session.delete(team);
		
			Team team1 = new Team("Real Madrid", 25, true, "Florentino Perez");
		Team team2 = new Team("Barcelona", 24, true, "Joan Laporta");
		Team team3 = new Team("Manchester City", 25, true, "Pep Guardiola");
		Team team4 = new Team("Liverpool", 23, true, "Arne Slot");
		Team team5 = new Team("Bayern Munich", 26, true, "Vincent Kompany");
		
		session.save(team1);
		session.save(team2);
		session.save(team3);
		session.save(team4);
		session.save(team5);
		
 * */
