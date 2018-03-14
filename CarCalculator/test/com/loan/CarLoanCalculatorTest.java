package com.loan;

import junit.framework.Assert;
import junit.framework.TestCase;

public class CarLoanCalculatorTest extends TestCase {

	private CarLoanConstants carLoanConstant ;
	private CarLoanCalculator carLoanCalculator;

	@Override
	protected void setUp(){

		carLoanConstant = new CarLoanConstants();
		carLoanCalculator = new CarLoanCalculator(carLoanConstant);
	}


	public void testCalculateInterestRate() throws CarLoanException{

		carLoanConstant.setCarPrice(20000);
		carLoanConstant.setTradeInValue(4000);
		//cc.setInterestRate(5);
		carLoanConstant.setMonthlyPayment(475.98);
		carLoanConstant.setNumberOfMonths(36);

		carLoanCalculator.calculateMonthlyPayment();

		Assert.assertEquals(4.5, carLoanConstant.getInterestRate());
	}

	public void testCalculateMonthlyPaymenet(){

		final CarLoanConstants cc = new CarLoanConstants();
		cc.setCarPrice(20000);
		cc.setTradeInValue(4000);
		cc.setInterestRate(4.5);
		//cc.setMonthlyPayment(444.44);
		cc.setNumberOfMonths(36);

		new CarLoanCalculator(cc);
		System.out.println();
	}
}
