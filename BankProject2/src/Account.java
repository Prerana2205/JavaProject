
public class Account implements BankReports {

	protected int acc_no;
	protected double balance=0.0;

	public void debitAmount(double amount){
		this.balance = this.balance - amount; 
	}

	public void creditAmount(double amount){
		this.balance = this.balance + amount;
	}

	public double getBalance(){
		return this.balance;
	}



	@Override
	public void printReports() {
		// TODO Auto-generated method stub
		
	}
}
