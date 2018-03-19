package com.loan;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

//import swing.LanguagesUI;

@SuppressWarnings("serial")
public class SwingControlDemo extends javax.swing.JFrame implements PropertyChangeListener, KeyListener {
	private double carPrice;
	private double rate; // 7.5%
	private int numPeriods = 1;
	private double tradeInValue;

	String decnumberregex = "\\d+(\\.\\d{1,2})?";
	String numberregex = "\\d+";
	private JFormattedTextField carPriceFormattedTextField;
	private JFormattedTextField tradeInFormattedTextField;
	private JFormattedTextField interestRateFormattedTextField;
	private JFormattedTextField numberOfMonthsFormattedTextField;
	private JFormattedTextField monthlyPaymentOutputField;
	private JFormattedTextField totalAmountPaidField;
	private JFormattedTextField totalInterestPaidField;

	// validator attributes
	JLabel carPriceValidator;
	JLabel monthsValidator;
	JLabel tradeInValidator;
	JLabel interestRateValidator;

	// Formatting the fields input and output
	private NumberFormat carPriceFormat;

	private NumberFormat interestRateFormat;

	private NumberFormat paymentsFormat;
	JButton btnAddToTable;
	private NumberFormat numberMonthsFormat;
	private CarLoanConstants carLoanConstants;
	private final CarLoanCalculator carLoanCalculator;

	Object[] row = new Object[5];
	int rowNumber = 1;

	public SwingControlDemo() {
		carLoanConstants = new CarLoanConstants();
		carLoanCalculator = new CarLoanCalculator(carLoanConstants);
		prepareGUI();

	}

