package test_11;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Calculator extends JFrame{
	
	private JButton add, subtract, multiply, divide;
	private JTextField num1, num2;
	JLabel result, enter1, enter2;
	
	public Calculator() {
		setLayout(new GridBagLayout());
		GridBagConstraints bagConstraints = new GridBagConstraints();
		
		enter1 = new JLabel("First: ");
		bagConstraints.fill = GridBagConstraints.HORIZONTAL;
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 0;
		add(enter1, bagConstraints);
		
		num1 = new JTextField();
		bagConstraints.fill = GridBagConstraints.HORIZONTAL;
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 0;
		bagConstraints.gridwidth = 3;
		add(num1, bagConstraints);
		
		enter2 = new JLabel("Second: ");
		bagConstraints.fill = GridBagConstraints.HORIZONTAL;
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 1;
		// reset the gridwidth
		bagConstraints.gridwidth = 1;
		add(enter2, bagConstraints);
		
		num2 = new JTextField();
		bagConstraints.fill = GridBagConstraints.HORIZONTAL;
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 1;
		bagConstraints.gridwidth = 3;
		add(num2, bagConstraints);
		
		add = new JButton("+");
		bagConstraints.fill = GridBagConstraints.HORIZONTAL;
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 2;
		bagConstraints.gridwidth = 1;
		add(add, bagConstraints);
		
		subtract = new JButton("-");
		bagConstraints.fill = GridBagConstraints.HORIZONTAL;
		bagConstraints.gridx = 1;
		bagConstraints.gridy = 2;
		add(subtract, bagConstraints);
		
		multiply = new JButton("*");
		bagConstraints.fill = GridBagConstraints.HORIZONTAL;
		bagConstraints.gridx = 2;
		bagConstraints.gridy = 2;
		add(multiply, bagConstraints);
		
		divide = new JButton("/");
		bagConstraints.fill = GridBagConstraints.HORIZONTAL;
		bagConstraints.gridx = 3;
		bagConstraints.gridy = 2;
		add(divide, bagConstraints);

		result = new JLabel("");
		bagConstraints.fill = GridBagConstraints.HORIZONTAL;
		bagConstraints.gridx = 0;
		bagConstraints.gridy = 4;
		bagConstraints.gridwidth = 4;
		add(result, bagConstraints);
		
		Handler handler = new Handler();
		add.addActionListener(handler);
		subtract.addActionListener(handler);
		multiply.addActionListener(handler);
		divide.addActionListener(handler);
		
	}
	
	private class Handler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {
			
			result.setForeground(Color.BLACK);
			
			double number1, number2;
			try {
				number1 = Double.parseDouble(num1.getText());
				number2 = Double.parseDouble(num2.getText());
				
				String operator = event.getActionCommand();
				
				double numResult;
				
				try {
					switch (operator) {
					case "+":
						numResult = number1 + number2;
						System.out.println(numResult);
						result.setText(number1 + " + " + number2 + " = " + numResult);
						break;
					case "-":
						numResult = number1 - number2;
						result.setText(number1 + " - " + number2 + " = " + numResult);
						break;
					case "*":
						numResult = number1 * number2;
						result.setText(number1 + " * " + number2 + " = " + numResult);
						break;
					case "/":
						numResult = number1 / number2;
						result.setText(number1 + " / " + number2 + " = " + numResult);
						break;
					default:
						break;
					}
				} catch (ArithmeticException arithmeticException) {
					arithmeticException.printStackTrace();
					result.setText("Illegal arithmetic expression.");
				}
			} catch (NumberFormatException numberFormatException) {
				numberFormatException.printStackTrace();
				result.setText("Illegal data input field.");
				result.setForeground(Color.RED);
			}
		}
	}
	
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calculator.setVisible(true);
		calculator.setSize(300, 300);
		calculator.setTitle("The title");
	}
}
