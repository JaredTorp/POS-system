package HI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import POSPD.Store;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StoreEditPanel extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public StoreEditPanel(JFrame currentFrame, Store store) 
	{
		setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(225, 5, 0, 0);
		add(label);
		
		JLabel lblEditStore = new JLabel("Edit Store");
		lblEditStore.setBounds(197, 16, 46, 14);
		add(lblEditStore);
		
		JLabel lblName = new JLabel("Name: ");
		lblName.setBounds(62, 94, 46, 14);
		add(lblName);
		
		textField = new JTextField(store.getName());
		textField.setBounds(98, 91, 209, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				store.setName(textField.getText());
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new POSHome(store));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnSave.setBounds(81, 208, 89, 23);
		add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new POSHome(store));
				currentFrame.getContentPane().revalidate();
			}
			
		});
		btnCancel.setBounds(197, 208, 89, 23);
		add(btnCancel);
		

	}
}
