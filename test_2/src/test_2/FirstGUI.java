package test_2;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FirstGUI extends JFrame{
	
	private JLabel label;
	private JButton button;
	private JTextField textField;
	
	public FirstGUI() {
		setLayout(new FlowLayout());
		
		label = new JLabel("Hi, I am a label.");
		add(label);
		
		textField = new JTextField("Hi, I am a text field.", 15);
		add(textField);
		
		button = new JButton("Hi, I am a button.");
		add(button);
		
	}
	
	
	public static void main(String[] args) {
		
		FirstGUI firstGUI = new FirstGUI();
		firstGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		firstGUI.setTitle("The title");
		firstGUI.setSize(200, 200);
		firstGUI.setVisible(true);
		
	}
	
}
