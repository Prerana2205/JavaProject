package com.loan;




import java.math.BigDecimal;

import org.junit.Assert;

import junit.framework.TestCase;

public class CarLoanCalculatorTest extends TestCase {

	private CarLoanConstants carLoanConstant ;
	private CarLoanCalculator carLoanCalculator;

	@Override
	protected void setUp(){


	}


	public void testBigDecimal(){
		final BigDecimal decimal = new BigDecimal(100);

		System.out.println(decimal.pow(2));
	}

	public void testCalculateInterestRate() throws CarLoanException{
		carLoanConstant = new CarLoanConstants();
		carLoanCalculator = new CarLoanCalculator(carLoanConstant);
		carLoanConstant.setCarPrice(20000.0);
		carLoanConstant.setTradeInValue(4000);
		//cc.setInterestRate(5);
		carLoanConstant.setMonthlyPayment(475.95);
		carLoanConstant.setNumberOfMonths(36);

		carLoanCalculator.calculateInterestRate();

		System.out.println(carLoanConstant.getInterestRate());
		Assert.assertEquals(4.5, 4,5);
	}

	public void testCalculateMonthlyPayment(){
		carLoanConstant = new CarLoanConstants();
		carLoanConstant.setCarPrice(20000);
		carLoanConstant.setTradeInValue(4000);
		carLoanConstant.setInterestRate(4.5);
		//cc.setMonthlyPayment(444.44);
		carLoanConstant.setNumberOfMonths(1);



		final double a=1.03;
		final double b=.42;
		final BigDecimal d = new BigDecimal(1.03);
		final BigDecimal f = new BigDecimal(0.42);
		System.out.println(" *********"+(a-b));
		System.out.println(" *********"+(d.subtract(f)));
		carLoanCalculator.calculateMonthlyPayment();

		System.out.println(carLoanConstant.getMonthlyPayment());
	}

	public void testCalculateRegex() {
		String regex = "\\d+";
		String value1 = "10.222";
		String value3= "10.21";
		System.out.println(value1.matches(regex));
		System.out.println(value3.matches(regex));
		System.out.println("11".matches(regex));
		System.out.println("11.1".matches(regex));
		System.out.println("ab".matches(regex));
		System.out.println("-11".matches(regex));


	}

}
