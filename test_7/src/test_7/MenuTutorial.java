package test_7;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuTutorial extends JFrame{
	
	private JMenuBar jMenuBar;	
	private JMenu jMenu;
	private JMenuItem jMenuItem;
	
	public MenuTutorial() {
		setLayout(new FlowLayout());
		
		
		jMenuBar = new JMenuBar();
		setJMenuBar(jMenuBar);
		
		jMenu = new JMenu("Menu");
		jMenuBar.add(jMenu);
		
		jMenuItem = new JMenuItem("Menu Item");
		jMenu.add(jMenuItem);

		Handler handler = new Handler();
		jMenuItem.addActionListener(handler);
		
	}
	
	private class Handler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		MenuTutorial menuTutorial = new MenuTutorial();
		menuTutorial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuTutorial.setSize(300, 300);
		menuTutorial.setVisible(true);
		menuTutorial.setTitle("The title");
	}
}
