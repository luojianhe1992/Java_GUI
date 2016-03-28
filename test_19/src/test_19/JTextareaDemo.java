package test_19;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class JTextareaDemo extends JFrame{
	
	private JTextArea textArea;
	private JButton button;
	private JLabel label;
	
	
	public JTextareaDemo() {
		setLayout(new FlowLayout());
		
		textArea = new JTextArea(5, 30);
		add(textArea);
		
		button = new JButton("Click here to put text into label.");
		add(button);
		
		label = new JLabel("");
		add(label);
		
		Handler handler = new Handler();
		button.addActionListener(handler);
		
	}
	
	private class Handler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String text = textArea.getText();
			
			if (text.equals("")) {
				label.setText("Please enter some text.");
			}
			else{
				label.setText(text);
			}
			
		}
		
	}
	
	
	public static void main(String[] args) {
		JTextareaDemo jTextareaDemo = new JTextareaDemo();
		jTextareaDemo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jTextareaDemo.setSize(300, 300);
		jTextareaDemo.setVisible(true);
		jTextareaDemo.setTitle("The title");
	}
}
