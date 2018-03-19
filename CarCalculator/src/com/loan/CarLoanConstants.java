package com.loan;

public class CarLoanConstants {

	/** Car price constant **/
	private double carPrice = 0.00;


	/** Trade in value constant **/
	private double tradeInValue = 0.00;

	/** Interest rate constant **/
	private double interestRate = 0.00;

	/** Number of Months Constant **/
	private int numberOfMonths = 1;

	/** Mothly payment variable */
	private double monthlyPayment =0.00;

	/** Total Amount Paid Variable */
	private double totalAmountPaid =0.00;

	/** Total Interest Paid Variable */
	private double totalInterestPaid =0.00;

	/** Last Month Payment Variable */
	private double lastMonthPaymet =0.00;

	/**
	 * @return the lastMonthPaymet
	 */
	public double getLastMonthPaymet() {
		return lastMonthPaymet;
	}



	/**
	 * @return.
	 * 		car price
	 */
	public double getCarPrice() {
		return carPrice; //cent calculation
	}

	public double getInterestRate() {
		return interestRate;
	}

	public double getMonthlyPayment() {
		return monthlyPayment;
	}

	public int getNumberOfMonths() {
		return numberOfMonths;
	}


	public double getTotalAmountPaid() {
		return totalAmountPaid;
	}

	public double getTotalInterestPaid() {
		return totalInterestPaid;
	}

	public double getTradeInValue() {
		return tradeInValue;
	}

	public void setCarPrice(double carPrice) {
		this.carPrice = carPrice;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public void setMonthlyPayment(double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}

	public void setNumberOfMonths(int numberOfMonths) {
		this.numberOfMonths = numberOfMonths;
	}


	public void setTotalAmountPaid(double totalAmountPaid) {
		this.totalAmountPaid = totalAmountPaid;
	}

	public void setTotalInterestPaid(double totalInterestPaid) {
		this.totalInterestPaid = totalInterestPaid;
	}

	public void setTradeInValue(double tradeInValue) {
		this.tradeInValue = tradeInValue;
	}

	/**
	 * Sets the last month payment
	 * @param lastMonthPaymet
	 */
	public void setLastMonthPaymet(double lastMonthPaymet) {
		this.lastMonthPaymet = lastMonthPaymet;
	}

}
