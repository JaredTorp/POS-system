package HI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import POSPD.Cashier;
import POSPD.Store;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CashierEditPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField passwordField;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Create the panel.
	 * @param isAdd 
	 * @param register 
	 * @param store 
	 * @param currentFrame 
	 */
	public CashierEditPanel(JFrame currentFrame, Store store, Cashier cashier, boolean isAdd) 
	{
		setLayout(null);
		
		JLabel lblCashierEdit = new JLabel("Cashier Edit");
		lblCashierEdit.setBounds(178, 11, 117, 14);
		add(lblCashierEdit);
		
		JLabel lblNumber = new JLabel("Number : ");
		lblNumber.setBounds(33, 48, 66, 14);
		add(lblNumber);
		
		textField = new JTextField(cashier.getNumber());
		textField.setBounds(91, 45, 110, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("Name : ");
		lblName.setBounds(33, 76, 46, 14);
		add(lblName);
		
		textField_1 = new JTextField(cashier.getPerson().getName());
		textField_1.setBounds(91, 73, 110, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setBounds(33, 101, 66, 14);
		add(lblAddress);
		
		textField_2 = new JTextField(cashier.getPerson().getAddress());
		textField_2.setBounds(91, 98, 110, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password : ");
		lblPassword.setBounds(33, 182, 77, 14);
		add(lblPassword);
		
		passwordField = new JPasswordField(cashier.getPassword());
		passwordField.setBounds(115, 179, 117, 20);
		add(passwordField);
		passwordField.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				cashier.setNumber(textField.getText());
				cashier.getPerson().setName(textField_1.getText());
				cashier.getPerson().setAddress(textField_2.getText());
				cashier.getPerson().setCity(textField_4.getText());
				cashier.getPerson().setState(textField_5.getText());
				cashier.getPerson().setZip(textField_6.getText());
				cashier.setPassword(passwordField.getText());
				
				if (isAdd) 
				{
					store.addCashier(cashier);
				}
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CashierSelectionPanel(currentFrame, store));
				currentFrame.getContentPane().revalidate();
			}
				
				//
	});
		btnSave.setBounds(54, 240, 89, 23);
		add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CashierSelectionPanel(currentFrame, store));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnCancel.setBounds(195, 240, 89, 23);
		add(btnCancel);
		
		textField_4 = new JTextField(cashier.getPerson().getCity());
		textField_4.setBounds(91, 129, 110, 20);
		add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField(cashier.getPerson().getState());
		textField_5.setBounds(280, 45, 35, 20);
		add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField(cashier.getPerson().getZip());
		textField_6.setBounds(275, 73, 86, 20);
		add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblCity = new JLabel("City :");
		lblCity.setBounds(33, 132, 46, 14);
		add(lblCity);
		
		JLabel lblState = new JLabel("State :");
		lblState.setBounds(238, 48, 46, 14);
		add(lblState);
		
		JLabel lblZip = new JLabel("Zip :");
		lblZip.setBounds(238, 76, 46, 14);
		add(lblZip);
		

	}
}
