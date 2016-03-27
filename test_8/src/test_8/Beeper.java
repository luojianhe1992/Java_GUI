package test_8;

import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Beeper extends JFrame{
	private JButton button;
	private JLabel label;
	private int counter = 0;
	private boolean checkPlural = false;
	private String str;
	
	public Beeper() {
		setLayout(new FlowLayout());
		
		button = new JButton("Click for sound");
		add(button);
		
		Handler handler = new Handler();
		button.addActionListener(handler);
		
		label = new JLabel("0");
		add(label);
		
	}
	
	private class Handler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			
			// using Toolkit to call the beep function.
			Toolkit.getDefaultToolkit().beep();
			counter++;
			
			if (!checkPlural) {
				str = "time";
			}
			else{
				str = "times";
			}
			
			label.setText("You have clicked " + counter + " " + str);
			checkPlural = true;
		}
	}
	
	public static void main(String[] args) {
		Beeper beeper = new Beeper();
		beeper.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		beeper.setSize(300, 300);
		beeper.setVisible(true);
		beeper.setTitle("The title");
	}
}