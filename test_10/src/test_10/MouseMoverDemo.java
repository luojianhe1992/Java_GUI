package test_10;

import java.awt.AWTException;
import java.awt.GridLayout;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MouseMoverDemo extends JFrame{
	
	private JLabel label1, label2, label3, label4;
	private JLabel errorLabel;
	private JTextField textField1, textField2, textField3, textField4;
	private JButton button;
	
	public MouseMoverDemo() {
		setLayout(new GridLayout(5, 2, 5, 5));
		
		label1 = new JLabel("Enter number of movements: ");
		add(label1);
		
		textField1 = new JTextField();
		add(textField1);
		
		label2 = new JLabel("Enter delay between movements: ");
		add(label2);
		
		textField2 = new JTextField();
		add(textField2);
		
		label3 = new JLabel("Enter screen width in pixels: ");
		add(label3);
		
		textField3 = new JTextField();
		add(textField3);
		
		label4 = new JLabel("Enter screen height in pixels: ");
		add(label4);
		
		textField4 = new JTextField();
		add(textField4);
		
		button = new JButton("Start");
		add(button);
		
		Handler handler = new Handler();
		button.addActionListener(handler);
		
		errorLabel = new JLabel("");
		add(errorLabel);

	}
	
	
	private class Handler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				
				int num = Integer.parseInt(textField1.getText());
				int delay = Integer.parseInt(textField2.getText());
				int width = Integer.parseInt(textField3.getText());
				int height = Integer.parseInt(textField4.getText());
				
				if (num <= 0 || delay <= 0 || width <= 0 || height <= 0) {
					errorLabel.setText("Please enter positive value.");
				}
				else{
					errorLabel.setText("");
				
					try {
						
						Robot robot = new Robot();
						for(int x = 0; x < num; x++){
							robot.mouseMove((int)(Math.random() * width),
											(int)(Math.random() * height));
							robot.delay(delay);
						}
					} catch (AWTException awtException) {
						awtException.printStackTrace();
						System.exit(0);
					}
				}
			} catch (Exception exception) {
				exception.printStackTrace();
				errorLabel.setText("Please enter number only.");
			}
		}
	}
	
	public static void main(String[] args) {
		MouseMoverDemo mouseMoverDemo = new MouseMoverDemo();
		mouseMoverDemo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mouseMoverDemo.setSize(300, 300);
		mouseMoverDemo.setVisible(true);
		mouseMoverDemo.setTitle("The title");
	}
}
