package com.loan;




import java.util.List;

import org.junit.Assert;

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

		Assert.assertEquals(4.5, 4,5);
	}

	public void testCalculateMonthlyPayment(){

		final CarLoanConstants cc = new CarLoanConstants();
		cc.setCarPrice(20000);
		cc.setTradeInValue(4000);
		cc.setInterestRate(4.5);
		//cc.setMonthlyPayment(444.44);
		cc.setNumberOfMonths(36);

		new CarLoanCalculator(cc);
		System.out.println();
	}
	
	public void testGetHistoryData(){
		final CarLoanConstants cc = new CarLoanConstants();
		cc.setCarPrice(10000);
		cc.setTradeInValue(4000);
		cc.setInterestRate(4.5);
		//cc.setMonthlyPayment(444.44);
		cc.setNumberOfMonths(36);
		CarLoanCalculator ccc= new CarLoanCalculator(cc);
		ccc.addHistoryData();
		cc.setCarPrice(20000);
		cc.setTradeInValue(4000);
		cc.setInterestRate(4.5);
		//cc.setMonthlyPayment(444.44);
		cc.setNumberOfMonths(36);
		ccc.addHistoryData();
		
		System.out.println(ccc.getHistoryData().size());
		
		List<CarLoanConstants> carLoan= ccc.getHistoryData();
		
		for (CarLoanConstants ccr : carLoan) {
			System.out.println(ccr.getCarPrice());
		}
		
	}
}
