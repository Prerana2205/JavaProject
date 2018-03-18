package com.loan;

public class CarLoanException extends Exception{

	/**
	 *
	 */
	private static final long serialVersionUID = -3185354774517182690L;


	/**
	 * Constructs the exception objects with the message passed.
	 *
	 * @param message the error message
	 */
	public CarLoanException(final String message) {
		super(message);
	}

	/**
	 * Constructs the exception objects with the exception object and the message passed.
	 *
	 * @param message the exception message passed
	 * @param throwable the actual exception/error
	 */
	public CarLoanException(final String message, final Throwable throwable) {
		super(message, throwable);
	}
}
