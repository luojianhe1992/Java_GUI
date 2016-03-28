package test_15;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JSliderDemo extends JFrame{
	
	private JSlider jSlider;
	private JLabel label;
	
	public JSliderDemo() {
		setLayout(new FlowLayout());
		
		jSlider = new JSlider(JSlider.HORIZONTAL, 0, 20, 0);
		jSlider.setMajorTickSpacing(5);
		jSlider.setPaintTicks(true);
		add(jSlider);

		label = new JLabel("Current value: 0");
		add(label);
		
		Handler handler = new Handler();
		jSlider.addChangeListener(handler);
		
	}
	
	private class Handler implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent event) {
			int value = jSlider.getValue();
			label.setText("Current value: " + value);
		}
	}
	
	public static void main(String[] args) {
		JSliderDemo jSliderDemo = new JSliderDemo();
		jSliderDemo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jSliderDemo.setSize(400, 300);
		jSliderDemo.setVisible(true);
		jSliderDemo.setTitle("The title");
	}
}
