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
	private List<Customer> customer ;

	/*
	 * public void addCustomer() { customer.add(new Customer(1, "Waylon Dalton",
	 * "351 Surrey Circle Brooklyn NY 11209", 599)); customer.add(new
	 * Customer(2, "Justine Henders", "9859 Glen Eagles Ave , NY 11237", 3599));
	 * customer.add(new Customer(4, "Marcus Cruzing",
	 * "371 Depot Lane Brooklyn NY 11212", 99)); customer.add(new Customer(5,
	 * "Thalia Cobbing", "233 NE. Summer St. NY 11235", 35099));
	 * customer.add(new Customer(7, "Eddie Randolph",
	 * "18 East Howard Rd. NY 10977 ", 9449)); customer.add(new Customer(8,
	 * "Angela Walker", "9768 Fieldstone Rd. Bronx, NY 10456", 3599));
	 * customer.add(new Customer(9, "Lia Shelton",
	 * "226 High Noon Ave. Bronx, NY 10463", 353399)); customer.add(new
	 * Customer(10, "Hadassah Hartman", "642 Windfall Drive New York NY 11370",
	 * 359922)); customer.add(new Customer(12, "Jonathon Sheppard",
	 * "7 Cactus Ave. New York, NY 12550", 99));
	 * 
	 * }
	 */
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
		System.out.println("Printing all Savings Account");
		for (Customer customer : customer) {
			System.out.println("Name: " + customer.getName() + " Address" + customer.getAddress() + " Balance "
					+ customer.getAmount());
		}

	}

}
