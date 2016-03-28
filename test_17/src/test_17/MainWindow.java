package test_17;

import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainWindow extends JFrame{

	private JMenuBar jMenuBar;
	private JMenu jMenu;
	private JMenuItem jMenuItem;
	
	public MainWindow() {
		setLayout(new FlowLayout());
		
		jMenuBar = new JMenuBar();
		setJMenuBar(jMenuBar);

		
		jMenu = new JMenu("Help");
		jMenuBar.add(jMenu);
		
		jMenuItem = new JMenuItem("About");
		jMenu.add(jMenuItem);
		
		
		Handler handler = new Handler();
		jMenuItem.addActionListener(handler);
	}
	
	private class Handler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			HelpWindow helpWindow = new HelpWindow(MainWindow.this);
			
			// setDefaultCloseOperation to be JFrame.HIDE_ON_CLOSE
			helpWindow.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			helpWindow.setSize(200, 200);
			helpWindow.setVisible(true);
			helpWindow.setLocation(110, 110);
		}
	}
	
	public static void main(String[] args) {
		MainWindow mainWindow = new MainWindow();
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindow.setSize(300, 300);
		mainWindow.setVisible(true);
		mainWindow.setTitle("Main Window");
	}	
}