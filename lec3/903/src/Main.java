import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.Address;
import model.Job;
import model.Passport;
import model.Person;
import model.Player;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Configuration configuration = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Person.class)
				//.addAnnotatedClass(Job.class);
				//.addAnnotatedClass(Address.class);
				.addAnnotatedClass(Passport.class);
				//.addAnnotatedClass(Player.class);
		
		SessionFactory factory =  configuration.buildSessionFactory();
		Session session = factory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		
		// add delete    save delete commit
		// select
		// edit           update      commit
		// edit                       commit
		Person person = session.get(Person.class, 14); // 14
		session.detach(person);
		person.setAge(20);
		
		person.getPassport().setPassportNumber(789);
		/*Person person = new Person();
		person.setName("ahmed");*/
		//session.update(person);
		transaction.commit();
	}

}


/*person.setAge(60);

session.update(person);*/
/*Person person1 = new Person();
person1.setName("name_3");
person1.setAge(200);

session.save(person1);*/
//System.out.println(session.contains(person));
//System.out.println(session.contains(person1));

//transaction.commit();
/*Person person = session.get(Person.class, 7);

System.out.println("person name is : " + person.getName());

System.out.println("person PassportNumber is : " + person.getPassport().getPassportNumber());

person.setName("updated Name");
person.getPassport().setPassportNumber(483L);

System.out.println("person name is : " + person.getName());*/

/*System.out.println("person PassportNumber is : " + person.getPassport().getPassportNumber());


session.refresh(person);

System.out.println("person name is : " + person.getName());

System.out.println("person PassportNumber is : " + person.getPassport().getPassportNumber());

/*Person person = session.get(Person.class, 5);
session.remove(person);
/*Person person = session.get(Person.class, 3);

person.setName("updated_name");
person.getPassport().setPassportNumber(1597L);


session.persist(person);*/

//session.merge(person);

/*Person person = new Person();
person.setName("name_2");
person.setAge(20);

Passport passport = new Passport();
passport.setPassportNumber(123456L);
person.setPassport(passport);

session.persist(person);
transaction.commit();*/
