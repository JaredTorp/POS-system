package HI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import POSPD.Item;
import POSPD.Price;
import POSPD.Store;
import POSPD.TaxCategory;
import POSPD.TaxRate;
import POSPD.UPC;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class ItemEditPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
    private JPanel currentPanel = this;
    private JButton btnAddUpc;
    private JButton btnEditUpc;
    private JButton btnDeleteUpc;
    private JButton btnAddPrice;
    private JButton btnEditPrice;
    private JButton btnDeletePrice;
    private DefaultListModel upcListModel;
    private DefaultListModel priceListModel;
    private JList<UPC> upcList;
    private JList<Price> priceList;
    private  DefaultComboBoxModel <TaxCategory> boxModel;
    private JComboBox <TaxCategory> comboBox;
    private JLabel lblUpcs;
    private JLabel lblPrices;
    
    /*
	 * Create the panel.
	 */
	public ItemEditPanel(JFrame currentFrame, Store store, Item item, Boolean isAdd) 
	{
		addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) {
				upcListModel = new DefaultListModel();
				priceListModel = new DefaultListModel();
				
				if (item.getUPCs().isEmpty())
				{
					System.out.println("empty");
				}
				
				for (UPC upc: item.getUPCs().values())
				{
					upcListModel.addElement(upc);
				}
				for (Price price: item.getPrices())
				{
					priceListModel.addElement(price);
				}
				
				upcList.setModel(upcListModel);
				priceList.setModel(priceListModel);
				
				
			}
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
			}
		});
		
		
		
		
		setLayout(null);
		
		JLabel lblItemEdit = new JLabel("Item Edit ");
		lblItemEdit.setBounds(117, 11, 46, 14);
		add(lblItemEdit);
		
		JLabel lblItemNumber = new JLabel("Item Number :");
		lblItemNumber.setBounds(10, 44, 112, 14);
		add(lblItemNumber);
		
		textField = new JTextField(item.getNumber());
		textField.setBounds(101, 41, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description : ");
		lblDescription.setBounds(10, 81, 78, 14);
		add(lblDescription);
		
		textField_1 = new JTextField(item.getDescription());
		textField_1.setBounds(101, 78, 117, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblTaxCategory = new JLabel("Tax Category :");
		lblTaxCategory.setBounds(10, 115, 112, 14);
		add(lblTaxCategory);
		 
		DefaultComboBoxModel <TaxCategory> boxModel = new DefaultComboBoxModel();
		 for (TaxCategory tc : store.getTaxCategories().values())
		 {
			boxModel.addElement(tc);
		 }
	
		
		
		comboBox = new JComboBox<TaxCategory>(boxModel);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				
				
			}
		});
		comboBox.setBounds(101, 112, 112, 20);
		add(comboBox);
		
		 if (!isAdd)
		 {
			 comboBox.setSelectedItem(item.getTaxCategory());
		 }
		
		

		
		JButton btnSave = new JButton("Save ");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				item.setNumber(textField.getText());
				item.setDescription(textField_1.getText());
				item.setTaxCategory((TaxCategory)comboBox.getSelectedItem()); // this may be wrong
				//item.setTaxCategory(comboBox.getSelectedItem()); how do i do combo boxes?
				if (isAdd == true) {
					store.addItem(item);
				}
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new ItemSelectionPanel(currentFrame, store));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnSave.setBounds(10, 210, 89, 23);
		add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new ItemSelectionPanel(currentFrame, store));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnCancel.setBounds(117, 210, 89, 23);
		add(btnCancel);
		
		//this part is the parts with the lists
		
		upcListModel = new DefaultListModel();
		upcList = new JList<UPC>(upcListModel);
		
		priceListModel = new DefaultListModel();
		priceList = new JList<Price>(priceListModel);
		
		
		
		
		
		upcList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) 
			{
				if (upcList.getSelectedValue() != null)
				{
					
					btnEditUpc.setEnabled(true);
					//do something here
					btnDeleteUpc.setEnabled(true);
						
					 
					
				}
				else 
				{
					btnDeleteUpc.setEnabled(false);
					btnEditUpc.setEnabled(false);
				}
				
			}
		});
		upcList.setBounds(274, 25, 141, 70);
		add(upcList);
		
		
		priceList.addListSelectionListener(new ListSelectionListener() 
		{
			public void valueChanged(ListSelectionEvent e)
			{
				if (priceList.getSelectedValue() != null)
				{
					
					btnEditPrice.setEnabled(true);
					//do something here
					btnDeletePrice.setEnabled(true);
						
					 
					
				}
				else 
				{
					btnDeletePrice.setEnabled(false);
					btnEditPrice.setEnabled(false);
				}
				
			}
		});
		priceList.setBounds(274, 213, 141, 56);
		add(priceList);
		
		
		
		
		
		btnAddUpc = new JButton("Add");
		btnAddUpc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new UPCEditPanel(currentFrame, currentPanel,  store, item,  new UPC(), true));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnAddUpc.setBounds(274, 111, 63, 23);
		add(btnAddUpc);
		
		btnEditUpc = new JButton("Edit");
		btnEditUpc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new UPCEditPanel(currentFrame, currentPanel, store, item, upcList.getSelectedValue(), false));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnEditUpc.setBounds(350, 111, 65, 23);
		add(btnEditUpc);
		btnEditUpc.setEnabled(false);
		
		btnDeleteUpc = new JButton("Delete");
		btnDeleteUpc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				item.removeUPC(upcList.getSelectedValue());
				upcListModel.removeElement(upcList.getSelectedValue());
			}
		});
		btnDeleteUpc.setBounds(296, 149, 94, 23);
		add(btnDeleteUpc);
		btnDeleteUpc.setEnabled(false);
		
		
		
		
		
		
		
		
		
		
		
		
	    btnAddPrice = new JButton("Add");
		btnAddPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new PriceEditPanel(currentFrame, currentPanel,  store, item,  new Price(), true));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnAddPrice.setBounds(274, 286, 65, 23);
		add(btnAddPrice);
		
		btnEditPrice = new JButton("Edit");
		btnEditPrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new PriceEditPanel(currentFrame, currentPanel,  store, item,  priceList.getSelectedValue(), false));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnEditPrice.setBounds(350, 286, 65, 23);
		add(btnEditPrice);
		btnEditPrice.setEnabled(false);
		
		btnDeletePrice = new JButton("Delete");
		btnDeletePrice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				item.removePrice(priceList.getSelectedValue());
				priceListModel.removeElement(priceList.getSelectedValue());
			}
		});
		btnDeletePrice.setBounds(296, 320, 94, 23);
		add(btnDeletePrice);
		btnDeletePrice.setEnabled(false);
		
		lblUpcs = new JLabel("UPCs");
		lblUpcs.setBounds(328, 11, 46, 14);
		add(lblUpcs);
		
		lblPrices = new JLabel("Prices");
		lblPrices.setBounds(328, 188, 39, 14);
		add(lblPrices);
		
		

	}
}
