package HI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import POSPD.Register;
import POSPD.Store;
import POSPD.TaxCategory;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterEditPanel extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public RegisterEditPanel(JFrame currentFrame, Store store, Register register, Boolean isAdd) 
	{
		setLayout(null);
		
		JLabel lblEditRegister = new JLabel("Edit Register");
		lblEditRegister.setBounds(170, 24, 70, 14);
		add(lblEditRegister);
		
		JLabel lblNumber = new JLabel("Number: ");
		lblNumber.setBounds(61, 77, 62, 14);
		add(lblNumber);
		
		textField = new JTextField(register.getNumber());
		textField.setBounds(123, 74, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				register.setNumber((textField.getText()));
				if (isAdd) 
				{
					store.addRegister(register);
				}
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new RegisterSelectionPanel(currentFrame, store));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnSave.setBounds(100, 222, 89, 23);
		add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new RegisterSelectionPanel(currentFrame, store));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnCancel.setBounds(220, 222, 89, 23);
		add(btnCancel);

	}
}
