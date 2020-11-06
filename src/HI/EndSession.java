package HI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import POSPD.Sale;
import POSPD.Session;
import POSPD.Store;

import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EndSession extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_1;
	private BigDecimal difference;
	/**
	 * Create the panel.
	 */
	public EndSession(JFrame currentFrame, Store store, Session session) 
	{
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Session Summary");
		lblNewLabel.setBounds(183, 11, 133, 14);
		add(lblNewLabel);
		
		JLabel lblCashier = new JLabel("Cashier");
		lblCashier.setBounds(42, 43, 46, 14);
		add(lblCashier);
		
		JLabel lblCashythingy = new JLabel(session.getCashier().toString());
		lblCashythingy.setBounds(98, 43, 79, 14);
		add(lblCashythingy);
		
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setBounds(42, 68, 46, 14);
		add(lblRegister);
		
		JLabel lblRegnum = new JLabel(session.getRegister().toString());
		lblRegnum.setBounds(108, 68, 46, 14);
		add(lblRegnum);
		
		JLabel lblNumberSales = new JLabel("Number Sales : ");
		lblNumberSales.setBounds(25, 106, 79, 14);
		add(lblNumberSales);
		
		textField = new JTextField(Integer.toString(session.getSales().size())); //prints out how many sales
		textField.setBounds(118, 103, 94, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblTotalSales = new JLabel("Total Sales :");
		lblTotalSales.setBounds(25, 137, 68, 14);
		add(lblTotalSales);
		
		textField_1 = new JTextField(session.totalSales().toString());
		textField_1.setBounds(118, 134, 94, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEnterCash = new JLabel("Enter Cash :");
		lblEnterCash.setBounds(20, 168, 68, 14);
		add(lblEnterCash);
		
		textField_2 = new JTextField();
		textField_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				BigDecimal cash = new BigDecimal((textField_2.getText()));
				difference = session.calcCashCountDiff(cash);
				String diffStr = new String(difference.toString());
				
				lblNewLabel_1.setText(diffStr);
			}
		});
		textField_2.setBounds(118, 165, 94, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblCashCountDiff = new JLabel("Cash Count Diff :");
		lblCashCountDiff.setBounds(10, 211, 94, 14);
		add(lblCashCountDiff);
		
		JButton btnEndSession = new JButton("End Session");
		btnEndSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				session.getRegister().getCashDrawer().setCashAmount(new BigDecimal((textField_2.getText())));
				session.setSalesCount(session.getSales().size());
				session.setDifference(difference);
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new POSHome(store));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnEndSession.setBounds(123, 253, 144, 23);
		add(btnEndSession);
		
		lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setBounds(131, 211, 46, 14);
		add(lblNewLabel_1);

	}
}
