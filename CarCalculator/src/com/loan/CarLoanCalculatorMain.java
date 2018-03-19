package com.loan;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

//import swing.LanguagesUI;

public class CarLoanCalculatorMain {

	public static void main(String[] args) {
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
		JFrame jframe = new SwingControlDemo();
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setTitle("Car Payment Calculator");
		jframe.setPreferredSize(new Dimension(900, 800));
		jframe.pack();
		jframe.setLocationRelativeTo(null);
		jframe.setVisible(true);
	}



}

