import java.util.ArrayList;
import java.util.List;

public class BankApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Bank bank = new Bank();

		bank.addAccount();
		bank.getAccount();
		bank.removeAccount("Thalia Cobbing");
		bank.getAccount();

	}

}
