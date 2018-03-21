package com.loan;

import java.text.DecimalFormat;

/**
 * CarLoan Calculator class which calculates the interest rate,
 * car price, trade in value,number of months etc
 *
 */
public class CarLoanCalculator {

	/** Car loan constant variable */
	private final CarLoanConstants carLoanConstants;


	/** Decimal Format Conversion */
	DecimalFormat decimalFormat = new DecimalFormat("0.##");

	/** Last Month Payment variable	 */
	private double lastMonthPayment =0.0;



	/**
	 * Constructor of class
	 * @param carLoanConstants
	 */
	public CarLoanCalculator(CarLoanConstants carLoanConstants) {

		this.carLoanConstants = carLoanConstants;
	}


	/**
	 * Calculates the carPrice.
	 *
	 */
	public void calculateCarPrice() {

		System.out.println("Inside calculate Car Price");

		//variable to hold the calcarprice
		double calCarPrice = 0.0;

		final double monthlyPayment = carLoanConstants.getMonthlyPayment();
		final double monthlyInterestRate = getMonthlyInterestRate();
		final double numberOfMonths = carLoanConstants.getNumberOfMonths();

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
	 */
	public void calculateInterestRate() {

		System.out.println("Inside calculate Interest Rate");

		//set the min rate
		double minIntRate = 0;

		//set the max rate
		double maxIntate = 100;

		//set the mid rate
		double mid_rate = 0;
		double monthlyInterestRate;
		double guessed_amt;

		final double monthlyPayment = carLoanConstants.getMonthlyPayment();
		final int numberOfMonths = carLoanConstants.getNumberOfMonths();
		final double loan_amt = getCarPriceWithoutTradeInValue();

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

		carLoanConstants.setInterestRate(decimalFormatConverstion(mid_rate));
	}

	/**
	 *
	 * Calculates Monthly Payments and last month payment
	 *
	 */
	public void calculateMonthlyPayment() {

		System.out.println("***** Inside calculateMonthlyPayment *******");

		double monthlyPayment;
		double carPrice = getCarPriceWithoutTradeInValue();
		final double monthlyInterestRate = getMonthlyInterestRate();
		final int numberOfMonths = carLoanConstants.getNumberOfMonths();

		//validation to check if months lies between 0 and 84
		if (numberOfMonths == 0 || numberOfMonths >84) {
			carLoanConstants.setNumberOfMonths(1);
		}

		//convert to 2 decimal
		carPrice = decimalFormatConverstion(carPrice);

		if (monthlyInterestRate > 0) {
			monthlyPayment = (monthlyInterestRate * carPrice)
					/ (1 - Math.pow((1 + monthlyInterestRate), -1 * (numberOfMonths)));
		} else {
			monthlyPayment = carPrice / numberOfMonths;
		}

		final double totalAmount = decimalFormatConverstion(monthlyPayment * numberOfMonths);
		monthlyPayment = decimalFormatConverstion(monthlyPayment);

		lastMonthPayment = totalAmount - (monthlyPayment * (numberOfMonths - 1));

		System.out.println("Monthly payments for the first " + (numberOfMonths - 1) + " are $" + monthlyPayment
				+ " and \nLast month payment is $" + lastMonthPayment);

		carLoanConstants.setMonthlyPayment(monthlyPayment);
		carLoanConstants.setLastMonthPaymet(decimalFormatConverstion(lastMonthPayment));

	}

	/**
	 * Method to calculate number of months
	 */

	public void calculateNumberOfMonths() {

		System.out.println("***** Inside calculateNumberOfMonths *******");

		final double monthlyPayment = carLoanConstants.getMonthlyPayment();
		final double monthlyInterestRate = getMonthlyInterestRate();
		final double carPrice = getCarPriceWithoutTradeInValue();

		int numberOfMonths = 0;
		if (monthlyInterestRate == 0 || monthlyInterestRate==0.0) {
			numberOfMonths = (int) (carPrice/monthlyPayment);
		}
		else {
			numberOfMonths= (int) (-(Math.log(1-((carPrice * monthlyInterestRate)/monthlyPayment)))/Math.log(1+monthlyInterestRate));
		}

		carLoanConstants.setNumberOfMonths(numberOfMonths);

	}

	/**
	 * Method to calculate Total Amount paid
	 */
	public void calculateTotalAmountPaid() throws CarLoanException {

		System.out.println("Inside calculateTotal Amount Paid");

		final int numberOfMonths = carLoanConstants.getNumberOfMonths();
		double totalAmountPaid = ((carLoanConstants.getMonthlyPayment() * (numberOfMonths -1))) + lastMonthPayment ;

		carLoanConstants.setTotalAmountPaid(decimalFormatConverstion(totalAmountPaid));

	}

	/**
	 * Method to calculate TotalInterest Paid
	 */
	public void calculateTotalInterestPaid() {

		System.out.println("Inside calculate Total Interest Paid");

		final double totalInterestPaid;
		if (carLoanConstants.getInterestRate() == 0.0) {
			totalInterestPaid = 0.0;
		} else {
			totalInterestPaid = carLoanConstants.getTotalAmountPaid() - (carLoanConstants.getCarPrice()
					- carLoanConstants.getTradeInValue());
		}

		carLoanConstants.setTotalInterestPaid(decimalFormatConverstion(totalInterestPaid));

	}

	/**
	 *
	 * Calculate Trade in value
	 *
	 */

	public void calculateTradeInValue(){

		System.out.println("Inside calculate Trade In value");

		final double monthlyPayment = carLoanConstants.getMonthlyPayment();
		final double monthlyInterestRate = getMonthlyInterestRate();
		final double numberOfMonths = carLoanConstants.getNumberOfMonths();
		final double carPrice = carLoanConstants.getCarPrice();
		final double tradeInValue;

		if(monthlyInterestRate == 0.0){
			tradeInValue =  carPrice - (monthlyPayment*numberOfMonths);
		}else{
			tradeInValue = carPrice - ((monthlyPayment*(1-Math.pow((1+monthlyInterestRate),-numberOfMonths)))/monthlyInterestRate);
		}

		carLoanConstants.setTradeInValue(decimalFormatConverstion(tradeInValue));

	}


	public void createHistoryTable() {
		System.out.println("\tCarPrice" + carLoanConstants.getCarPrice() + "\tTradeInvalue"
				+ carLoanConstants.getTradeInValue() + "\tInterestRate" + carLoanConstants.getInterestRate()
				+ "\tNoofMonths" + carLoanConstants.getNumberOfMonths() + "\tMonthlyPayment"
				+ carLoanConstants.getMonthlyPayment());
	}

	/**
	 * Converts the value to 2 decimal points
	 * @param value
	 * 			double value parameter
	 * @return
	 * 		value
	 */
	private double decimalFormatConverstion(double value) {

		final String decimalConvert = decimalFormat.format(value);
		return Double.parseDouble(decimalConvert);

	}

	/**
	 * Get the carLoanConstants
	 * @return
	 */
	public CarLoanConstants getCarLoanConstants() {
		return carLoanConstants;
	}

	/**
	 * Calculate the carprice without trade in value
	 * @return
	 * 		The calculated value
	 */
	private double getCarPriceWithoutTradeInValue() {
		return carLoanConstants.getCarPrice() - carLoanConstants.getTradeInValue();
	}


	/**
	 * Calculate the Monthly interest rate by dividing
	 * the yearly interest rate by 1200
	 * @return
	 * 		The calculated value
	 */
	private double getMonthlyInterestRate() {

		final double interestRate = carLoanConstants.getInterestRate();
		return interestRate / 1200;
	}

}
