package hibernate.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Person  extends BaseEntity {

	private String name;
	
	private int age;


	
	@OneToOne(fetch = FetchType.LAZY)
	private Passport passport;
	
	/*@ManyToMany
	@JoinTable(
			name = "Person_relation_jobs",
			joinColumns = @JoinColumn(),
			inverseJoinColumns = @JoinColumn()
	)
	private List<Job> jobs;*/
	
	/*@OneToMany
	private List<Address> addresses;*/
	
	/*@OneToOne
	private Passport passport;*/
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	
	
}
