import java.util.List;

public class Bank {

	private String bankName;
	private String bankAddress;
	private CurrentAccount currentAccount;
	private SavingsAccount savingsAccount;
	Customer currentAccountCustomer[];
	Customer savingAccountCustomer[];

	public Bank() {
		currentAccount = new CurrentAccount();
		savingsAccount = new SavingsAccount();
		currentAccountCustomer = new Customer[11];
		savingAccountCustomer = new Customer[9];
		
		currentAccountCustomer[0] = new Customer(1, "Waylon Dalton", "351 Surrey Circle Brooklyn NY 11209", 1356);
		currentAccountCustomer[1] = new Customer(2, "Justine Henders", "9859 Glen Eagles Ave , NY 11237", 156);
		currentAccountCustomer[2] = new Customer(3, "Abdullah Lang", "9927 Woodside Lane NY 11213", 1156);
		currentAccountCustomer[3] = new Customer(4, "Thalia Cobbing", "233 NE. Summer St. NY 11235", 2016);
		currentAccountCustomer[4] = new Customer(5, "Mathias Little", "87 Deerfield Ave. S. Valley NY 10977", 3599);
		currentAccountCustomer[5] = new Customer(6, "Eddie Randolph", "18 East Howard Rd. NY 10977 ", 7146);
		currentAccountCustomer[6] = new Customer(7, "Angela Walker", "9768 Fieldstone Rd. Bronx, NY 10456", 156);
		currentAccountCustomer[7] = new Customer(8, "Lia Shelton", "226 High Noon Ave. Bronx, NY 10463", 31356);
		currentAccountCustomer[8] = new Customer(9, "Hadassah Hartman", "642 Windfall Drive New York NY 11370", 21256);
		currentAccountCustomer[9] = new Customer(10, "Joanna Shaffer", "99 Heritage St. New York, NY 10040", 16);
		currentAccountCustomer[10] = new Customer(11, "Jonathon Sheppard", "7 Cactus Ave. New York, NY 12550", 56);
		
		
		savingAccountCustomer[0]= new Customer(1, "Waylon Dalton", "351 Surrey Circle Brooklyn NY 11209", 599);
		savingAccountCustomer[1]= new Customer(2, "Justine Henders", "9859 Glen Eagles Ave , NY 11237", 3599);
		savingAccountCustomer[2]= new Customer(4, "Marcus Cruzing", "371 Depot Lane Brooklyn NY 11212", 99);
		savingAccountCustomer[3]= new Customer(5, "Thalia Cobbing", "233 NE. Summer St. NY 11235", 35099);
		savingAccountCustomer[4]= new Customer(7, "Eddie Randolph", "18 East Howard Rd. NY 10977 ", 9449);
		savingAccountCustomer[5]= new Customer(8, "Angela Walker", "9768 Fieldstone Rd. Bronx, NY 10456", 3599);
		savingAccountCustomer[6]= new Customer(9, "Lia Shelton", "226 High Noon Ave. Bronx, NY 10463", 353399);
		savingAccountCustomer[7]= new Customer(10, "Hadassah Hartman", "642 Windfall Drive New York NY 11370", 359922);
		savingAccountCustomer[8]= new Customer(12, "Jonathon Sheppard", "7 Cactus Ave. New York, NY 12550", 99);
	}

	public void addAccount() {
		for(int i=0;i<currentAccountCustomer.length;i++){
			currentAccount.addCustomer(currentAccountCustomer[i]);
		}
		for(int i=0;i<savingAccountCustomer.length;i++){
			savingsAccount.addCustomer(savingAccountCustomer[i]);
		}

	}

	public void removeAccount(String custName) {
		currentAccount.removeCustomer(custName);
		savingsAccount.removeCustomer(custName);
	}

	public void getAccount() {
		currentAccount.printReports();
		savingsAccount.printReports();
	}

}
