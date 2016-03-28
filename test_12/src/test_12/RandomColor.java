package test_12;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class RandomColor extends JFrame{

	private JPanel panel;
	
	public RandomColor() {
		setLayout(new FlowLayout());
		
		panel = new JPanel();
		panel.setBackground(randomColor());
		add(panel);
		
		Handler handler = new Handler();
		panel.addMouseListener(handler);
		
	}
	
	private class Handler implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			panel.setBackground(randomColor());
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	private Color randomColor(){
		int red = (int)(Math.random() * 256);
		int green = (int)(Math.random() * 256);
		int blue = (int)(Math.random() * 256);
		return new Color(red, green, blue);
	}
	
	
	public static void main(String[] args) {
		RandomColor randomColor = new RandomColor();
		randomColor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		randomColor.setSize(300, 300);
		randomColor.setVisible(true);
		randomColor.setTitle("The title");
	}
}
