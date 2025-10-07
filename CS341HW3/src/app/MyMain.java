package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyMain {
	// controller that constructs the app window, creates events, and instantiates a
	// Saleslip object

	private JFrame frame;
	private JTextField item;
	private JTextField cost;
	private JTextField quantity;
	private JTextArea list;
	private JTextArea total;
	private SalesSlip salesSlip;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyMain window = new MyMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MyMain() {
		salesSlip=new SalesSlip();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Sales List");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 11, 434, 14);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Item:");
		lblNewLabel_1.setBounds(108, 36, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);

		item = new JTextField();
		item.setBounds(164, 33, 86, 20);
		frame.getContentPane().add(item);
		item.setColumns(10);

		cost = new JTextField();
		cost.setBounds(164, 64, 86, 20);
		frame.getContentPane().add(cost);
		cost.setColumns(10);

		quantity = new JTextField();
		quantity.setBounds(164, 91, 86, 20);
		frame.getContentPane().add(quantity);
		quantity.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Cost$:");
		lblNewLabel_2.setBounds(108, 67, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Quantity:");
		lblNewLabel_3.setBounds(108, 94, 46, 14);
		frame.getContentPane().add(lblNewLabel_3);

		JButton addItems = new JButton("Add Items to the Sales list");
		addItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String itemName=item.getText();
					double itemCost=Double.parseDouble(cost.getText());
					int itemQuantity=Integer.parseInt(quantity.getText());
					
					if(itemCost>=100) {
						JOptionPane.showMessageDialog(frame, "Cost must be less than or equal to price of 100");
						return;
					}
					SalesItem salesItem=new SalesItem(itemName,itemCost,itemQuantity);
						salesSlip.addItem(salesItem);
					
						list.setText(salesSlip.toString());
						total.setText(String.format("$%.2f", salesSlip.getTotalSales()));
						
						}
				catch(NumberFormatException ex) {
							JOptionPane.showMessageDialog(frame,"Invalid input: "+ex.getMessage());
						}
				}
		});
		addItems.setBounds(108, 122, 206, 23);
		frame.getContentPane().add(addItems);

		list = new JTextArea();
		list.setBounds(99, 156, 234, 66);
		frame.getContentPane().add(list);

		JLabel lblNewLabel_4 = new JLabel("Total sales:");
		lblNewLabel_4.setBounds(82, 233, 95, 14);
		frame.getContentPane().add(lblNewLabel_4);

		total = new JTextArea();
		total.setBounds(149, 233, 151, 20);
		frame.getContentPane().add(total);
	}

}
