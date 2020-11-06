package HI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import POSPD.*;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CashierSelectionPanel extends JPanel {

	
	private JButton btnAdd;
	private JButton btnEdit;
	private JButton btnDelete;
	/**
	 * Create the panel.
	 */
	public CashierSelectionPanel(JFrame currentFrame, Store store) 
	{
		setLayout(null);
		
		JLabel lblSelectCashier = new JLabel("Select Cashier");
		lblSelectCashier.setBounds(172, 11, 80, 14);
		add(lblSelectCashier);
		DefaultListModel<Cashier> listModel = new DefaultListModel();
		
		for (Cashier cashier : store.getCashiers().values())
		{
			listModel.addElement(cashier);
		}
		
		JList<Cashier> list = new JList<Cashier>(listModel);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) 
			{
				
					if (list.getSelectedValue() != null)
					{
						
						btnEdit.setEnabled(true);
						if(!store.isCashierUsed(list.getSelectedValue()))
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
		list.setBounds(93, 36, 233, 159);
		add(list);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CashierEditPanel(currentFrame, store, new Cashier(), true));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnAdd.setBounds(40, 232, 89, 23);
		add(btnAdd);
		
		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new CashierEditPanel(currentFrame, store, list.getSelectedValue(), false));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnEdit.setBounds(163, 232, 89, 23);
		add(btnEdit);
		btnEdit.setEnabled(false);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
					
			store.removeCashier(list.getSelectedValue());
			listModel.removeElement(list.getSelectedValue());
						
				
			}
		});
		btnDelete.setBounds(278, 232, 89, 23);
		add(btnDelete);
		btnDelete.setEnabled(false);

	}
}
