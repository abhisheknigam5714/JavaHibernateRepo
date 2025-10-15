package java_hibernate.Hib_java;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Account {
	
	@Column(name="myacc_no" ,nullable=false,unique = true)
	private int accNo;
	
	@Column(name="mybankName", nullable=false)
	private String bankName;
	
	@Column(name="myamount" )
	private double amount;
	
	
	public Account() {
		
	}
	
	
	public Account(int accNo, String bankName, double amount) {
		super();
		this.accNo = accNo;
		this.bankName = bankName;
		this.amount = amount;
	}
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	
	
	
}
