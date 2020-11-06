package HI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import POSPD.*;
import POSPD.UPC;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class UPCEditPanel extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public UPCEditPanel(JFrame currentFrame, JPanel currentPanel, Store store, Item item,  UPC upc , Boolean isAdd) 
	{
		setLayout(null);
		
		JLabel lblEditUpc = new JLabel("Edit UPC");
		lblEditUpc.setBounds(213, 11, 46, 14);
		add(lblEditUpc);
		
		JLabel lblUpcCode = new JLabel("UPC Code : ");
		lblUpcCode.setBounds(86, 82, 65, 14);
		add(lblUpcCode);
		
		textField = new JTextField(upc.getUPC());
		textField.setBounds(152, 79, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				upc.setUPC((textField.getText()));
				if (isAdd) 
				{
					item.addUPC(upc);
				}
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(currentPanel);
				currentFrame.getContentPane().repaint();
			}
		});
		btnSave.setBounds(86, 204, 89, 23);
		add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(currentPanel);
				currentFrame.getContentPane().repaint();
			}
		});
		btnCancel.setBounds(213, 204, 89, 23);
		add(btnCancel);
		

	}
}
