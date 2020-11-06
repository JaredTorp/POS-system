package HI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import POSPD.Store;
import POSPD.TaxCategory;
import POSPD.TaxRate;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class TaxRateEditPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public TaxRateEditPanel(JFrame currentFrame, JPanel currentPanel, Store store, TaxCategory taxCategory,   TaxRate taxRate, boolean isAdd) 
	{
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TaxRateEdit");
		lblNewLabel.setBounds(184, 11, 70, 14);
		add(lblNewLabel);
		
		JLabel lblRate = new JLabel("Rate : ");
		lblRate.setBounds(56, 70, 46, 14);
		add(lblRate);
		
		JLabel lblDate = new JLabel("Date : ");
		lblDate.setBounds(56, 104, 46, 14);
		add(lblDate);
		
		textField = new JTextField(taxRate.getTaxRate().toString());
		textField.setBounds(107, 67, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField(taxRate.getDateString());
		textField_1.setBounds(107, 101, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				taxRate.setTaxRate((new BigDecimal(textField.getText())));
				taxRate.setEffectiveDate(LocalDate.parse(textField_1.getText(), DateTimeFormatter.ofPattern("M/d/yyyy")));
				if (isAdd) 
				{
					taxCategory.addTaxRate(taxRate);
				}
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(currentPanel);
				currentFrame.getContentPane().repaint();
			}
		});
		btnSave.setBounds(104, 211, 89, 23);
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
		btnCancel.setBounds(245, 211, 89, 23);
		add(btnCancel);

	}
}
