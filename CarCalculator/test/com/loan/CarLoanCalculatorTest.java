package com.loan;

import org.junit.Assert;

import junit.framework.TestCase;

public class CarLoanCalculatorTest extends TestCase {

	private CarLoanConstants carLoanConstant;
	private CarLoanCalculator carLoanCalculator;

	public void testCalculateCarPrice() {

		doTest(0.0, 4000, 4.5, 475.95, 36);
		Assert.assertNotNull(carLoanConstant.getCarPrice());
		carLoanCalculator.calculateCarPrice();

		// approximate 50 cents difference
		Assert.assertEquals(20000, carLoanConstant.getCarPrice(), 0.5);

	}

	public void testCalculateInterestRate() {
		doTest(20000, 4000, 0, 475.95, 36);

		carLoanCalculator.calculateInterestRate();
		Assert.assertNotNull(carLoanConstant.getInterestRate());
		Assert.assertEquals(4.5, carLoanConstant.getInterestRate(), 0.3);
	}

	public void testCalculateMonthlyPayment() {
		doTest(20000, 4000, 4.5, 0, 36);

		carLoanCalculator.calculateMonthlyPayment();
		Assert.assertNotNull(carLoanConstant.getMonthlyPayment());
		System.out.println(carLoanConstant.getMonthlyPayment());
		Assert.assertEquals(475.95, carLoanConstant.getMonthlyPayment(), 0.3);

	}

	public void testCalculateRegex() {
		String regex = "\\d+";
		String value1 = "10.222";
		String value3 = "10.21";
		System.out.println(value1.matches(regex));
		System.out.println(value3.matches(regex));
		System.out.println("11".matches(regex));
		System.out.println("11.1".matches(regex));
		System.out.println("ab".matches(regex));
		System.out.println("-11".matches(regex));

	}

	public void testCalculateNumberOfMonths() {
		doTest(20000, 4000, 4.5, 475.95, 0);

		carLoanCalculator.calculateNumberOfMonths();
		Assert.assertNotNull(carLoanConstant.getNumberOfMonths());
	}

	public void doTest(double carPrice, double tradeInValue, double interestRate, double monthlyPayment,
			int numberOfMonths) {

		// create new object
		carLoanConstant = new CarLoanConstants();

		carLoanConstant.setCarPrice(carPrice);
		carLoanConstant.setTradeInValue(tradeInValue);
		carLoanConstant.setInterestRate(interestRate);
		carLoanConstant.setMonthlyPayment(monthlyPayment);
		carLoanConstant.setNumberOfMonths(numberOfMonths);
		carLoanCalculator = new CarLoanCalculator(carLoanConstant);
	}

}
