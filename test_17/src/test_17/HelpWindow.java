package test_17;

import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelpWindow extends JDialog{
	
	private JLabel label;
	
	public HelpWindow(JFrame jFrame) {
		super(jFrame, "Help Window", true);
		setLayout(new FlowLayout());
		
		label = new JLabel("This is help window, what can I help you?");
		add(label);
		
	}
}
