package HI;

import javax.swing.JPanel;
import javax.swing.ListModel;

import POSPD.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class TaxCategorySelectorPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private DefaultListModel listModel;
	private JButton btnDelete;
	private JButton btnEdit;
	
	public TaxCategorySelectorPanel(JFrame currentFrame, Store store) 
	{
		setLayout(null);
		
		JLabel lblTaxCategoryEdit = new JLabel("Tax Category Edit");
		lblTaxCategoryEdit.setBounds(161, 11, 93, 14);
		add(lblTaxCategoryEdit);
		
		DefaultListModel<TaxCategory> listModel = new DefaultListModel();
		 for (TaxCategory tc : store.getTaxCategories().values())
		 {
			 listModel.addElement(tc);
		 }
		
		
		JList<TaxCategory> list = new JList<TaxCategory>(listModel);
		list.addListSelectionListener(new ListSelectionListener()
		{
			
			public void valueChanged(ListSelectionEvent arg0) 
			{
				if (list.getSelectedValue() != null)
				{
					
					btnEdit.setEnabled(true);
					if(!store.isTaxCategoryUsed(list.getSelectedValue()))
					{
						//do something here
						btnDelete.setEnabled(true);
						
					}
					else 
					{
						btnDelete.setEnabled(false);
					}
				}
				else 
				{
					btnDelete.setEnabled(false);
					btnEdit.setEnabled(false);
				}
				
				
			}
			
		});
		list.setBounds(111, 40, 188, 143);
		add(list);
		
		JButton btnAdd = new JButton("add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new TaxCategoryEditPanel(currentFrame, store, new TaxCategory(), true));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnAdd.setBounds(58, 228, 89, 23);
		add(btnAdd);
		
		btnEdit = new JButton("edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new TaxCategoryEditPanel(currentFrame, store, list.getSelectedValue(), false));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnEdit.setBounds(174, 228, 89, 23);
		add(btnEdit);
		btnEdit.setEnabled(false);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				
				
			store.removeTaxCategory(list.getSelectedValue());
			listModel.removeElement(list.getSelectedValue());
					
				
			}
		});
		btnDelete.setBounds(283, 228, 89, 23);
		add(btnDelete);
		btnDelete.setEnabled(false);
		

	}
}
