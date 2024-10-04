package hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//@Entity(name= "Student_details")
//@Table(name = "Student_details")
@Entity
public class Student {
	
	@Id
	//@Column(name = "id_test")
	private int id;
	@Column(name = "name_test")
	private String name;
	//@Column(name = "password_test", nullable = false)
    private int password;
	//@Column(name = "address_test")
    private String address;
	//@Column(name = "age_test")
    private int age;
    public Student() {
    	
    }
    
	public Student(int id, String name, int password, String address, int age) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.address = address;
		this.age = age;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
    
    
    
}
