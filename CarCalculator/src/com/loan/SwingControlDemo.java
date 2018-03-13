package com.loan;

import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.NumberFormat;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.text.NumberFormatter;

//import swing.LanguagesUI;

@SuppressWarnings("serial")
public class SwingControlDemo extends javax.swing.JFrame implements PropertyChangeListener {
	public SwingControlDemo() {
		prepareGUI();
	}
	private double carPrice = 100000;
    private double rate = 7.5;  //7.5%
    private int numPeriods = 30;
    private double tradeInValue=0.0;
    
    private JFormattedTextField carPriceFormattedTextField;
    private JFormattedTextField tradeInFormattedTextField;
    private JFormattedTextField interestRateFormattedTextField;
    private JFormattedTextField numberOfMonthsFormattedTextField;
    private JFormattedTextField lblOutput ;
    
	private void prepareGUI() {
		
		getContentPane().setBackground(Color.WHITE);
		setTitle("Car Payment Calculator");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("What's your credit score?");
		lblNewLabel.setBounds(12, 23, 301, 16);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Car price ($)");
		lblNewLabel_1.setBounds(12, 157, 186, 16);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblTradeinDown = new JLabel("Trade-in / down payment ($)");
		lblTradeinDown.setBounds(12, 273, 186, 16);
		getContentPane().add(lblTradeinDown);
		
		JLabel lblInterestRate = new JLabel("Interest rate (%)");
		lblInterestRate.setBounds(12, 354, 186, 16);
		getContentPane().add(lblInterestRate);
		
		JLabel lblNumberOfMonths = new JLabel("Number of months");
		lblNumberOfMonths.setBounds(12, 418, 186, 16);
		getContentPane().add(lblNumberOfMonths);

		JTextArea creditScoreLabel2 = new JTextArea();
		creditScoreLabel2.setLineWrap(true);
		creditScoreLabel2.setEditable(false);
		creditScoreLabel2.setBounds(12, 78, 159, 54);
		getContentPane().add(creditScoreLabel2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(12, 43, 159, 22);
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
				}else if (comboBox.getSelectedItem().toString().toLowerCase().contains("501")) {
					creditScoreLabel2.setText("Based on your score, the average rate is 11% (new) or 16.3% (used).");
				}else
					creditScoreLabel2.setText("Based on your score, the average rate is 13.8% (new) or 19.3% (used). "
							+ "Consider buying an inexpensive used car and refinancing in 6-12 months.");
			}
		});
		
		
	  //  formatter.setAllowsInvalid(false);
	    // If you want the value to be committed on each keystroke instead of focus lost
	 //   formatter.setCommitsOnValidEdit(true);
	    
	    carPriceFormattedTextField = new JFormattedTextField(carPriceFormat);
	    carPriceFormattedTextField.setBounds(12, 183, 134, 22);
		getContentPane().add(carPriceFormattedTextField);
		carPriceFormattedTextField.setValue(new Double(carPrice));
		carPriceFormattedTextField.addPropertyChangeListener("value", this);
		
		tradeInFormattedTextField = new JFormattedTextField(carPriceFormat);
		tradeInFormattedTextField.setBounds(12, 297, 134, 22);
		getContentPane().add(tradeInFormattedTextField);
		
		interestRateFormattedTextField = new JFormattedTextField(interestRateFormat);
		interestRateFormattedTextField.setBounds(12, 372, 134, 22);
		getContentPane().add(interestRateFormattedTextField);
		
		numberOfMonthsFormattedTextField = new JFormattedTextField(numberMonthsFormat);
		numberOfMonthsFormattedTextField.setBounds(12, 441, 134, 22);
		getContentPane().add(numberOfMonthsFormattedTextField);
		
		JLabel lblAfterNegotiations = new JLabel("After negotiations");
		lblAfterNegotiations.setBounds(12, 207, 116, 16);
		getContentPane().add(lblAfterNegotiations);
		
		JLabel lblYourTradeinCan = new JLabel("Your trade-in can be all or part of a down payment");
		lblYourTradeinCan.setBounds(12, 322, 301, 16);
		getContentPane().add(lblYourTradeinCan);
		
		JLabel lblAHigherCredit = new JLabel("A higher credit score means lower interest rates");
		lblAHigherCredit.setBounds(12, 398, 301, 16);
		getContentPane().add(lblAHigherCredit);
		
		JLabel lblSuggestedMax = new JLabel("Suggested max: 36 months for used cars, 60 for new");
		lblSuggestedMax.setBounds(12, 476, 361, 16);
		getContentPane().add(lblSuggestedMax);
		
		JLabel lblNewLabel_2 = new JLabel("Payment Details");
		lblNewLabel_2.setBounds(454, 23, 124, 16);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblMonthlyPayment = new JLabel("Monthly Payment ");
		lblMonthlyPayment.setBounds(454, 46, 124, 16);
		getContentPane().add(lblMonthlyPayment);
		
		JLabel lblBeforeTaxesAnd = new JLabel("(Before taxes and fees)");
		lblBeforeTaxesAnd.setBounds(454, 81, 208, 16);
		getContentPane().add(lblBeforeTaxesAnd);
		
		JLabel lblTotal = new JLabel("Total amount paid");
		lblTotal.setBounds(454, 128, 111, 16);
		getContentPane().add(lblTotal);
		
		JLabel lblTotalInterestPaid = new JLabel("Total interest paid");
		lblTotalInterestPaid.setBounds(467, 233, 111, 16);
		getContentPane().add(lblTotalInterestPaid);
		
		JLabel lblNewLabel_3 = new JLabel("(Over the life of the loan)");
		lblNewLabel_3.setBounds(467, 207, 159, 16);
		getContentPane().add(lblNewLabel_3);
		
		
		
		JLabel label = new JLabel("output");
		label.setBounds(464, 157, 56, 16);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("output");
		label_1.setBounds(467, 253, 56, 16);
		getContentPane().add(label_1);
		
		

		
		/*JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarLoanConstants constants = new CarLoanConstants();
				//constants.setCarPrice(carPriceFormattedTextField.getValue());
				constants.setInterestRate(Double.parseDouble(tradeInFormattedTextField.getText()));
				constants.setTradeInValue(Double.parseDouble(interestRateFormattedTextField.getText()));
				constants.setNumberOfMonths(Integer.parseInt(numberOfMonthsFormattedTextField.getText()));
				
				CarLoanCalculator clc = new CarLoanCalculator();
				double monthlyPayment = clc.calculateMonthlyPayment(constants); 
				lblOutput.setText(Double.toString(monthlyPayment));
			}
		});
		btnCalculate.setBounds(267, 217, 97, 25);
		getContentPane().add(btnCalculate);*/
		
		lblOutput = new JFormattedTextField();
		lblOutput.setBounds(464, 62, 70, 22);
		getContentPane().add(lblOutput);
	}

	@Override
	public void propertyChange(PropertyChangeEvent e) {
		// TODO Auto-generated method stub
		  Object source = e.getSource();
	        if (source == carPriceFormattedTextField) {
	            carPrice = ((Number)carPriceFormattedTextField.getValue()).doubleValue();
	        } else if (source == interestRateFormattedTextField) {
	            rate = ((Number)interestRateFormattedTextField.getValue()).doubleValue();
	        } else if (source == numberOfMonthsFormattedTextField) {
	            numPeriods = ((Number)numberOfMonthsFormattedTextField.getValue()).intValue();
	        }else if(source ==tradeInFormattedTextField){
	        	tradeInValue = ((Number)tradeInFormattedTextField.getValue()).intValue();
	        }
	        CarLoanCalculator clc = new CarLoanCalculator();
	        CarLoanConstants constants = new CarLoanConstants();
			constants.setCarPrice(carPrice);
			constants.setInterestRate(rate);
			constants.setTradeInValue(tradeInValue);
			constants.setNumberOfMonths(numPeriods);
			
	        double payment = clc.calculateMonthlyPayment(constants);
	        lblOutput.setValue(new Double(payment));
	}
	
	//Formatting the fields input and output
		private NumberFormat carPriceFormat;
		private NumberFormat interestRateFormat;
		private NumberFormat paymentsFormat;
		private NumberFormat numberMonthsFormat;
		public void setFormat() {
			carPriceFormat = NumberFormat.getNumberInstance();
			interestRateFormat = NumberFormat.getNumberInstance();
			interestRateFormat.setMinimumFractionDigits(3);
			paymentsFormat = NumberFormat.getCurrencyInstance();
			numberMonthsFormat = NumberFormat.getNumberInstance();
			numberMonthsFormat.setParseIntegerOnly(true);
			numberMonthsFormat.setMinimumIntegerDigits(1);
			numberMonthsFormat.setMaximumIntegerDigits(Integer.MAX_VALUE);
			
			//NumberFormat format = NumberFormat.getInstance();
		//    NumberFormatter intFormat = new NumberFormatter(format);
		  
		}
}
