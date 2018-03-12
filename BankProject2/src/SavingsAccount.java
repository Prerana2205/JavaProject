/*Program to add/ remove savings account customers from the bank*/
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SavingsAccount extends Account {

	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}

	private double min_balance;
	private Date date_of_opening;
	private List<Customer> customer;

	public SavingsAccount() {
		customer = new ArrayList();
	}

	public void addCustomer(Customer cust) {
		boolean alreadyExists = false;
		for (Customer cus : customer) {
			if (cus.getName().equalsIgnoreCase(cust.getName())) {
				System.out.println("Customer already has Savings Account");
				alreadyExists = true;
				break;
			}
		}
		if (!alreadyExists) {
			customer.add(cust);
		}

	}

	public void removeCustomer(String custName) {
		for (Customer cus : customer) {
			if (cus.getName().equalsIgnoreCase(custName)) {
				customer.remove(cus);
				break;
			}
		}

	}

	@Override
	public void printReports() {
		System.out.println("");
		System.out.println("Printing all Savings Accounts");
		System.out.println(String.format("%1s %15s %1s %35s %1s","Name","|","Address","|","Balance"));
		for (Customer customer : customer) {
			System.out.println(String.format("%1s %7s %1s %10s %1.2f",customer.getName() ,"|", 
					customer.getAddress() ,"|",customer.getAmount()));
		}

	}

}
