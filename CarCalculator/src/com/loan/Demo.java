package com.loan;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.*;
import java.awt.event.*;
 
public class Demo{
     
    static JFrame window;
    static JPanel p;
    static JLabel label1, label2;
    static JTextField JTextField1, JTextField2;
    static JButton b;
    static JTextArea textArea;
    static JScrollPane scrollPane;
    static ButtonHandler handler;
     
    public static void main(String args[])
    {
        window = new JFrame(); // create window
        p = new JPanel();
         
         //Create the first label.
        label1 = new JLabel("Loan Amount", JLabel.LEFT);
        p.add( label1);
         
        //Set the position of its text, relative to its icon:
        label1.setVerticalTextPosition(JLabel.BOTTOM);
        label1.setHorizontalTextPosition(JLabel.LEFT);
         
        // construct textfield with 10 columns
        JTextField1 = new JTextField( 10 );
        p.add( JTextField1 );
         
        //Create the other labels.
        label2 = new JLabel("Number of Years");
        p.add(label2);
         
        // construct textfield with default text
        JTextField2 = new JTextField(3);
        p.add( JTextField2 );
         
        label1.setToolTipText("A label containing both image and text");
        label2.setToolTipText("A label containing only text");
         
        b = new JButton("Show Table" );
        p.add(b);
         
        textArea = new JTextArea(20, 40);
        textArea.setEditable(false);
        scrollPane = new JScrollPane(textArea);
        p.add( scrollPane );
         
        // create new ButtonHandler for button event handling
        handler = new ButtonHandler();
        b.addActionListener( handler );
         
        window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        window.add(p);
        window.setSize( 520, 360); // set frame size
        window.setVisible( true ); // display frame 
    } // end main
     
    // inner class for button event handling
    private static class ButtonHandler implements ActionListener
    {
        // handle button event
        public void actionPerformed( ActionEvent event )
        {
        String temploan = JTextField1.getText();
        double principle;
        int lifeofloan;
        textArea.setText(temploan );
        }
    }   
} // end class TestCal
