
/*-------------------------------------------------------------------------------------------------
 * Prerana Sawant
 * SEIS 602-01
 * Exam1
 * Bank Application: Two types of accounts: Current/Savings. Adds/removes customer accounts.  
 -------------------------------------------------------------------------------------------------*/
import java.util.ArrayList;

public class BankApplication {

	public static void main(String[] args) {

		Bank bank = new Bank();

		bank.addAccount();
		bank.getAccount();
		bank.removeAccount("Thalia Cobbing");
		System.out.println("\nAfter removing customer \"Thalia Cobbing\" ");
		bank.getAccount();

	}

}
