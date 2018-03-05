package com.loan;

public class CarLoanCalculator {
	

	public double calculateMonthlyPayment(CarLoanConstants carLoanConstants){
		
		double monthlyInterestRate = carLoanConstants.getInterestRate();
		int numberOfMonths = carLoanConstants.getNumberOfMonths();
		double carPrice = carLoanConstants.getCarPrice();
		double monthlyPayment;
		double remPayment;
		double lastMonthPayment;
		
		monthlyPayment = (monthlyInterestRate * carPrice) / (1 - Math.pow((1 + monthlyInterestRate), numberOfMonths));
		System.out.println("\nMonthlyPayment is: " + monthlyPayment);
		remPayment = carPrice - (monthlyPayment * numberOfMonths);

		if (remPayment > 0) {
			lastMonthPayment = monthlyPayment + remPayment;
			System.out.println("Monthly payments for the first " + (numberOfMonths - 1) + "are $" + monthlyPayment
					+ " and Last month payment is $" + lastMonthPayment);
		} else {
			lastMonthPayment = monthlyPayment;
			System.out.println("Monthly payment is $" + monthlyPayment + "for " + numberOfMonths + " months");
		}
		return monthlyPayment;
		
	}
	
	public void calculateTotalAmountPaid(){
		
	}
	
	public void calculateTotalInterestPaid(){
		
		
	}
}
