package HI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;

import POSPD.*;

import javax.swing.event.ListSelectionEvent;

public class RegisterSelectionPanel extends JPanel {

	private JButton btnAdd;
	private JButton btnEdit;
	private JButton btnDelete;
	/**
	 * Create the panel.
	 */
	public RegisterSelectionPanel(JFrame currentFrame, Store store) 
	{
		setLayout(null);
		
		JLabel lblSelectRegister = new JLabel("Select Register");
		lblSelectRegister.setBounds(171, 30, 131, 14);
		add(lblSelectRegister);
		
		DefaultListModel<Register> listModel = new DefaultListModel();
		for (Register register : store.getRegisters().values())
		{
			listModel.addElement(register);
		}
		
		JList<Register> list = new JList<Register>(listModel);
		list.addListSelectionListener(new ListSelectionListener() {
			
			public void valueChanged(ListSelectionEvent arg0) 
			{
				if (list.getSelectedValue() != null)
				{
					
					btnEdit.setEnabled(true);
					if(!store.isRegisterUsed(list.getSelectedValue()))
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
		list.setBounds(124, 55, 178, 130);
		add(list);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new RegisterEditPanel(currentFrame, store, new Register(), true));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnAdd.setBounds(43, 228, 89, 23);
		add(btnAdd);
		
		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new RegisterEditPanel(currentFrame, store, list.getSelectedValue(), false));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnEdit.setBounds(152, 228, 89, 23);
		add(btnEdit);
		btnEdit.setEnabled(false);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
			
					store.removeRegister(list.getSelectedValue());
					listModel.removeElement(list.getSelectedValue());
				
			}
		});
		btnDelete.setBounds(263, 228, 89, 23);
		add(btnDelete);
		btnDelete.setEnabled(false);

	}
}
