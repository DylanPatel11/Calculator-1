package com.dp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class CalculatorRunner implements ActionListener{
	
	// buttons 
	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[8];
	JButton addButton, subButton, multButton, divButton;
	JButton deciButton, equButton, delButton, clrButton;
	JPanel panel;
	
	Font myFont = new Font("Veranda", Font.BOLD,30);
	
	double num1=0, num2=0, ans=0;
	char operator;
	

	//constructor
	CalculatorRunner(){
		//application window
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,550);
		frame.setLayout(null);
		
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		CalculatorRunner calc = new CalculatorRunner();
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
