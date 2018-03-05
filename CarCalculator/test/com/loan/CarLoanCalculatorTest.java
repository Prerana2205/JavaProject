package com.loan;

import junit.framework.TestCase;

public class CarLoanCalculatorTest extends TestCase {
	
	public void testCalculateMonthlyPaymenet(){
		
		CarLoanConstants carLoanConstant = new CarLoanConstants();
		carLoanConstant.setCarPrice(20000);
		carLoanConstant.setInterestRate(2.0);
		carLoanConstant.setNumberOfMonths(10);
		
		CarLoanCalculator calculator = new CarLoanCalculator();
		System.out.println(calculator.calculateMonthlyPayment(carLoanConstant));
	}

}
