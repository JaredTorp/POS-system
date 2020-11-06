package HI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import POSPD.Cashier;
import POSPD.Register;
import POSPD.Sale;
import POSPD.Session;
import POSPD.Store;
import POSPD.TaxCategory;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class POSLogin extends JPanel {
	private JTextField textField;
	private JPasswordField passwordField;
	JLabel lblErrorPasswordInvalid;
	/**
	 * Create the panel.
	 */
	public POSLogin(JFrame currentFrame, Store store) 
	{
		setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(187, 11, 58, 14);
		add(lblLogin);
		
		JLabel lblCashier = new JLabel("Cashier");
		lblCashier.setBounds(43, 72, 46, 14);
		add(lblCashier);
		
		JLabel lblRegister = new JLabel("Register :");
		lblRegister.setBounds(43, 128, 68, 14);
		add(lblRegister);
		
		JLabel lblStartingCash = new JLabel("Starting Cash :");
		lblStartingCash.setBounds(10, 177, 88, 14);
		add(lblStartingCash);
		
		//need some help here
		 DefaultComboBoxModel <Cashier> cashierBoxModel = new DefaultComboBoxModel <Cashier>();
		 for (Cashier cashier : store.getCashiers().values())
		 {
			cashierBoxModel.addElement(cashier);
		 }
		
		//DefaultComboBoxModel <Cashier> cashierList = new DefaultComboBoxModel<Cashier>(store.getCashiers().values().toArray());
		
		JComboBox <Cashier> comboBox = new JComboBox<Cashier>(cashierBoxModel);
		comboBox.setBounds(103, 69, 68, 20);
		add(comboBox);
		
		
		 DefaultComboBoxModel <Register> RegisterBoxModel = new DefaultComboBoxModel <Register>();
		 for (Register register : store.getRegisters().values())
		 {
			RegisterBoxModel.addElement(register);
		 }
		 
		JComboBox <Register> comboBox_1 = new JComboBox<Register>(RegisterBoxModel);
		comboBox_1.setBounds(103, 125, 68, 20);
		add(comboBox_1);
		
		textField = new JTextField();
		textField.setBounds(103, 174, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton btnEnter = new JButton("Enter");
		
		btnEnter.setBounds(43, 250, 89, 23);
		add(btnEnter);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new POSHome(store));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnCancel.setBounds(187, 250, 89, 23);
		add(btnCancel);
		
		JLabel lblPassword = new JLabel("Password : ");
		lblPassword.setBounds(20, 208, 78, 14);
		add(lblPassword);
		

				
		passwordField = new JPasswordField();
		passwordField.setBounds(103, 205, 86, 20);
		add(passwordField);
		
		lblErrorPasswordInvalid = new JLabel("Error: Password Invalid");
		lblErrorPasswordInvalid.setBounds(230, 36, 154, 14);
		add(lblErrorPasswordInvalid);
		lblErrorPasswordInvalid.setVisible(false);
		
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				//do something
		String password = passwordField.getText();
		Cashier cashier = (Cashier) comboBox.getSelectedItem();
		Register register = (Register) comboBox_1.getSelectedItem();
		
		
		
		if (cashier.isAuthorized(passwordField.getText()))
		{
			register.getCashDrawer().setCashAmount(new BigDecimal(textField.getText()));//the textfield for starting cash
			Session session = new Session(cashier, register);
			cashier.addSession(session);
			session.setStartDateTime(LocalDateTime.now()); //start the date session
			store.addSession(session);
			
			
			lblErrorPasswordInvalid.setVisible(false);
			
			
			currentFrame.getContentPane().removeAll();
			currentFrame.getContentPane().add(new POSSale(currentFrame, store, session, new Sale() ));
			currentFrame.getContentPane().revalidate();
			
		}
		
		else
		{
			lblErrorPasswordInvalid.setVisible(true);
		}
		;
		
		
		
			
		
			
			
			}});
	}	
}
	

