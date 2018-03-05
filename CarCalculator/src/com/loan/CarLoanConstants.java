package com.loan;

public class CarLoanConstants {

	/** Car price constant **/
	private double carPrice = 0.0;

	/** Trade in value constant **/
	private double tradeInValue = 0.0;

	/** Interest rate constant **/
	private double interestRate = 0.0;

	/** Number of Months Constant **/
	private int numberOfMonths = 10;
	
	private double monthlyPayment;
	
	private double totalAmountPaid;
	
	private double totalInterestPaid;

	/**
	 * @return. 
	 * 		car price
	 */
	public double getCarPrice() {
		return carPrice;
	}

	public void setCarPrice(double carPrice) {
		this.carPrice = carPrice;
	}

	public double getTradeInValue() {
		return tradeInValue;
	}

	public void setTradeInValue(double tradeInValue) {
		this.tradeInValue = tradeInValue;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public int getNumberOfMonths() {
		return numberOfMonths;
	}

	public void setNumberOfMonths(int numberOfMonths) {
		this.numberOfMonths = numberOfMonths;
	}

	public double getMonthlyPayment() {
		return monthlyPayment;
	}

	public void setMonthlyPayment(double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}

	public double getTotalAmountPaid() {
		return totalAmountPaid;
	}

	public void setTotalAmountPaid(double totalAmountPaid) {
		this.totalAmountPaid = totalAmountPaid;
	}

	public double getTotalInterestPaid() {
		return totalInterestPaid;
	}

	public void setTotalInterestPaid(double totalInterestPaid) {
		this.totalInterestPaid = totalInterestPaid;
	}
	
	
}
