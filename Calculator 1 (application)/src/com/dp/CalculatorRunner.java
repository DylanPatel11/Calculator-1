package com.dp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class CalculatorRunner implements ActionListener{
	
	// buttons 
	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[9];
	JButton addButton, subButton, multButton, divButton;
	JButton deciButton, equButton, delButton, clrButton, negButton;
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
		
		//Answer field added to app
		textfield = new JTextField();
		textfield.setBounds(50, 25, 300, 50);
		textfield.setFont(myFont);
		textfield.setEditable(false); //makes textfield not editable
		
		// 
		//buttons added to app
		addButton = new JButton("+");
		subButton = new JButton("-");
		divButton = new JButton("/");
		multButton = new JButton("*");
		equButton = new JButton("=");
		clrButton = new JButton("c");
		delButton = new JButton("del");
		deciButton = new JButton(".");
		negButton = new JButton("(-)");
		
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = divButton;
		functionButtons[3] = multButton;
		functionButtons[4] = equButton;
		functionButtons[5] = clrButton;
		functionButtons[6] = delButton;
		functionButtons[7] = deciButton;
		functionButtons[8] = negButton;

		//for loop loop 8 times (remember i++ increment by 1) for fucntion buttons
		for(int i =0;i<9;i++) {
			functionButtons[i].addActionListener(this); //action listeners are for the clicks of buttons
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false); // for no outline on button
		}
		// number buttons
		for(int i =0;i<10;i++) {
			numberButtons[i] = new JButton(String.valueOf(i)); //creating a new button for each number
			numberButtons[i].addActionListener(this); //action listeners are for the clicks of buttons
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false); // for no outline on button
		}

		// del, negative, clr button bounds
		negButton.setBounds(50, 430, 100, 50);
		delButton.setBounds(150, 430, 100, 50);
		clrButton.setBounds(250, 430, 100, 50);
		
		// panel for buttons set
		panel =new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4,4,10,10));
		//panel.setBackground(Color.GRAY);
		
		//adding buttons to panel no function
		
		
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(multButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(deciButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(divButton);
		
		
		

		
		// add to app so can see when run
		frame.add(panel);
		frame.add(negButton);
		frame.add(clrButton);
		frame.add(delButton);
		frame.add(textfield); // add textfield where answer is shown
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		CalculatorRunner calc = new CalculatorRunner();
		

	}

	// add function to buttons
	@Override
	public void actionPerformed(ActionEvent e) {
		// number buttons
		for(int i=0;i<10;i++) {
				if(e.getSource() == numberButtons[i]) {
					textfield.setText(textfield.getText().concat(String.valueOf(i)));
				}
		}
		//decimal button
		if(e.getSource() == deciButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		//operator buttons
		if(e.getSource() == addButton) {
			num1 =Double.parseDouble(textfield.getText());
			operator = '+';
			textfield.setText("");
		}
		if(e.getSource() == subButton) {
			num1 =Double.parseDouble(textfield.getText());
			operator = '-';
			textfield.setText("");
		}
		if(e.getSource() == multButton) {
			num1 =Double.parseDouble(textfield.getText());
			operator = '*';
			textfield.setText("");
		}
		if(e.getSource() == divButton) {
			num1 =Double.parseDouble(textfield.getText());
			operator = '/';
			textfield.setText("");
		}
		//equals button
		if(e.getSource() == equButton) {
			num2 =Double.parseDouble(textfield.getText());
			
			switch(operator) {
			case'+':
				ans = num1+num2;
				break;
			case'-':
				ans = num1-num2;
				break;
			case'*':
				ans = num1*num2;
				break;
			case'/':
				ans = num1/num2;
				break;
		}
		//update textfield
		textfield.setText(String.valueOf(ans));
		num1 = ans;
		}
		//clear button
		if(e.getSource()==clrButton) {
			textfield.setText("");
		}
		//delete button
		if(e.getSource()==delButton) {
			String string = textfield.getText();
			textfield.setText("");
			for(int i=0; i<string.length()-1 ;i++) {
				textfield.setText(textfield.getText()+string.charAt(i));
			}
		}
		//negative button
		if(e.getSource()==negButton) {
			double temp = Double.parseDouble(textfield.getText());
			temp*=-1;
			textfield.setText(String.valueOf(temp));
			}
		
		
	}

}
