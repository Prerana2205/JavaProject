package com.loan;

public class LoanAmortization {
	
	double principle;
	double payment;
	double interestPaid;
	double principlePaid;
	double balance;
	
	public LoanAmortization(double principle,double payment,
			double interestPaid,double principlePaid,double balance){
		this.principle = principle;
		this.payment = payment;
		this.interestPaid = interestPaid;
		this.principlePaid = principlePaid;
		this.balance = balance;
	}
}
