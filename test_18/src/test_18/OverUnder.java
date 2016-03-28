package test_18;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class OverUnder extends JFrame{
	
	private int round = 1;
	private int rand1, rand2, rand3, rand4;
	private JLabel label1, label2, label3, label4, orLabel, winOrLose;
	private JButton higher, lower;
	private JMenuBar jMenuBar;
	private JMenu jMenu;
	private JMenuItem reset, exit;
	
	
	public OverUnder() {
		setLayout(new GridLayout(3, 1));
		
		rand1 = (int)(Math.random() * 20 + 1);
		
		Font font = new Font("Serif", Font.BOLD, 16);
		
		jMenuBar = new JMenuBar();
		setJMenuBar(jMenuBar);
		
		jMenu = new JMenu("File");
		jMenuBar.add(jMenu);
		
		reset = new JMenuItem("Reset");
		jMenu.add(reset);
		
		exit = new JMenuItem("Exit");
		jMenu.add(exit);
		
		HandlerRestartGame handlerRestartGame = new HandlerRestartGame();
		reset.addActionListener(handlerRestartGame);
		
		HandlerSystemClose handlerSystemClose = new HandlerSystemClose();
		exit.addActionListener(handlerSystemClose);
		
		/*
		 * using Container object to set up layout
		 */
		Container container = this.getContentPane();
		
		// top panel set up
		JPanel top = new JPanel();
		top.setLayout(new GridLayout(1, 4));
		
		label1 = new JLabel("" + rand1, SwingConstants.CENTER);
		label1.setFont(font);
		top.add(label1);
		
		label2 = new JLabel("", SwingConstants.CENTER);
		label2.setFont(font);
		top.add(label2);
		
		label3 = new JLabel("", SwingConstants.CENTER);
		label3.setFont(font);
		top.add(label3);
		
		label4 = new JLabel("", SwingConstants.CENTER);
		label4.setFont(font);
		top.add(label4);
		
		container.add(top);
		
		JPanel middle = new JPanel();
		middle.setLayout(new GridLayout(1, 3));
		
		higher = new JButton("HIGHER");
		middle.add(higher);
		
		orLabel = new JLabel("Or", SwingConstants.CENTER);
		middle.add(orLabel);
		
		lower = new JButton("LOWER");
		middle.add(lower);
		
		container.add(middle);
		
		Handler handler = new Handler();
		higher.addActionListener(handler);
		lower.addActionListener(handler);
		
		JPanel bottom = new JPanel();
		bottom.setLayout(new GridLayout(1, 1));
		
		winOrLose = new JLabel("", SwingConstants.CENTER);
		winOrLose.setFont(font);
		
		bottom.add(winOrLose);
		container.add(bottom);
		
		
		
	}
	
	
	private class Handler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			String option = e.getActionCommand();
			
			if (round == 1) {
				rand2 = (int)(Math.random() * 20 + 1);
				label2.setText("" + rand2);
				if (rand2 > rand1 && option.equals("HIGHER")) {
					winOrLose.setText("Right, 2 more!");
				}
				else if (rand2 < rand1 && option.equals("HIGHER")) {
					winOrLose.setText("You lost!");
					lower.setEnabled(false);
					higher.setEnabled(false);
				}
				else if (rand2 > rand1 && option.equals("LOWER")) {
					winOrLose.setText("You lost!");
					lower.setEnabled(false);
					higher.setEnabled(false);
				}
				else if (rand2 < rand1 && option.equals("LOWER")){
					winOrLose.setText("Right, 2 more!");
				}
				round = 2;
			}
			else if (round == 2) {
				rand3 = (int)(Math.random() * 2 + 1);
				label3.setText("" + rand3);
				if (rand3 > rand2 && option.equals("HIGHER")) {
					winOrLose.setText("Right, 1 more!");
				}
				else if (rand3 < rand2 && option.equals("HIGHER")) {
					winOrLose.setText("You lost!");
					lower.setEnabled(false);
					higher.setEnabled(false);
				}
				else if (rand3 > rand2 && option.equals("LOWER")) {
					winOrLose.setText("You lost!");
					lower.setEnabled(false);
					higher.setEnabled(false);
				}
				else if (rand3 < rand2 && option.equals("LOWER")){
					winOrLose.setText("Right, 1 more!");
				}
				round = 3;
			}
			else if (round == 3) {
				rand4 = (int)(Math.random() * 20 + 1);
				label4.setText("" + rand4);
				if (rand4 > rand3 && option.equals("HIGHER")) {
					winOrLose.setText("You won!");
				}
				else if (rand4 < rand3 && option.equals("HIGHER")) {
					winOrLose.setText("You lost!");
					
				}
				else if (rand4 > rand3 && option.equals("LOWER")) {
					winOrLose.setText("You lost!");
				}
				else if (rand4 < rand3 && option.equals("LOWER")){
					winOrLose.setText("You won!");
				}
				// finally set the button to be unable
				lower.setEnabled(false);
				higher.setEnabled(false);
			}
		}
	}
	
	private class HandlerRestartGame implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			rand1 = (int)(Math.random() * 20 + 1);
			round = 1;
			higher.setEnabled(true);
			lower.setEnabled(true);
			label1.setText("" + rand1);
			label2.setText("");
			label3.setText("");
			label4.setText("");
			winOrLose.setText("");
		}
	}
	
	private class HandlerSystemClose implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		
		OverUnder overUnder = new OverUnder();
		overUnder.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		overUnder.setSize(400, 400);
		overUnder.setVisible(true);
		overUnder.setTitle("The title");
	}
}
