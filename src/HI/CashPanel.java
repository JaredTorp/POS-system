package HI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import POSPD.Cash;
import POSPD.Sale;
import POSPD.Session;
import POSPD.Store;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;

public class CashPanel extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public CashPanel(JFrame currentFrame, Store store, Session session, Sale sale) {
		setLayout(null);
		
		JLabel lblAmount = new JLabel("Amount : ");
		lblAmount.setBounds(10, 54, 64, 14);
		add(lblAmount);
		
		textField = new JTextField();
		textField.setBounds(84, 51, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setBounds(10, 90, 46, 14);
		add(label);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				Cash cash = new Cash();
				cash.setAmtTendered(new BigDecimal(textField.getText()));
				cash.setAmount(sale.calcAmount(cash.getAmtTendered()));
				sale.addPayment(cash);
				session.getRegister().getCashDrawer().addCash(new BigDecimal(textField.getText())); //add the cash to the drawer
			
				
	
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new POSPayment(currentFrame, store, session, sale));
				currentFrame.getContentPane().revalidate();
			}
			
		});
		btnSave.setBounds(10, 109, 89, 23);
		add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new POSPayment(currentFrame, store, session, sale));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnCancel.setBounds(124, 109, 89, 23);
		add(btnCancel);
		
		JLabel lblCash = new JLabel("Cash!");
		lblCash.setBounds(71, 11, 46, 14);
		add(lblCash);

	}
}
