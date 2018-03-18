package com.loan;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

//import swing.LanguagesUI;

public class CarLoanCalculatorMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// CreditScoreConstants constant = CreditScoreConstants.SUPERPRIME;
		// System.out.println(constant.getKey());
		// System.out.println(constant.getValue());
		SwingUtilities.invokeLater(new Runnable()
	    {
	      public void run()
	      {
	        displayJFrame();
	      }
	    });
	  }

	  static void displayJFrame()
	  {
	    // create our jframe as usual
	    JFrame jframe = new SwingControlDemo();
	    jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    jframe.setTitle("Car Payment Calculator");
	    // set the jframe size and location, and make it visible
	    jframe.setPreferredSize(new Dimension(1400, 800));
	    jframe.pack();
	    jframe.setLocationRelativeTo(null);
	    jframe.setVisible(true);
	  }
		
		
		/*javax.swing.SwingUtilities.invokeLater(new Runnable(){
			  public void run(){
		JFrame frame = new SwingControlDemo();
		//Container contentPane = frame.getContentPane();
		frame.setTitle("Car Payment Calculator");
		frame.setSize(2000, 2000);
		// frame.setBounds(100, 100, 300, 400);
		
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			  }});*/
		/*
		 * CarLoanConstants cc =new CarLoanConstants(); cc.setCarPrice(20000);
		 * cc.setTradeInValue(4000); cc.setInterestRate(4.5);
		 * //cc.setMonthlyPayment(444.44); cc.setNumberOfMonths(36);
		 * CarLoanCalculator c = new CarLoanCalculator();
		 * c.calculateMonthlyPayment(cc); //c.calculateTotalAmountPaid();
		 * //c.calculateTotalInterestPaid(); //c.calculateNumberOfMonths(cc);
		 * //c.calculateCarPrice(cc); //c.createAmortizationTable(cc);
		 * //c.calculateInterestRate(cc); c.buildModel(37);
		 */
	}

