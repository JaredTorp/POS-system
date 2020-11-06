package HI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import POSPD.*;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class TaxCategoryEditPanel extends JPanel {
	private JTextField textField;
	private DefaultListModel listModel;
	private JButton btnDelete;
	private JButton btnEdit;
	private JPanel currentPanel = this;
	private JList<TaxRate> list;
	/**
	 * Create the panel.
	 */
	public TaxCategoryEditPanel(JFrame currentFrame, Store store, TaxCategory taxCategory, Boolean isAdd) 
	{
		addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
				listModel = new DefaultListModel();
				for (TaxRate tr : taxCategory.getTaxRates())
				{
					listModel.addElement(tr);
					
				}
				
				list.setModel(listModel);
			}
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
			}
		});
		setLayout(null);
		
		JLabel lblTaxCategoeyEdit = new JLabel("Tax Category Edit");
		lblTaxCategoeyEdit.setBounds(151, 21, 133, 14);
		add(lblTaxCategoeyEdit);
		
		
		JLabel lblName = new JLabel("Name: ");
		lblName.setBounds(57, 77, 46, 14);
		add(lblName);
		
		
		
		
		textField = new JTextField(taxCategory.getCategory());
		textField.setBounds(100, 74, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setBounds(46, 107, 46, 14);
		add(label);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				taxCategory.setCategory((textField.getText()));
				if (isAdd == true) {
					store.addTaxCategory(taxCategory);
				}
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new TaxCategorySelectorPanel(currentFrame, store));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnSave.setBounds(46, 231, 86, 23);
		add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new TaxCategorySelectorPanel(currentFrame, store));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnCancel.setBounds(151, 231, 94, 23);
		add(btnCancel);
		
		
		listModel = new DefaultListModel();
		list = new JList<TaxRate>(listModel);
		
		for (TaxRate tr: taxCategory.getTaxRates())
		{
			listModel.addElement(tr);
		}
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) 
			{
				if (list.getSelectedValue() != null)
				{
					
					btnEdit.setEnabled(true);
					//do something here
					btnDelete.setEnabled(true);
						
					 
					
				}
				else 
				{
					btnDelete.setEnabled(false);
					btnEdit.setEnabled(false);
				}
				
				
			}
		});
		list.setBounds(231, 57, 133, 92);
		add(list);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new TaxRateEditPanel(currentFrame, currentPanel,  store, taxCategory,  new TaxRate(), true));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnAdd.setBounds(191, 160, 63, 20);
		add(btnAdd);
		
		 btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new TaxRateEditPanel(currentFrame, currentPanel, store, taxCategory, list.getSelectedValue(), false));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnEdit.setBounds(264, 160, 63, 20);
		add(btnEdit);
		btnEdit.setEnabled(false);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				taxCategory.removeTaxRate(list.getSelectedValue());
				listModel.removeElement(list.getSelectedValue());
				
			}
		});
		btnDelete.setBounds(332, 160, 76, 20);
		add(btnDelete);
		btnDelete.setEnabled(false);

		
		
	}
}
