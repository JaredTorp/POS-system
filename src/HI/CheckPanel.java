package HI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import POSPD.Cash;
import POSPD.Check;
import POSPD.Sale;
import POSPD.Session;
import POSPD.Store;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;

public class CheckPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public CheckPanel(JFrame currentFrame, Store store, Session session, Sale sale) {
		setLayout(null);
		
		JLabel lblPayment = new JLabel("Enter Check");
		lblPayment.setBounds(197, 11, 74, 14);
		add(lblPayment);
		
		JLabel lblNewLabel = new JLabel("Amount");
		lblNewLabel.setBounds(80, 52, 62, 14);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(169, 49, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Routing Num : ");
		lblNewLabel_1.setBounds(80, 93, 74, 14);
		add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(169, 90, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Account Num : ");
		lblNewLabel_2.setBounds(80, 134, 74, 14);
		add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(169, 131, 86, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Check Num : ");
		lblNewLabel_3.setBounds(80, 181, 74, 14);
		add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(169, 178, 86, 20);
		add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Check check = new Check(textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText());
				check.setAmtTendered(new BigDecimal(textField.getText()));
				sale.addPayment(check);
				session.getRegister().getCashDrawer().addCash(new BigDecimal(textField.getText()));
			
				check.setAmount(sale.calcAmount(check.getAmtTendered()));
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new POSPayment(currentFrame, store, session, sale));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnSave.setBounds(65, 224, 89, 23);
		add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new POSPayment(currentFrame, store, session, sale));
				currentFrame.getContentPane().revalidate();
				
			}
		});
		btnCancel.setBounds(205, 224, 89, 23);
		add(btnCancel);

	}
}
