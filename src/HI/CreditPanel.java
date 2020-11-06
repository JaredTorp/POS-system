package HI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import POSPD.Cash;
import POSPD.Credit;
import POSPD.Sale;
import POSPD.Session;
import POSPD.Store;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;

public class CreditPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblErrAmount;

	/**
	 * Create the panel.
	 */
	public CreditPanel(JFrame currentFrame, Store store, Session session, Sale sale) {
		setLayout(null);
		
		lblErrAmount = new JLabel("ERR - Amount Too Much");
		lblErrAmount.setBounds(41, 43, 146, 14);
		add(lblErrAmount);
		lblErrAmount.setVisible(false);
		
		
		JLabel lblEnterCreditPayment = new JLabel("Enter Credit Payment");
		lblEnterCreditPayment.setBounds(194, 23, 146, 20);
		add(lblEnterCreditPayment);
		
		JLabel lblAmount = new JLabel("Amount : ");
		lblAmount.setBounds(121, 72, 60, 14);
		add(lblAmount);
		
		textField = new JTextField();
		textField.setBounds(194, 69, 126, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblCardType = new JLabel("Card Type : ");
		lblCardType.setBounds(106, 116, 75, 14);
		add(lblCardType);
		
		JLabel lblAccountNum = new JLabel("Account Num : ");
		lblAccountNum.setBounds(106, 161, 75, 14);
		add(lblAccountNum);
		
		JLabel lblExpireDate = new JLabel("Expire Date : ");
		lblExpireDate.setBounds(106, 210, 75, 14);
		add(lblExpireDate);
		
		textField_1 = new JTextField();
		textField_1.setBounds(194, 113, 126, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(194, 158, 126, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(194, 207, 126, 20);
		add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				BigDecimal amount = new BigDecimal(textField.getText());
				BigDecimal remain = sale.calcTotal().subtract(sale.getTotalPayments());
				
				if ( amount.compareTo(remain) > 0.00 )
				{
					lblErrAmount.setVisible(true);
				}
				else
				{
					lblErrAmount.setVisible(false);
					
					Credit credit = new Credit(textField_1.getText(), textField_2.getText(), textField_3.getText());
				
					credit.setAmtTendered(amount); //because there isnt an amount tendered with credit
					credit.setAmount(sale.calcAmount(credit.getAmtTendered()));
					
					sale.addPayment(credit);
					
					currentFrame.getContentPane().removeAll();
					currentFrame.getContentPane().add(new POSPayment(currentFrame, store, session, sale));
					currentFrame.getContentPane().revalidate();
				}
				
			}
		});
		btnSave.setBounds(106, 266, 89, 23);
		add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new POSPayment(currentFrame, store, session, sale));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnCancel.setBounds(231, 266, 89, 23);
		add(btnCancel);
		
	
		

	}
}
