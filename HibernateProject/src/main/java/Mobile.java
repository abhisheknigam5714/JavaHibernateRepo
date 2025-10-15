import javax.persistence.Entity;

@Entity
public class Mobile {
	
	private int id;
	private String mobile_Name;
	private int price;
	
	public Mobile() {
		
	}
	
	public Mobile(int id, String mobile_Name, int price) {
		super();
		this.id = id;
		this.mobile_Name = mobile_Name;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMobile_Name() {
		return mobile_Name;
	}
	public void setMobile_Name(String mobile_Name) {
		this.mobile_Name = mobile_Name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	

}
