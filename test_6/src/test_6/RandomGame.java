package test_6;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RandomGame extends JFrame{
	
	private int randomNumber;
	private int guess;
	private JButton button;
	private JTextField textField;
	private JLabel promptLabel;
	private JLabel resultLabel;
	private JLabel randomLabel;
	
	public RandomGame() {
		
		setLayout(new FlowLayout());
		
		promptLabel = new JLabel("Enter a random number from 1 to 10: ");
		add(promptLabel);
		
		textField = new JTextField(5);
		add(textField);
		
		button = new JButton("Guess");
		add(button);
		
		Handler handler = new Handler();
		button.addActionListener(handler);
		
		resultLabel = new JLabel("");
		add(resultLabel);
		
		randomLabel = new JLabel("");
		add(randomLabel);
	}
	
	private class Handler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			randomNumber = (int)(Math.random() * 10 + 1);
			try {
				guess = Integer.parseInt(textField.getText());
				
				if (guess == randomNumber) {
					resultLabel.setText("You won the game.");
				}
				else{
					resultLabel.setText("You lost the game.");
				}
				randomLabel.setText("The random number is: " + randomNumber + ".");
				
			} catch (Exception exception) {
				exception.printStackTrace();
				randomLabel.setText("Please enter an integer number only.");
			}
		}
	}
	
	public static void main(String[] args) {
		RandomGame randomGame = new RandomGame();
		randomGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		randomGame.setSize(300, 300);
		randomGame.setVisible(true);
		randomGame.setTitle("The title");
	}
}
