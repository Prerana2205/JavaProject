/*Program to add/ remove current account customers from the bank*/
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CurrentAccount extends Account {

	private double interest_Rate;

	private Date date_of_opening;

	private List<Customer> customer;

	public CurrentAccount() {
		customer = new ArrayList();
	}

	public void addCustomer(Customer cust) {
		boolean alreadyExists = false;
		for (Customer cus : customer) {
			if (cus.getName().equalsIgnoreCase(cust.getName())) {
				System.out.println("Customer already has Current Account");
				alreadyExists = true;
				break;
			}
		}
		if (!alreadyExists) {
			customer.add(cust);
		}

	}

	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}

	public void removeCustomer(String name) {
		for (Customer cus : customer) {
			if (cus.getName().equalsIgnoreCase(name)) {
				customer.remove(cus);
				break;
			}
		}
	}

	@Override
	public void printReports() {
		System.out.println();
		System.out.println("Printing all Current Accounts");
		System.out.println(String.format("%1s %15s %1s %35s %1s","Name","|","Address","|","Balance"));
		for (Customer customer : customer) {
			System.out.println(String.format("%1s %7s %1s %10s %1.2f",customer.getName() ,"|" , 
					customer.getAddress() ,"|",  customer.getAmount()));
		}

	}
}
