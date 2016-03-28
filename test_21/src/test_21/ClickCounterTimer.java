package test_21;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class ClickCounterTimer extends JFrame{

	private Timer timer;
	private int timerCounter;
	private int clickCounter;
	private JLabel directions, enterTime, clickLabel, timeLeft;
	private JButton startButton, clickButton;
	private JTextField textField;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem reset, exit;
	
	public ClickCounterTimer() {
		
		Container container = this.getContentPane();
		container.setLayout(new GridLayout(3, 1, 2, 2));
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menu = new JMenu("File");
		menuBar.add(menu);
		
		reset = new JMenuItem("Reset");
		menu.add(reset);
		
		exit = new JMenuItem("Exit");
		menu.add(exit);
		
		HandlerReset handlerReset = new HandlerReset();
		reset.addActionListener(handlerReset);
		
		HandlerExit handlerExit = new HandlerExit();
		exit.addActionListener(handlerExit);

		JPanel top = new JPanel();
		top.setLayout(new GridLayout(1, 1));
		container.add(top);
		
		directions = new JLabel("Enter time, press start, press CLIKCER repeatedly",
								SwingConstants.CENTER);
		top.add(directions);
		
		JPanel middle = new JPanel();
		middle.setLayout(new GridLayout(1, 3));
		container.add(middle);
		
		enterTime = new JLabel("Enter time (seconds): ", SwingConstants.CENTER);
		middle.add(enterTime);
		
		textField = new JTextField();
		middle.add(textField);
		
		startButton = new JButton("Start");
		middle.add(startButton);
		
		JPanel bottom = new JPanel();
		bottom.setLayout(new GridLayout(1, 3));
		container.add(bottom);
		
		clickButton = new JButton("CLICKER");
		clickButton.setEnabled(false);
		bottom.add(clickButton);
		
		clickLabel = new JLabel("Clicks: 0", SwingConstants.CENTER);
		bottom.add(clickLabel);
		
		timeLeft = new JLabel("Time left: ?", SwingConstants.CENTER);
		bottom.add(timeLeft);
		
		HandlerStart handlerStart = new HandlerStart();
		startButton.addActionListener(handlerStart);
		
		HandlerClick handlerClick = new HandlerClick();
		clickButton.addActionListener(handlerClick);
		
	}
	
	private class HandlerStart implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				timerCounter = Integer.parseInt(textField.getText());
				
				if (timerCounter <= 0) {
					textField.setText("Positive number only.");
				}
				else{
					timeLeft.setText("Time left: " + timerCounter);
					
					HandlerTimer handlerTimer = new HandlerTimer(timerCounter);
					timer = new Timer(1000, handlerTimer);
					timer.start();
					
					startButton.setEnabled(false);
					clickButton.setEnabled(true);
				}
			} catch (NumberFormatException numberFormatException) {
				numberFormatException.printStackTrace();
				textField.setText("Please type in integer number only.");
			}
		}
	}
	
	private class HandlerClick implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			clickCounter++;
			
			clickLabel.setText("Clicks: " + clickCounter);
		}
	}
	
	private class HandlerTimer implements ActionListener{

		int timerCounter;
		
		public HandlerTimer(int timerCounter) {
			this.timerCounter = timerCounter;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			timerCounter--;
			
			if (timerCounter >= 1) {
				timeLeft.setText("Time left: " + timerCounter);
			}
			else{
				timer.stop();
				timeLeft.setText("Done");
				clickButton.setEnabled(false);
				textField.setEnabled(false);
				Toolkit.getDefaultToolkit().beep();
			}
		}
	}
	
	private class HandlerReset implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			clickButton.setEnabled(false);
			startButton.setEnabled(true);
			
			clickCounter = 0;
			
			clickLabel.setText("Clicks: 0");
			textField.setEnabled(true);
			textField.setText("");
			timeLeft.setText("Time left: ?");
		}
	}
	
	private class HandlerExit implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
	
	public static void main(String[] args) {
		ClickCounterTimer clickCounterTimer = new ClickCounterTimer();
		clickCounterTimer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		clickCounterTimer.setSize(300, 300);
		clickCounterTimer.setVisible(true);
		clickCounterTimer.setTitle("The title");
	}
	
}
