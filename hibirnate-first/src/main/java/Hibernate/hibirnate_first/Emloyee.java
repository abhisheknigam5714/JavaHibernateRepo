package Hibernate.hibirnate_first;

import jakarta.persistence.Entity;

@Entity
public class Emloyee {
	

	private int id;
	private String name;
	private String address;
	private int salary;

	public Emloyee( int id,String name, String address, int salary) {
		super();
		this.id=id;
		this.name = name;
		this.address = address;
		this.salary = salary;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}


	@Override
	public String toString() {
		return "Emloyee [id=" + id + ", name=" + name + ", address=" + address + ", salary=" + salary + "]";
	}
	
}
