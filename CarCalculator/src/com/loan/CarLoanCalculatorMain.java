package com.loan;

import javax.swing.JFrame;

//import swing.LanguagesUI;

public class CarLoanCalculatorMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//CreditScoreConstants constant = CreditScoreConstants.SUPERPRIME;
		//System.out.println(constant.getKey());
		//System.out.println(constant.getValue());
		
		JFrame frame = new SwingControlDemo();
       frame.setTitle("Car Payment Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
		
		/*CarLoanConstants cc =new CarLoanConstants();
		cc.setCarPrice(20000);
		cc.setTradeInValue(4000);
		cc.setInterestRate(4.5);
		//cc.setMonthlyPayment(444.44);
		cc.setNumberOfMonths(36);
	CarLoanCalculator c = new CarLoanCalculator();
	c.calculateMonthlyPayment(cc);
	//c.calculateTotalAmountPaid();
	//c.calculateTotalInterestPaid();
	//c.calculateNumberOfMonths(cc);
	//c.calculateCarPrice(cc);
	//c.createAmortizationTable(cc);
	//c.calculateInterestRate(cc);
	c.buildModel(37);*/
	}

}
