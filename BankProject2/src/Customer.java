
public class Customer {

	private int cust_id;
	private String name;
	private String address;
	private int phone;
	private double amount;
	
	public Customer(int cust_id,String name,String address,double amount){
		this.cust_id =cust_id;
		this.name = name;
		this.address = address;
		this.amount = amount;
		
	}

	
	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
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

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	public String toString(){
		return "Name "+ this.name + "\nAddress" +this.address;
		
		
	}

}
