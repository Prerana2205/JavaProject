package com.loan;

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
			@Override
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



}

