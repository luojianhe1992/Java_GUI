package test_9;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LayoutDemo extends JFrame{
	
	private JButton button1, button2, button3;
	private JLabel label1, label2, label3;
	
	public LayoutDemo() {
		
		setLayout(new GridLayout(2, 3));
		
		button1 = new JButton("Button 1");
		add(button1);
		
		button2 = new JButton("Button 2");
		add(button2);
		
		button3 = new JButton("Button 3");
		add(button3);
		
		label1 = new JLabel("Label 1");
		add(label1);

		label2 = new JLabel("Label 2");
		add(label2);
		
		label3 = new JLabel("Label 3");
		add(label3);
	}
	
	public static void main(String[] args) {
		LayoutDemo layoutDemo = new LayoutDemo();
		layoutDemo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		layoutDemo.setVisible(true);
		// set the JFrame object to be pack
		layoutDemo.pack();
		layoutDemo.setTitle("The title");
		
	}
}
