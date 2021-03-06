package test_14;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JTableDemo extends JFrame{
	
	private JTable table;
	
	public JTableDemo() {
		setLayout(new FlowLayout());
		
		String [] columnNames = {"Name", "Eye color", "Gender"};

		// create 2d object array
		Object [][] data = {
							{"Bill", "Hazel", "Male"},
							{"Mary", "Black", "Female"},
							{"Rick", "Red", "Male"},
							{"Janice", "Yellow", "Female"}
							};
		
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[0].length; j++) {
				System.out.println(data[i][j]);
				System.out.println("*******");
			}
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		}
		
		// create a new JTable  using data and columnNames
		table = new JTable(data, columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(200, 40));
		table.setFillsViewportHeight(true);
		
		
		// put the JTable into JScrollPane
		JScrollPane jScrollPane = new JScrollPane(table);
		add(jScrollPane);
	}
	
	public static void main(String[] args) {
		JTableDemo jTableDemo = new JTableDemo();
		jTableDemo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jTableDemo.setVisible(true);
		jTableDemo.setSize(300, 300);
		jTableDemo.setTitle("The title");
	}
}
