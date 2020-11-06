package HI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import POSPD.Item;
import POSPD.Price;
import POSPD.PromoPrice;
import POSPD.Store;
import POSPD.UPC;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class PriceEditPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblEndDate;
	private JCheckBox promoCheckBox;
	private PromoPrice promoPrice;
	/**
	 * Create the panel.
	 */
	public PriceEditPanel(JFrame currentFrame, JPanel currentPanel, Store store, Item item,  Price price , Boolean isAdd) 
	{
		setLayout(null);
		
		JLabel lblEditPrice = new JLabel("Edit Price");
		lblEditPrice.setBounds(215, 11, 67, 14);
		add(lblEditPrice);
		
		
		
		promoCheckBox = new JCheckBox("Promo Price");
		promoCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if (promoCheckBox.isSelected())
				{
				lblEndDate.setEnabled(true);
				textField_2.setEnabled(true);
				//i think something else with promo price here
				}
				else 
				{
					lblEndDate.setEnabled(false);
					textField_2.setEnabled(false);
				}
			
			}
		});
		promoCheckBox.setBounds(164, 32, 97, 23);
		add(promoCheckBox);
		promoCheckBox.setEnabled(false);
		if (isAdd)
		{
			promoCheckBox.setEnabled(true);
		}
		
		
		JLabel lblPrice = new JLabel("Price : ");
		lblPrice.setBounds(50, 88, 46, 14);
		add(lblPrice);
		
		textField = new JTextField(price.getPrice().toString());
		textField.setBounds(95, 85, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblEffectiveDate = new JLabel("Effective Date : ");
		lblEffectiveDate.setBounds(10, 131, 139, 14);
		add(lblEffectiveDate);
		
		textField_1 = new JTextField(DateTimeFormatter.ofPattern("M/d/yyyy").format(price.getEffectiveDate()));
		textField_1.setBounds(95, 128, 97, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		lblEndDate = new JLabel("End Date : ");
		lblEndDate.setBounds(36, 164, 67, 14);
		add(lblEndDate);
		lblEndDate.setEnabled(false);
		
		textField_2 = new JTextField();
		textField_2.setBounds(95, 161, 97, 20);
		add(textField_2);
		textField_2.setColumns(10);
		textField_2.setEnabled(false);
		
		
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				
				if (promoCheckBox.isSelected())
				{
					promoPrice = new PromoPrice(textField.getText(), textField_1.getText(),textField_2.getText());
					//promoPrice.setPrice((new BigDecimal(textField.getText())));
					//promoPrice.setEffectiveDate(LocalDate.parse(textField_1.getText(), DateTimeFormatter.ofPattern("M/d/yyyy")));
					//promoPrice.setEndDate(LocalDate.parse(textField_2.getText(), DateTimeFormatter.ofPattern("M/d/yyyy")));
					if (isAdd)
					{
						item.addPrice(promoPrice);
					}
				}
				else 
				{
					price.setPrice((new BigDecimal(textField.getText())));
					price.setEffectiveDate(LocalDate.parse(textField_1.getText(), DateTimeFormatter.ofPattern("M/d/yyyy")));
					if (isAdd) 
					{
						item.addPrice(price);;
					}
				}
				
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(currentPanel);
				currentFrame.getContentPane().repaint();
			}
		});
		btnSave.setBounds(103, 227, 89, 23);
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
		btnCancel.setBounds(222, 227, 89, 23);
		add(btnCancel);
		
		if(price instanceof PromoPrice)
		{
			lblEndDate.setEnabled(true);
			textField_2.setEnabled(true);
			textField_2.setText((DateTimeFormatter.ofPattern("M/d/yyyy").format(((PromoPrice)price).getEndDate())));
			
		}

	}
}
