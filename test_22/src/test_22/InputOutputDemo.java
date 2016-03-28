package test_22;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class InputOutputDemo extends JFrame{
	
	private JLabel promptLabel, resultLabel;
	private JTextField textField;
	private JButton button;
	
	public InputOutputDemo() {
		setLayout(new FlowLayout());
		
		promptLabel = new JLabel("Enter text to write to file.");
		add(promptLabel);
		
		textField = new JTextField(10);
		add(textField);
		
		button = new JButton("Write to file");
		add(button);
		
		resultLabel = new JLabel("", SwingConstants.CENTER);
		add(resultLabel);

		try {
			
			BufferedReader bufferedReader = new BufferedReader(new FileReader("newFile.txt"));
			String line;
			String result = "";
			
			while ((line = bufferedReader.readLine()) != null) {
				result = result + line;
			}
			resultLabel.setText(result);
			bufferedReader.close();
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
		
		Handler handler = new Handler();
		button.addActionListener(handler);
		
	}
	
	private class Handler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				
				String words = textField.getText();
				FileWriter fileWriter = new FileWriter("newFile.txt", true);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				bufferedWriter.write(words);
				bufferedWriter.close();
				
				textField.setText("");
				
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
			
			try {
				
				BufferedReader bufferedReader = new BufferedReader(new FileReader("newFile.txt"));
				String line;
				String result = "";
				
				while ((line = bufferedReader.readLine()) != null) {
					result = result + line;
				}
				resultLabel.setText(result);
				bufferedReader.close();
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		InputOutputDemo inputOutputDemo = new InputOutputDemo();
		inputOutputDemo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inputOutputDemo.setSize(300, 300);
		inputOutputDemo.setVisible(true);
		inputOutputDemo.setTitle("The title");
	}
}
