import java.util.List;

import junit.framework.TestCase;

public class CurrentAccountTest extends TestCase {

	public void testAddCustomer() {

		Customer cust = new Customer(1, "Prerana", "Saint Paul MN", 5555);
		CurrentAccount account = new CurrentAccount();
		account.addCustomer(cust);
		List<Customer> customer = account.getCustomer();
		assertEquals(1, customer.size());
		for (Customer cu : customer) {
			assertEquals("Customer not present", "Prerana", cu.getName());
		}

	}

	public void testRemoveCustomer() {

		Customer cust = new Customer(1, "Prerana", "Saint Paul MN", 5555);
		Customer cust1 = new Customer(1, "Prerana1", "Saint Paul MN", 5555);
		CurrentAccount account = new CurrentAccount();
		account.addCustomer(cust);
		account.addCustomer(cust1);
		List<Customer> customer = account.getCustomer();
		assertEquals(2, customer.size());
		account.removeCustomer("Prerana");
		assertEquals(1, customer.size());

	}

	public void testDuplicateCustomerName() {

		Customer cust = new Customer(1, "Prerana", "Saint Paul MN", 5555);
		Customer cust1 = new Customer(1, "Prerana", "Saint Paul MN", 5555);
		CurrentAccount account = new CurrentAccount();
		account.addCustomer(cust);
		account.addCustomer(cust1);
		List<Customer> customer = account.getCustomer();
		assertEquals(1, customer.size());

	}

}
