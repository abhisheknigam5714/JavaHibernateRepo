package java_hibernate.Hib_java;

import jakarta.persistence.CheckConstraint;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@Column(name="id")
	private int id;
	@Column(name="name",length = 35)
	private String name;
	
	@Column(name="address",length = 60)
	private String add;
	
	@Column(name="salary" ,nullable = false)
	private double salary;
	
	@Embedded
	private Account accc;
	@Embedded
	private Education edu;
	
	
	public Employee() {
		
	}


	public Employee(int id, String name, String add, double salary, Account accc, Education edu) {
		super();
		this.id = id;
		this.name = name;
		this.add = add;
		this.salary = salary;
		this.accc = accc;
		this.edu = edu;
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


	public String getAdd() {
		return add;
	}


	public void setAdd(String add) {
		this.add = add;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	public Account getAccc() {
		return accc;
	}


	public void setAccc(Account accc) {
		this.accc = accc;
	}


	public Education getEdu() {
		return edu;
	}


	public void setEdu(Education edu) {
		this.edu = edu;
	}
	
	
	

	
	
	
	
	

}
