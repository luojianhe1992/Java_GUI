package test_3;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ImageTutorial extends JFrame{
	
	private JLabel label1;
	private ImageIcon image1;
	private JLabel label2;
	private ImageIcon image2;
	
	public ImageTutorial() {
		setLayout(new FlowLayout());
		
		image1 = new ImageIcon(getClass().getResource("firefox.png"));
		label1 = new JLabel(image1);
		add(label1);
		
		image2 = new ImageIcon(getClass().getResource("android.png"));
		label2 = new JLabel(image2);
		add(label2);
	}
	
	public static void main(String[] args) {
		ImageTutorial imageTutorial = new ImageTutorial();
		imageTutorial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		imageTutorial.setSize(300, 300);
		imageTutorial.setVisible(true);
		imageTutorial.setTitle("The title");
	}
}
