package java_hibernate.Hib_java;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Education {
	
	@Column(name="myrollno",unique = true,nullable = false)
	private int rollno;
	
	@Column(name="myClgName",length = 50)
	private String clgName;
	
	@Column(name="mypercentage")
	private double per;
	
	public Education() {
		
	}
	
	
	public Education(int rollno, String clgName, double per) {
		super();
		this.rollno = rollno;
		this.clgName = clgName;
		this.per = per;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getClgName() {
		return clgName;
	}
	public void setClgName(String clgName) {
		this.clgName = clgName;
	}
	public double getPer() {
		return per;
	}
	public void setPer(double per) {
		this.per = per;
	}
	
	
	

}
