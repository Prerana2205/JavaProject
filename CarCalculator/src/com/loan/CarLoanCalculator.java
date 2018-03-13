package com.loan;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.NumberFormatter;

public class CarLoanCalculator {

	//private double monthlyPayment = 0.0;
	private double remPayment;
	private double lastMonthPayment;
	
	private double totalAmountPaid = 0.0;
	private double totalInterestPaid = 0.0;
	
	//public CarLoanCalculator(CarLoanConstants carLoanConstants){
	CarLoanConstants carLoanConstants = new CarLoanConstants();
	double carPrice = carLoanConstants.getCarPrice();
	double tradeInValue =carLoanConstants.getTradeInValue();
	double interestRate=carLoanConstants.getInterestRate();
	int numberOfMonths=carLoanConstants.getNumberOfMonths();
	double monthlyPayment = carLoanConstants.getMonthlyPayment();
	
	
	 double monthlyInterestRate= interestRate/12/100;
	//counters for functions
	 int counter = 0;
	 int buildModelCounter = numberOfMonths;
	//interestRate = carLoanConstants.getInterestRate();
	//}
	// private List<CarLoanConstants> clcHistory = new ArrayList<>();

	DecimalFormat decimalFormat = new DecimalFormat("0.##");

	public double calculateMonthlyPayment(CarLoanConstants carLoanConstants) {
		interestRate = carLoanConstants.getInterestRate();
		tradeInValue = carLoanConstants.getTradeInValue();
		numberOfMonths = carLoanConstants.getNumberOfMonths();
		carPrice = carLoanConstants.getCarPrice();

		carPrice = carPrice - tradeInValue;
		monthlyInterestRate = (interestRate / 12) / 100;
		String format = decimalFormat.format(carPrice);
		carPrice = Double.parseDouble(format);

		if (monthlyInterestRate > 0) {
			monthlyPayment = (monthlyInterestRate * carPrice)
					/ (1 - Math.pow((1 + monthlyInterestRate), -1 * (numberOfMonths)));
		} else {
			monthlyPayment = carPrice / numberOfMonths;
		}

		String mpf = decimalFormat.format(monthlyPayment);
		double monthlyPayment1 = Double.parseDouble(mpf);
		double lastMonthPayment;
		double remainingPayment = monthlyPayment - monthlyPayment1;
		if (remainingPayment > 0) {
			lastMonthPayment = monthlyPayment + (remainingPayment * numberOfMonths);
			String lmpf = decimalFormat.format(lastMonthPayment);
			lastMonthPayment = Double.parseDouble(lmpf);

			System.out.println("Monthly payments for the first " + (numberOfMonths - 1) + " are $" + monthlyPayment1
					+ " and \nLast month payment is $" + lastMonthPayment);
		} else {
			System.out.println("Monthly payment is $" + monthlyPayment + "for " + numberOfMonths + " months");

		}
		carLoanConstants.setMonthlyPayment(monthlyPayment);
		return monthlyPayment;

	}

	public double calculateTotalAmountPaid() {
		totalAmountPaid = (monthlyPayment * (numberOfMonths));
		String mpf = decimalFormat.format(totalAmountPaid);
		totalAmountPaid = Double.parseDouble(mpf);

		System.out.println("Total Maount paid:" + totalAmountPaid);
		return totalAmountPaid;

	}

	public double calculateTotalInterestPaid() {
		totalInterestPaid = totalAmountPaid - carPrice;
		String mpf = decimalFormat.format(totalInterestPaid);
		totalInterestPaid = Double.parseDouble(mpf);

		System.out.println("InterestPaidTotal:" + totalInterestPaid);
		return totalInterestPaid;
	}

	public void createHistoryTable() {
		System.out.println(
				"No" + (counter++) + "\tCarPrice" + carPrice + "\tTradeInvalue" + tradeInValue + "\tInterestRate"
						+ interestRate + "\tNoofMonths" + numberOfMonths + "\tMonthlyPayment" + monthlyPayment);
	}

	// Recursion
	private int n = 1;

	public int calculateNumberOfMonths(CarLoanConstants carLoanConstants) {
		interestRate = carLoanConstants.getInterestRate();
		tradeInValue = carLoanConstants.getTradeInValue();
		// numberOfMonths = carLoanConstants.getNumberOfMonths();
		carPrice = carLoanConstants.getCarPrice();
		monthlyPayment = carLoanConstants.getMonthlyPayment();

		carPrice = carPrice - tradeInValue;
		monthlyInterestRate = (interestRate / 12) / 100;

		if (monthlyInterestRate == 0) {
			numberOfMonths = (int) ((int) carPrice / monthlyPayment);
		} else {
			if ((monthlyInterestRate * carPrice
					/ (1 - Math.pow((1 + monthlyInterestRate), (0 - n)))) > monthlyPayment) {
				System.out.println("n is " + n);
				carLoanConstants.setNumberOfMonths(n);
				n++;
				calculateNumberOfMonths(carLoanConstants);
			}
			// numberOfMonths = n;

		}

		System.out.println("months: " + carLoanConstants.getNumberOfMonths());
		return numberOfMonths;
	}

