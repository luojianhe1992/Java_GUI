package test_20;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class TimerTutorial extends JFrame{
	
	private JLabel promptLabel, timerLabel;
	private int counter;
	private JTextField textField;
	private JButton button;
	private Timer timer;
	
	public TimerTutorial() {
		
		setLayout(new GridLayout(2, 2, 5, 5));
		
		promptLabel = new JLabel("Enter seconds: ", SwingConstants.CENTER);
		add(promptLabel);
		
		textField = new JTextField(5);
		add(textField);
		
		button = new JButton("Start timing");
		add(button);
		
		timerLabel = new JLabel("Waiting...", SwingConstants.CENTER);
		add(timerLabel);
		
		Handler handler = new Handler();
		button.addActionListener(handler);
			
	}
	
	private class Handler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			try {
				int count = Integer.parseInt(textField.getText());
				
				timerLabel.setText("Time left: " + count);
				
				// create a TimeHandler object to handle time event
				TimerHandler timerHandler = new TimerHandler(count);
				
				// create a Time object
				timer = new Timer(1000, timerHandler);
				timer.start();
			} catch (Exception exception) {
				exception.printStackTrace();
				timerLabel.setText("Please enter a integer number.");
			}
		}
	}
	
	private class TimerHandler implements ActionListener{

		int counter;

		// Constructor function
		public TimerHandler(int counter) {
			this.counter = counter;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			counter--;
			if (counter >= 1) {
				timerLabel.setText("Time left: " + counter);
			}
			else{
				timer.stop();
				timerLabel.setText("Done");
				Toolkit.getDefaultToolkit().beep();
			}
		}
	}
	
	public static void main(String[] args) {
		TimerTutorial timerTutorial = new TimerTutorial();
		timerTutorial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		timerTutorial.setSize(300, 300);
		timerTutorial.setVisible(true);
		timerTutorial.setTitle("The title");
	}
}