	private void prepareGUI() {

		getContentPane().setBackground(Color.WHITE);
		setTitle("Car Payment Calculator");
		getContentPane().setLayout(null);

		final JLabel lblNewLabel = new JLabel("What's your credit score?");
		lblNewLabel.setFont(new Font("Georgia", Font.BOLD, 13));
		lblNewLabel.setBounds(12, 85, 301, 16);
		getContentPane().add(lblNewLabel);

		final JLabel lblNewLabel_1 = new JLabel("Car price ($)");
		lblNewLabel_1.setFont(new Font("Georgia", Font.BOLD, 13));
		lblNewLabel_1.setBounds(12, 242, 186, 16);
		getContentPane().add(lblNewLabel_1);

		final JLabel lblTradeinDown = new JLabel("Trade-in / down payment ($)");
		lblTradeinDown.setFont(new Font("Georgia", Font.BOLD, 13));
		lblTradeinDown.setBounds(12, 352, 237, 16);
		getContentPane().add(lblTradeinDown);

		final JLabel lblInterestRate = new JLabel("Interest rate (%)");
		lblInterestRate.setFont(new Font("Georgia", Font.BOLD, 13));
		lblInterestRate.setBounds(12, 457, 186, 16);
		getContentPane().add(lblInterestRate);

		final JLabel lblNumberOfMonths = new JLabel("Number of months");
		lblNumberOfMonths.setFont(new Font("Georgia", Font.BOLD, 13));
		lblNumberOfMonths.setBounds(12, 561, 186, 16);
		getContentPane().add(lblNumberOfMonths);

		final JTextArea creditScoreLabel2 = new JTextArea();
		creditScoreLabel2.setFont(new Font("Georgia", Font.PLAIN, 13));
		creditScoreLabel2.setLineWrap(true);
		creditScoreLabel2.setEditable(false);
		creditScoreLabel2.setBounds(12, 140, 325, 54);
		getContentPane().add(creditScoreLabel2);

		final JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Georgia", Font.PLAIN, 13));
		comboBox.setForeground(Color.GRAY);
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(12, 105, 186, 22);
		getContentPane().add(comboBox);
		comboBox.addItem("Super prime (781-850)");
		comboBox.addItem("Prime (661-780)");
		comboBox.addItem("Non Prime (601-660)");
		comboBox.addItem("Sub prime (501-600)");
		comboBox.addItem("Deep prime (300-500)");

		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (comboBox.getSelectedItem().toString().toLowerCase().contains("781")) {
					creditScoreLabel2.setText("Based on your score, the average rate is 3.2% (new) or 3.8% (used).");
				} else if (comboBox.getSelectedItem().toString().toLowerCase().contains("661")) {
					creditScoreLabel2.setText("Based on your score, the average rate is 4% (new) or 5.5% (used).");
				} else if (comboBox.getSelectedItem().toString().toLowerCase().contains("601")) {
					creditScoreLabel2.setText("Based on your score, the average rate is 6.8% (new) or 10% (used).");
				} else if (comboBox.getSelectedItem().toString().toLowerCase().contains("501")) {
					creditScoreLabel2.setText("Based on your score, the average rate is 11% (new) or 16.3% (used).");
				} else {
					creditScoreLabel2.setText("Based on your score, the average rate is 13.8% (new) or 19.3% (used). "
							+ "Consider buying an inexpensive used car and refinancing in 6-12 months.");
				}
			}
		});

		carPriceFormattedTextField = new JFormattedTextField(carPriceFormat);
		carPriceFormattedTextField.setFont(new Font("Georgia", Font.PLAIN, 13));
		carPriceFormattedTextField.setBounds(12, 265, 325, 28);
		getContentPane().add(carPriceFormattedTextField);
		carPriceFormattedTextField.setValue(new Double(carPrice));
		carPriceFormattedTextField.addPropertyChangeListener("value", this);
		carPriceFormattedTextField.addKeyListener(this);
		carPriceFormattedTextField.setFocusTraversalKeysEnabled(false);

		tradeInFormattedTextField = new JFormattedTextField(carPriceFormat);
		tradeInFormattedTextField.setFont(new Font("Georgia", Font.PLAIN, 13));
		tradeInFormattedTextField.setBounds(12, 376, 325, 28);
		getContentPane().add(tradeInFormattedTextField);
		tradeInFormattedTextField.setValue(new Double(tradeInValue));
		tradeInFormattedTextField.addPropertyChangeListener("value", this);
		tradeInFormattedTextField.addKeyListener(this);
		tradeInFormattedTextField.setFocusTraversalKeysEnabled(false);

		interestRateFormattedTextField = new JFormattedTextField(interestRateFormat);
		interestRateFormattedTextField.setFont(new Font("Georgia", Font.PLAIN, 13));
		interestRateFormattedTextField.setBounds(12, 480, 325, 28);
		getContentPane().add(interestRateFormattedTextField);
		interestRateFormattedTextField.setValue(new Double(rate));
		interestRateFormattedTextField.addPropertyChangeListener("value", this);
		interestRateFormattedTextField.addKeyListener(this);
		interestRateFormattedTextField.setFocusTraversalKeysEnabled(false);

		numberOfMonthsFormattedTextField = new JFormattedTextField(numberMonthsFormat);
		numberOfMonthsFormattedTextField.setFont(new Font("Georgia", Font.PLAIN, 13));
		numberOfMonthsFormattedTextField.setBounds(12, 583, 325, 28);
		getContentPane().add(numberOfMonthsFormattedTextField);
		numberOfMonthsFormattedTextField.setValue(new Integer(numPeriods));
		numberOfMonthsFormattedTextField.addPropertyChangeListener("value", this);
		numberOfMonthsFormattedTextField.addKeyListener(this);
		numberOfMonthsFormattedTextField.setFocusTraversalKeysEnabled(false);

		final JLabel lblAfterNegotiations = new JLabel("After negotiations");
		lblAfterNegotiations.setForeground(Color.GRAY);
		lblAfterNegotiations.setBounds(12, 295, 116, 16);
		getContentPane().add(lblAfterNegotiations);

		final JLabel lblYourTradeinCan = new JLabel("Your trade-in can be all or part of a down payment");
		lblYourTradeinCan.setForeground(Color.GRAY);
		lblYourTradeinCan.setBounds(12, 407, 325, 16);
		getContentPane().add(lblYourTradeinCan);

		final JLabel lblAHigherCredit = new JLabel("A higher credit score means lower interest rates");
		lblAHigherCredit.setForeground(Color.GRAY);
		lblAHigherCredit.setBounds(12, 509, 325, 16);
		getContentPane().add(lblAHigherCredit);

		final JLabel lblSuggestedMax = new JLabel("Suggested max: 36 months for used cars, 60 for new");
		lblSuggestedMax.setForeground(Color.GRAY);
		lblSuggestedMax.setBounds(12, 614, 325, 16);
		getContentPane().add(lblSuggestedMax);

		final JLabel lblNewLabel_2 = new JLabel("Payment Details");
		lblNewLabel_2.setFont(new Font("Georgia", Font.BOLD, 18));
		lblNewLabel_2.setBounds(489, 73, 186, 39);
		getContentPane().add(lblNewLabel_2);

		final JLabel lblMonthlyPayment = new JLabel("Monthly Payment ");
		lblMonthlyPayment.setFont(new Font("Georgia", Font.BOLD, 13));
		lblMonthlyPayment.setBounds(489, 127, 172, 28);
		getContentPane().add(lblMonthlyPayment);

		final JLabel lblBeforeTaxesAnd = new JLabel("(Before taxes and fees)");
		lblBeforeTaxesAnd.setForeground(Color.GRAY);
		lblBeforeTaxesAnd.setBounds(488, 197, 208, 16);
		getContentPane().add(lblBeforeTaxesAnd);

		final JLabel lblTotal = new JLabel("Total Amount Paid");
		lblTotal.setFont(new Font("Georgia", Font.BOLD, 13));
		lblTotal.setBounds(488, 226, 153, 24);
		getContentPane().add(lblTotal);

		final JLabel lblTotalInterestPaid = new JLabel("Total Interest Paid");
		lblTotalInterestPaid.setFont(new Font("Georgia", Font.BOLD, 13));
		lblTotalInterestPaid.setBounds(488, 331, 140, 27);
		getContentPane().add(lblTotalInterestPaid);

		final JLabel lblNewLabel_3 = new JLabel("(Over the life of the loan)");
		lblNewLabel_3.setForeground(Color.GRAY);
		lblNewLabel_3.setBounds(488, 295, 159, 16);
		getContentPane().add(lblNewLabel_3);

		monthlyPaymentOutputField = new JFormattedTextField();
		monthlyPaymentOutputField.setBackground(Color.WHITE);
		monthlyPaymentOutputField.setForeground(Color.BLUE);
		monthlyPaymentOutputField.setFont(new Font("Georgia", Font.PLAIN, 16));
		monthlyPaymentOutputField.setEditable(false);
		monthlyPaymentOutputField.setBounds(488, 156, 153, 39);
		monthlyPaymentOutputField.setFocusable(false);
		getContentPane().add(monthlyPaymentOutputField);
		monthlyPaymentOutputField.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		totalAmountPaidField = new JFormattedTextField();
		totalAmountPaidField.setBackground(Color.WHITE);
		totalAmountPaidField.setForeground(Color.BLUE);
		totalAmountPaidField.setFont(new Font("Georgia", Font.PLAIN, 16));
		totalAmountPaidField.setEditable(false);
		totalAmountPaidField.setBounds(488, 254, 153, 39);
		totalAmountPaidField.setFocusable(false);
		getContentPane().add(totalAmountPaidField);
		totalAmountPaidField.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		totalInterestPaidField = new JFormattedTextField();
		totalInterestPaidField.setBackground(Color.WHITE);
		totalInterestPaidField.setFont(new Font("Georgia", Font.PLAIN, 16));
		totalInterestPaidField.setForeground(Color.BLUE);
		totalInterestPaidField.setEditable(false);
		totalInterestPaidField.setBounds(488, 367, 153, 39);
		totalInterestPaidField.setFocusable(false);
		getContentPane().add(totalInterestPaidField);
		totalInterestPaidField.setBorder(javax.swing.BorderFactory.createEmptyBorder());

		JSeparator separator = new JSeparator();
		separator.setBounds(12, 48, 841, 8);
		getContentPane().add(separator);

		JLabel lblCar = new JLabel("Car Payment Calculator");
		lblCar.setFont(new Font("Georgia", Font.BOLD, 25));
		lblCar.setBounds(12, 13, 345, 39);
		getContentPane().add(lblCar);

		btnAddToTable = new JButton("Add To Table -->");
		btnAddToTable.setFont(new Font("Georgia", Font.PLAIN, 13));
		btnAddToTable.setBounds(184, 665, 153, 28);
		btnAddToTable.addKeyListener(this);
		btnAddToTable.setFocusTraversalKeysEnabled(false);
		getContentPane().add(btnAddToTable);

		JLabel lblHistoryTable = new JLabel("History Table");
		lblHistoryTable.setFont(new Font("Georgia", Font.BOLD, 13));
		lblHistoryTable.setBounds(488, 430, 140, 27);
		getContentPane().add(lblHistoryTable);

		//Table changes
		JScrollPane sPane = new JScrollPane();
		sPane.setBounds(453, 468, 418, 183);
		getContentPane().add(sPane);
		JTable table_1 = new JTable();
		table_1.setFocusable(false);
		DefaultTableModel model = new DefaultTableModel(new Object[][] {},
				new String[] { "Car Price", "Trade In Value", "Interest Rate", "Number Of Months", "Monthly Payment" });
		table_1.setModel(model);
		table_1.setFont(new Font("Georgia", Font.PLAIN, 13));
		table_1.getTableHeader().setFont(new Font("Georgia", Font.BOLD, 10));
		// button add row
		btnAddToTable.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				row[0] = carLoanConstants.getCarPrice();
				row[1] = carLoanConstants.getTradeInValue();
				row[2] = carLoanConstants.getInterestRate();
				row[3] = carLoanConstants.getNumberOfMonths();
				row[4] = carLoanConstants.getMonthlyPayment();

				// add row to the model
				model.addRow(row);
			}
		});

		sPane.setViewportView(table_1);

		Font validatorFont = new Font("Georgia", Font.BOLD, 11);
		carPriceValidator = new JLabel("");
		carPriceValidator.setForeground(Color.RED);
		carPriceValidator.setFont(validatorFont);
		carPriceValidator.setBounds(12, 319, 301, 16);
		getContentPane().add(carPriceValidator);

		monthsValidator = new JLabel();
		monthsValidator.setForeground(Color.RED);
		monthsValidator.setFont(validatorFont);
		monthsValidator.setBounds(12, 641, 301, 16);
		getContentPane().add(monthsValidator);

		tradeInValidator = new JLabel();
		tradeInValidator.setForeground(Color.RED);
		tradeInValidator.setFont(validatorFont);
		tradeInValidator.setBounds(12, 430, 301, 16);
		getContentPane().add(tradeInValidator);

		interestRateValidator = new JLabel();
		interestRateValidator.setForeground(Color.RED);
		interestRateValidator.setFont(validatorFont);
		interestRateValidator.setBounds(12, 534, 301, 16);
		getContentPane().add(interestRateValidator);

	}

	@Override
	public void propertyChange(PropertyChangeEvent e) {
		// TODO Auto-generated method stub
		final Object source = e.getSource();
		if (source == carPriceFormattedTextField) {
			if (!carPriceFormattedTextField.getText().matches(decnumberregex)) {
				carPriceValidator.setText("Please enter the number in 0.00 format");
				carPriceFormattedTextField.setText("0.0");
			} else {
				carPrice = ((Number) carPriceFormattedTextField.getValue()).doubleValue();
			}
			carLoanConstants.setCarPrice(carPrice);
		}
		if (source == interestRateFormattedTextField) {
			if (!interestRateFormattedTextField.getText().matches(decnumberregex)) {
				interestRateValidator.setText("Please enter the number in 0.00 format");
				interestRateFormattedTextField.setText("0.0");
			} else {
				rate = ((Number) interestRateFormattedTextField.getValue()).doubleValue();
			}

			if (rate < 0.0) {
				interestRateFormattedTextField.setValue(0.0);
			}
			carLoanConstants.setInterestRate(rate);
		}
		if (source == numberOfMonthsFormattedTextField) {
			if (!numberOfMonthsFormattedTextField.getText().matches(numberregex)) {
				monthsValidator.setText("Number of months should be between 1 & 84");
				numberOfMonthsFormattedTextField.setText("1");
			} else if (Integer.valueOf(numberOfMonthsFormattedTextField.getText()) > 84
					|| Integer.valueOf(numberOfMonthsFormattedTextField.getText()) < 1) {
				monthsValidator.setText("Number of months should be between 1 & 84");
				numberOfMonthsFormattedTextField.setText("1");

			} else {
				numPeriods = ((Number) numberOfMonthsFormattedTextField.getValue()).intValue();
			}

			if (numPeriods < 0 || numPeriods == 0 ) {
				numberOfMonthsFormattedTextField.setValue(1);
			}

			carLoanConstants.setNumberOfMonths(numPeriods);

		}
		if (source == tradeInFormattedTextField) {
			if (!tradeInFormattedTextField.getText().matches(decnumberregex)) {
				tradeInValidator.setText("Please enter the number in 0.00 format");
				tradeInFormattedTextField.setText("0.0");
			}
			else{
				tradeInValue = ((Number) tradeInFormattedTextField.getValue()).intValue();
			}
			carLoanConstants.setTradeInValue(tradeInValue);
		}

		//sequence calculation
		try {
			carLoanCalculator.calculateMonthlyPayment();
			carLoanCalculator.calculateTotalAmountPaid();
			carLoanCalculator.calculateTotalInterestPaid();
		} catch (final CarLoanException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// final double payment = clc.calculateMonthlyPayment(constants);
		monthlyPaymentOutputField.setValue("$" + carLoanConstants.getMonthlyPayment());
		totalAmountPaidField.setValue("$" + carLoanConstants.getTotalAmountPaid());
		totalInterestPaidField.setValue("$" + carLoanConstants.getTotalInterestPaid());

	}

	public void setFormat() {
		carPriceFormat = NumberFormat.getNumberInstance();
		interestRateFormat = NumberFormat.getNumberInstance();
		interestRateFormat.setMinimumFractionDigits(3);
		paymentsFormat = NumberFormat.getCurrencyInstance();
		numberMonthsFormat = NumberFormat.getNumberInstance();
		numberMonthsFormat.setParseIntegerOnly(true);
		numberMonthsFormat.setMinimumIntegerDigits(1);
		numberMonthsFormat.setMaximumIntegerDigits(Integer.MAX_VALUE);

		// NumberFormat format = NumberFormat.getInstance();
		// NumberFormatter intFormat = new NumberFormatter(format);

	}

	@Override
	public void keyPressed(KeyEvent e) {
		carPriceValidator.setText("");
		monthsValidator.setText("");
		tradeInValidator.setText("");
		interestRateValidator.setText("");

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_TAB) {

			if (e.getSource().equals(carPriceFormattedTextField)) {

				if (carPriceFormattedTextField.getText().isEmpty()) {
					try {
						carLoanCalculator.calculateCarPrice();
					} catch (CarLoanException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					carPriceFormattedTextField.setText(String.valueOf(carLoanConstants.getCarPrice()));
				}else if (!carPriceFormattedTextField.getText().matches(decnumberregex)) {
					carPriceValidator.setText("Please enter the number in 0.00 format");
					carPriceFormattedTextField.setText("0.0");
				}
				if (e.getModifiers() > 0) {
					carPriceFormattedTextField.transferFocusBackward();
				} else {
					carPriceFormattedTextField.transferFocus();
					// btnAddToTable.transferFocusUpCycle();
				}

			}
			// interestRateFormatted test
			else if (e.getSource().equals(interestRateFormattedTextField)) {

				if (interestRateFormattedTextField.getText().isEmpty()) {
					try {
						carLoanCalculator.calculateInterestRate();
					} catch (CarLoanException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					interestRateFormattedTextField.setText(String.valueOf(carLoanConstants.getInterestRate()));
				}else if (!interestRateFormattedTextField.getText().matches(decnumberregex)) {
					interestRateValidator.setText("Please enter the number in 0.00 format");
					interestRateFormattedTextField.setText("0.0");
				}
				if (e.getModifiers() > 0) {
					interestRateFormattedTextField.transferFocusBackward();
				} else {
					interestRateFormattedTextField.transferFocus();
					// btnAddToTable.transferFocusUpCycle();
				}
			} else if (e.getSource().equals(tradeInFormattedTextField)) {
				if (tradeInFormattedTextField.getText().isEmpty()) {
					try {
						carLoanCalculator.calculateTradeInValue();
					} catch (CarLoanException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					tradeInFormattedTextField.setText(String.valueOf(carLoanConstants.getTradeInValue()));
				}else if (!tradeInFormattedTextField.getText().matches(decnumberregex)) {
					tradeInValidator.setText("Please enter the number in 0.00 format");
					tradeInFormattedTextField.setText("0.0");
				}
				if (e.getModifiers() > 0) {
					tradeInFormattedTextField.transferFocusBackward();
				} else {
					tradeInFormattedTextField.transferFocus();
				}
			} // number of months calculation
			else if (e.getSource().equals(numberOfMonthsFormattedTextField)) {

				if (numberOfMonthsFormattedTextField.getText().isEmpty()) {
					try {
						carLoanCalculator.calculateNumberOfMonths();
					} catch (CarLoanException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					numberOfMonthsFormattedTextField.setText(String.valueOf(carLoanConstants.getNumberOfMonths()));
				}else if (!numberOfMonthsFormattedTextField.getText().matches(numberregex)) {
					monthsValidator.setText("Number of months should be between 1 & 84");
					numberOfMonthsFormattedTextField.setText("1");
				} else if (Integer.valueOf(numberOfMonthsFormattedTextField.getText()) > 84
						|| Integer.valueOf(numberOfMonthsFormattedTextField.getText()) < 1) {
					monthsValidator.setText("Number of months should be between 1 & 84");
					numberOfMonthsFormattedTextField.setText("1");

				}
				if (e.getModifiers() > 0) {
					numberOfMonthsFormattedTextField.transferFocusBackward();
				} else {
					numberOfMonthsFormattedTextField.transferFocus();
					// btnAddToTable.transferFocusUpCycle();
				}
			} else if (e.getSource().equals(btnAddToTable)) {
				if (btnAddToTable.getText().isEmpty()) {
					btnAddToTable.setText("0.0");
				}
				if (e.getModifiers() > 0) {
					btnAddToTable.transferFocusBackward();
				} else {
					btnAddToTable.transferFocus();
					// btnAddToTable.transferFocusUpCycle();
				}
			}
			e.consume();
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}
