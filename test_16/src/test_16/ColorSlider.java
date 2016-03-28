package test_16;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ColorSlider extends JFrame{

	JSlider redSlider, greenSlider, blueSlider;
	JLabel redLabel, greenLabel, blueLabel;
	JPanel colorPanel, sliderPanel, labelPanel;
	
	public ColorSlider() {
		
		redSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
		greenSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
		blueSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);

		redLabel = new JLabel("Red = 0");
		greenLabel = new JLabel("Green = 0");
		blueLabel = new JLabel("Blue = 0");

		Handler handler = new Handler();
		redSlider.addChangeListener(handler);
		greenSlider.addChangeListener(handler);
		blueSlider.addChangeListener(handler);
		
		colorPanel = new JPanel();
		// set default color to be black
		colorPanel.setBackground(Color.BLACK);
		
		/*
		 * Using Container object to control the layout
		 */
		
		// create a new Container object
		Container container = this.getContentPane();
		container.setLayout(new GridLayout(1, 3, 3, 3));

		sliderPanel = new JPanel();
		labelPanel = new JPanel();
		
		container.add(sliderPanel);
		container.add(labelPanel);
		container.add(colorPanel);
		
		/*
		 * Using JPanel to control the layout
		 */
		
		sliderPanel.setLayout(new GridLayout(3, 1, 2, 2));
		sliderPanel.add(redSlider);
		sliderPanel.add(greenSlider);
		sliderPanel.add(blueSlider);
		
		labelPanel.setLayout(new GridLayout(3, 1, 2, 2));
		labelPanel.add(redLabel);
		labelPanel.add(greenLabel);
		labelPanel.add(blueLabel);
	}
	
	private class Handler implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {
			int red = redSlider.getValue();
			int green = greenSlider.getValue();
			int blue = blueSlider.getValue();
			
			redLabel.setText("Red = " + red);
			greenLabel.setText("Green = " + green);
			blueLabel.setText("Blue = " + blue);
			
			colorPanel.setBackground(new Color(red, green, blue));
		}
		
	}
	
	public static void main(String[] args) {
		ColorSlider colorSlider = new ColorSlider();
		colorSlider.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		colorSlider.setSize(300, 300);
		colorSlider.setVisible(true);
		colorSlider.setTitle("The title");
	}
}