	public double calculateCarPrice(CarLoanConstants carLoanConstants) {
		interestRate = carLoanConstants.getInterestRate();
		tradeInValue = carLoanConstants.getTradeInValue();
		numberOfMonths = carLoanConstants.getNumberOfMonths();
		// carPrice = carLoanConstants.getCarPrice();
		monthlyPayment = carLoanConstants.getMonthlyPayment();
		double noTradeInCarPrice;
		// carPrice = carPrice - tradeInValue;
		monthlyInterestRate = (interestRate / 12) / 100;

		if (monthlyInterestRate == 0) {
			noTradeInCarPrice = monthlyPayment * numberOfMonths;
		} else {
			noTradeInCarPrice = monthlyPayment * (1 - (Math.pow((1 + monthlyInterestRate), (-numberOfMonths))))
					/ monthlyInterestRate;
		}
		if (tradeInValue > 0) {
			carPrice = noTradeInCarPrice + tradeInValue;
		} else
			carPrice = noTradeInCarPrice;

		String format = decimalFormat.format(carPrice);
		carPrice = Double.parseDouble(format);

		carLoanConstants.setCarPrice(carPrice);
		System.out.println("car price: " + carPrice);

		return carPrice;
	}

	double[] x;
	double[] y;

	public void createAmortizationTable(CarLoanConstants carLoanConstants) {
		double principle;
		double payment; // constant
		double interestPaid;
		double principlePaid;
		double balance;
		double monthlyInterest; // constant
		int n;
		double totalPrinciplePaid = 0.0;

		payment = carLoanConstants.getMonthlyPayment();
		principle = carLoanConstants.getCarPrice() - carLoanConstants.getTradeInValue();
		monthlyInterest = carLoanConstants.getInterestRate() / 12 / 100;
		n = carLoanConstants.getNumberOfMonths();

		x = new double[n];
		y = new double[n];

		interestPaid = principle * monthlyInterest;
		principlePaid = payment - interestPaid;
		balance = principle - principlePaid;

		List<LoanAmortization> loanAmortization = new ArrayList<>();

		System.out.println("Month\tPrinciple\t\tMonthlyPayment\t\t InterestPaid\t\tPrinciplePaid\t\tBalance\n");

		for (int i = 0; i < n; i++) {
			LoanAmortization la = new LoanAmortization(principle, payment, interestPaid, principlePaid, balance);
			loanAmortization.add(la);
			x[i] = interestPaid;
			y[i] = principle;

			totalInterestPaid = totalInterestPaid + interestPaid;
			totalPrinciplePaid = totalPrinciplePaid + principlePaid;
			System.out.println(i + "\t" + principle + "\t\t" + payment + "\t\t" + interestPaid + "\t\t" + principlePaid
					+ "\t\t" + balance);

			principle = balance;
			interestPaid = principle * monthlyInterest;
			principlePaid = payment - interestPaid;
			balance = principle - principlePaid;
			if (balance < 0)
				balance = 0;

			totalAmountPaid = totalAmountPaid + payment;

		}
		System.out.println("TotalAmountPaid:\tTotalInterestPaid:\t TotalPrinciplePaid");
		System.out.println(totalAmountPaid + "\t\t" + totalInterestPaid + "\t\t" + totalPrinciplePaid);
		System.out.println(loanAmortization.get(1));
	}

	public double calculateInterestRate(CarLoanConstants carLoanConstants) {
		// interestRate = carLoanConstants.getInterestRate();
		tradeInValue = carLoanConstants.getTradeInValue();
		numberOfMonths = carLoanConstants.getNumberOfMonths();
		carPrice = carLoanConstants.getCarPrice();
		monthlyPayment = carLoanConstants.getMonthlyPayment();
		monthlyInterestRate = 0.0;
		interestRate = 0.0;

		carPrice = carPrice - tradeInValue;
		// monthlyInterestRate = (interestRate / 12) / 100;

		if (monthlyPayment == (carPrice / numberOfMonths)) {
			monthlyInterestRate = 0;
			interestRate = 0;
		} else {
			double interestPaid = x[0];
			double principle = y[0];
			monthlyInterestRate = interestPaid / principle;
			interestRate = monthlyInterestRate * 12 * 100;
			/*
			 * double m = (y[10]-y[1])/(x[10]-x[1]); interestRate = m*12*100;
			 */

		}
		System.out.println("Monthe IR:" + monthlyInterestRate + "\tInterest" + interestRate);
		return interestRate;
	}

	///private int count = -1;

	// balance at the end of month model- calculate recursively
	double balance = 0;
	public double buildModel(int n) {
	//	carPrice = carLoanConstants.getCarPrice();
		//tradeInValue = carLoanConstants.getTradeInValue();
		//interestRate = carLoanConstants.getInterestRate();
		numberOfMonths = n-1;
		//count=numberOfMonths;
		//numberOfMonths = numberOfMonths - 1;
		//monthlyPayment = carLoanConstants.getMonthlyPayment();
		// monthlyInterestRate = 0.0;
		// interestRate=0.0;
		// carPrice = carPrice - tradeInValue;
		
		//monthlyInterestRate = (interestRate / 12) / 100;

		// put r=0
		
		if (numberOfMonths == 0) {
			
			balance = carPrice;
			System.out.println("<0 number of months: " +numberOfMonths +"balance: "+balance);
		} else {
			
				balance = (1 + monthlyInterestRate) * buildModel(numberOfMonths) - monthlyPayment;
				System.out.println(">0 number of months: " +numberOfMonths +"balance: "+balance);
			
		}
		
		return balance;
	}
	
	

}
