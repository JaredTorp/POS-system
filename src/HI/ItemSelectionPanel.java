package HI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import POSPD.Item;
import POSPD.Store;
import POSPD.TaxCategory;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class ItemSelectionPanel extends JPanel {

	
	private JButton btnAdd;
	private JButton btnEdit;
	private JButton btnDelete;
	
	/**
	 * Create the panel.
	 */
	public ItemSelectionPanel(JFrame currentFrame, Store store) 
	{
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select Item");
		lblNewLabel.setBounds(180, 11, 100, 14);
		add(lblNewLabel);
		
		DefaultListModel<Item> listModel = new DefaultListModel();
		for (Item item : store.getItems().values())
		{
			listModel.addElement(item);
		}
		
		JList<Item> list = new JList<Item>(listModel);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0)
			{
				if (list.getSelectedValue() != null)
				{
					
					btnEdit.setEnabled(true);
					if(!list.getSelectedValue().isItemUsed())
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
		list.setBounds(48, 36, 392, 149);
		add(list);
		
	    btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new ItemEditPanel(currentFrame, store, new Item(), true));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnAdd.setBounds(51, 231, 89, 23);
		add(btnAdd);
		
		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new ItemEditPanel(currentFrame, store, list.getSelectedValue(), false));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnEdit.setBounds(163, 231, 89, 23);
		add(btnEdit);
		btnEdit.setEnabled(false);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				store.removeItem(list.getSelectedValue());
				listModel.removeElement(list.getSelectedValue());
			}
		});
		btnDelete.setBounds(269, 231, 89, 23);
		add(btnDelete);
		btnDelete.setEnabled(false);
	}
}
