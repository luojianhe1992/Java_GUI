package test_13;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CheckboxDemo extends JFrame{
	
	JCheckBox show1, show2;
	JLabel label1, label2;
	
	public CheckboxDemo() {
		setLayout(new GridLayout(2, 2));

		label1 = new JLabel("");
		add(label1);
		
		label2 = new JLabel("");
		add(label2);
		
		show1 = new JCheckBox("Show label1");
		add(show1);
		
		show2 = new JCheckBox("Show label2");
		add(show2);
		
		Handler handler = new Handler();
		show1.addItemListener(handler);
		show2.addItemListener(handler);
		
	}
	
	private class Handler implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent event) {
			if (show1.isSelected()) {
				label1.setText("You push checkbox1.");
			}
			else{
				label1.setText("");
			}
			
			if (show2.isSelected()) {
				label2.setText("You push checkbox2.");
			}
			else{
				label2.setText("");
			}
		}
	}
	
	public static void main(String[] args) {
		CheckboxDemo checkboxDemo = new CheckboxDemo();
		checkboxDemo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		checkboxDemo.setSize(300, 300);
		checkboxDemo.setVisible(true);
		checkboxDemo.setTitle("The title");
	}
}
