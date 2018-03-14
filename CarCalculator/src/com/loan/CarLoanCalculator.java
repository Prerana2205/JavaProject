package com.loan;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CarLoanCalculator {

	/** Car loan constant variable */
	private final CarLoanConstants carLoanConstants;

	/** Decimal Format Conversion */
	DecimalFormat decimalFormat = new DecimalFormat("0.##");

	public CarLoanCalculator(CarLoanConstants carLoanConstants) {

		this.carLoanConstants = carLoanConstants;
	}

	/**
	 * Calculates the carPrice when monthly payment is present
	 *
	 * @throws CarLoanException
	 */
	public void calculateCarPrice() throws CarLoanException {

		System.out.println("Inside calculate Car Price");
		double calCarPrice = 0.0;
		final double monthlyPayment = carLoanConstants.getMonthlyPayment();
		final double monthlyInterestRate = getMonthlyInterestRate();
		final double numberOfMonths = carLoanConstants.getNumberOfMonths();

		// initial Validation
		if (monthlyPayment == 0.0) {
			throw new CarLoanException("Monthly Payment is not set to calculate Car Price");
		}

		if (monthlyInterestRate == 0) {
			calCarPrice = monthlyPayment * numberOfMonths;
		} else {
			calCarPrice = monthlyPayment * (1 - (Math.pow((1 + monthlyInterestRate), (-numberOfMonths))))
					/ monthlyInterestRate;
		}
		calCarPrice = calCarPrice + carLoanConstants.getTradeInValue();

		carLoanConstants.setCarPrice(decimalFormatConverstion(calCarPrice));

	}

	/**
	 *
	 * Calculate Interest rate
	 *
	 * @param carLoanConstants
	 * @return
	 * @throws CarLoanException
	 */
	public void calculateInterestRate() throws CarLoanException {
		double minIntRate = 0;
		double maxIntate = 100;
		double mid_rate = 0;
		double monthlyInterestRate;
		double guessed_amt;

		final double monthlyPayment = carLoanConstants.getMonthlyPayment();
		final int numberOfMonths = carLoanConstants.getNumberOfMonths();
		final double loan_amt = getCarPriceWithoutTradeInValue();

		if (monthlyPayment == 0.0) {

			throw new CarLoanException("Monthly Payment is not set for calculating interest rate");
		}

		while (minIntRate < maxIntate - 0.0001) {

			mid_rate = (minIntRate + maxIntate) / 2;
			// Convert to monthly decimal
			monthlyInterestRate = mid_rate / 1200;
			// # calculate payment from interest, term and loan_amt
			guessed_amt = loan_amt * (monthlyInterestRate / (1 - Math.pow((1 + monthlyInterestRate), -numberOfMonths)));
			if (guessed_amt > monthlyPayment) {
				// # current rate is new maximum
				maxIntate = mid_rate;
			} else {
				// # current rate is new minimum
				minIntRate = mid_rate;
			}
		}

		carLoanConstants.setInterestRate(mid_rate);
	}

	public void calculateMonthlyPayment() throws CarLoanException {
		System.out.println("***** Inside calculateMonthlyPayment *******");

		double monthlyPayment;
		double carPrice = getCarPriceWithoutTradeInValue();
		final double monthlyInterestRate = getMonthlyInterestRate();
		final int numberOfMonths = carLoanConstants.getNumberOfMonths();

		if (carPrice == 0.0) {
			throw new CarLoanException("Car Price is not set");
		}
		carPrice = decimalFormatConverstion(carPrice);

		if (monthlyInterestRate > 0) {
			monthlyPayment = (monthlyInterestRate * carPrice)
					/ (1 - Math.pow((1 + monthlyInterestRate), -1 * (numberOfMonths)));
		} else {
			monthlyPayment = carPrice / numberOfMonths;
		}

		final double totalAmount = decimalFormatConverstion(monthlyPayment * 12);
		monthlyPayment = decimalFormatConverstion(monthlyPayment);

		final double lastMonthPayment = totalAmount - (monthlyPayment * (numberOfMonths - 1));

		System.out.println("Monthly payments for the first " + (numberOfMonths - 1) + " are $" + monthlyPayment
				+ " and \nLast month payment is $" + lastMonthPayment);
		carLoanConstants.setMonthlyPayment(monthlyPayment);

	}

	public void calculateNumberOfMonths() throws CarLoanException {

		int n = 1;

		final double monthlyPayment = carLoanConstants.getMonthlyPayment();
		final double monthlyInterestRate = getMonthlyInterestRate();
		final double carPrice = getCarPriceWithoutTradeInValue();

		if (carLoanConstants.getMonthlyPayment() == 0.0) {
			throw new CarLoanException("Monthly Payment is not set");
		}

		if (monthlyInterestRate == 0) {
		} else {
			if ((monthlyInterestRate * carPrice
					/ (1 - Math.pow((1 + monthlyInterestRate), (0 - n)))) > monthlyPayment) {
				System.out.println("n is " + n);
				//
				n++;
				calculateNumberOfMonths();
			}

		}
		carLoanConstants.setNumberOfMonths(n);
		System.out.println("months: " + carLoanConstants.getNumberOfMonths());
	}

	public void calculateTotalAmountPaid() throws CarLoanException {
		final int numberOfMonths = carLoanConstants.getNumberOfMonths();
		if (carLoanConstants.getMonthlyPayment() == 0.0) {
			throw new CarLoanException("Monthly Payment is not Set");
		}

		// else continue
		final double totalAmountPaid = (carLoanConstants.getMonthlyPayment() * (numberOfMonths));

		carLoanConstants.setTotalAmountPaid(decimalFormatConverstion(totalAmountPaid));

	}

	public void calculateTotalInterestPaid() {

		final double totalInterestPaid = carLoanConstants.getTotalAmountPaid() - carLoanConstants.getCarPrice();

		carLoanConstants.setTotalInterestPaid(decimalFormatConverstion(totalInterestPaid));

	}

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
		principle = getCarPriceWithoutTradeInValue();
		monthlyInterest = carLoanConstants.getInterestRate() / 12 / 100;
		n = carLoanConstants.getNumberOfMonths();

		final double x[] = new double[n];
		final double y[] = new double[n];

		interestPaid = principle * monthlyInterest;
		principlePaid = payment - interestPaid;
		balance = principle - principlePaid;

		final List<LoanAmortization> loanAmortization = new ArrayList<>();

		System.out.println("Month\tPrinciple\t\tMonthlyPayment\t\t InterestPaid\t\tPrinciplePaid\t\tBalance\n");
		double totalAmountPaid = 0.0;
		double totalInterestPaid = 0.0;

		for (int i = 0; i < n; i++) {
			final LoanAmortization la = new LoanAmortization(principle, payment, interestPaid, principlePaid, balance);
			loanAmortization.add(la);
			x[i] = interestPaid;
			y[i] = principle;

			totalInterestPaid = carLoanConstants.getTotalInterestPaid() + interestPaid;
			totalPrinciplePaid = totalPrinciplePaid + principlePaid;
			System.out.println(i + "\t" + principle + "\t\t" + payment + "\t\t" + interestPaid + "\t\t" + principlePaid
					+ "\t\t" + balance);

			principle = balance;
			interestPaid = principle * monthlyInterest;
			principlePaid = payment - interestPaid;
			balance = principle - principlePaid;
			if (balance < 0) {
				balance = 0;
			}

			totalAmountPaid = carLoanConstants.getTotalAmountPaid() + payment;

		}
		System.out.println("TotalAmountPaid:\tTotalInterestPaid:\t TotalPrinciplePaid");
		System.out.println(totalAmountPaid + "\t\t" + totalInterestPaid + "\t\t" + totalPrinciplePaid);
		System.out.println(loanAmortization.get(1));
	}

	public void createHistoryTable() {
		System.out.println("\tCarPrice" + carLoanConstants.getCarPrice() + "\tTradeInvalue"
				+ carLoanConstants.getTradeInValue() + "\tInterestRate" + carLoanConstants.getInterestRate()
				+ "\tNoofMonths" + carLoanConstants.getNumberOfMonths() + "\tMonthlyPayment"
				+ carLoanConstants.getMonthlyPayment());
	}

	private double decimalFormatConverstion(double value) {

		final String decimalConvert = decimalFormat.format(value);
		return Double.parseDouble(decimalConvert);

	}

	private double getCarPriceWithoutTradeInValue() {
		return carLoanConstants.getCarPrice() - carLoanConstants.getTradeInValue();
	}

	private double getMonthlyInterestRate() {
		final double interestRate = carLoanConstants.getInterestRate();
		return interestRate / 1200;
	}

}
