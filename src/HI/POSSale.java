package HI;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;

import POSPD.Item;
import POSPD.Sale;
import POSPD.SaleLineItem;
import POSPD.Session;
import POSPD.Store;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class POSSale extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private DefaultListModel <SaleLineItem> sliListModel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblChange;
	private JLabel lblNewLabel_7;
	private JList <SaleLineItem> list;
	/**
	 * Create the panel.
	 */
	public POSSale(JFrame currentFrame, Store store, Session session, Sale sale) 
	{
		addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent arg0) 
			{
				sliListModel = new DefaultListModel();
				
				for (SaleLineItem sli : sale.getSaleLineItems())
				{
					sliListModel.addElement(sli);
				}
				
				list.setModel(sliListModel);
			}
			public void ancestorMoved(AncestorEvent arg0) {
			}
			public void ancestorRemoved(AncestorEvent arg0) {
			}
		});
		setLayout(null);
		
		JLabel lblPosSale = new JLabel("POS Sale");
		lblPosSale.setBounds(186, 11, 67, 14);
		add(lblPosSale);
		
		JLabel lblCashier = new JLabel("Cashier :");
		lblCashier.setBounds(10, 32, 46, 14);
		add(lblCashier);
		
		JLabel lblNewLabel = new JLabel(session.getCashier().toString());
		lblNewLabel.setBounds(66, 32, 46, 14);
		add(lblNewLabel);
		
		JLabel lblRegister = new JLabel("Register :");
		lblRegister.setBounds(10, 58, 67, 14);
		add(lblRegister);
		
		JLabel lblNewLabel_1 = new JLabel(session.getRegister().toString());
		lblNewLabel_1.setBounds(66, 57, 46, 14);
		add(lblNewLabel_1);
		
		JLabel lblUpc = new JLabel("UPC :");
		lblUpc.setBounds(10, 93, 46, 14);
		add(lblUpc);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				Item item = store.findItemForUPC(textField.getText());
				
				
				if (item != null) 
				{
				SaleLineItem sli = new SaleLineItem(sale, item, textField_1.getText());
				
				sale.addSaleLineItem(sli);
				sliListModel.addElement(sli);
				
				//System.out.println(sale.calcTax().toString());
				//System.out.println(sale.calcTotal().toString());
				
				lblNewLabel_2.setText(sale.calcSubTotal().toString());
				lblNewLabel_3.setText(sale.calcTax().toString());
				lblNewLabel_4.setText(sale.calcTotal().toString());
				textField.setText("");
				textField_1.setText("1");
				lblNewLabel_5.setText("");
				textField.requestFocusInWindow();
				}
				else 
				{
					lblNewLabel_5.setText("ERROR - UPC not found");
					textField.setText("");
					textField_1.setText("1");
					textField.requestFocusInWindow();
				}
			}
		});
		textField.setBounds(40, 90, 121, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblQty = new JLabel("Qty");
		lblQty.setBounds(171, 93, 61, 14);
		add(lblQty);
		
		textField_1 = new JTextField("1");
		textField_1.setBounds(201, 90, 31, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		
		sliListModel = new DefaultListModel<SaleLineItem>();
		
		
		//for (SaleLineItem sli : sale.getSaleLineItems())
		//{
			
		//}
		
	    list = new JList <SaleLineItem> (sliListModel);
		list.setBounds(10, 118, 307, 124);
		add(list);
		
		
		
		JLabel lblSubtotal = new JLabel("SubTotal :");
		lblSubtotal.setBounds(335, 96, 67, 14);
		add(lblSubtotal);
		
		lblNewLabel_2 = new JLabel(sale.calcSubTotal().toString());
		lblNewLabel_2.setBounds(395, 96, 46, 14);
		add(lblNewLabel_2);
		
		JLabel lblTax = new JLabel("Tax");
		lblTax.setBounds(335, 142, 46, 14);
		add(lblTax);
		
		JLabel lblTotal = new JLabel("Total : ");
		lblTotal.setBounds(335, 183, 46, 14);
		add(lblTotal);
		
		lblNewLabel_3 = new JLabel(sale.calcTax().toString());
		lblNewLabel_3.setBounds(379, 142, 46, 14);
		add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel(sale.calcTotal().toString());
		lblNewLabel_4.setBounds(379, 183, 46, 14);
		add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setBounds(268, 42, 235, 14);
		add(lblNewLabel_5);
		
		JCheckBox checkBox = new JCheckBox("Tax Free");
		checkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if (checkBox.isSelected())
				{
					sale.setTaxFree(true);
					
					
				}
				else
				{
					sale.setTaxFree(false);
				}
				lblNewLabel_3.setText(sale.calcTax().toString());
				lblNewLabel_4.setText(sale.calcTotal().toString());
				
				if(sale.isPaymentEnough())
				{
					lblNewLabel_7.setText(sale.calcChange().toString());
				}
				else
				{
					lblNewLabel_7.setText("0.00");
				}
				
			}
		});
		checkBox.setBounds(201, 54, 79, 23);
		add(checkBox);
		
		
		JButton btnPayment = new JButton("Payment");
		btnPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new POSPayment(currentFrame, store, session, sale));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnPayment.setBounds(33, 298, 89, 23);
		add(btnPayment);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new POSLogin(currentFrame, store));
				currentFrame.getContentPane().revalidate();
				
			}
		});
		btnCancel.setBounds(143, 298, 89, 23);
		add(btnCancel);
		
		JButton btnCompleteSale = new JButton("Complete Sale");
		btnCompleteSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				session.getRegister().getCashDrawer().removeCash(sale.calcChange()); //remove cash for change
				session.addSale(sale); //add the sale that was completed 
				
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new POSSale(currentFrame, store, session, new Sale()));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnCompleteSale.setBounds(23, 342, 131, 23);
		add(btnCompleteSale);
		if (!sale.isPaymentEnough()) 
			{
			btnCompleteSale.setEnabled(false);
			}
		
		JButton btnEndSession = new JButton("End Session");
		btnEndSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				session.setEndDateTime(LocalDateTime.now()); //set the end time to now
				
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new EndSession(currentFrame, store, session));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnEndSession.setBounds(164, 342, 116, 23);
		add(btnEndSession);
		
		JLabel lblPayment = new JLabel("Payment :");
		lblPayment.setBounds(329, 302, 61, 14);
		add(lblPayment);
		
		lblChange = new JLabel("Change :");
		lblChange.setBounds(335, 328, 52, 14);
		add(lblChange);
		
		JLabel lblNewLabel_6 = new JLabel(sale.getTotalPayments().toString());
		lblNewLabel_6.setBounds(395, 302, 46, 14);
		add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel(sale.calcChange().toString());
		lblNewLabel_7.setBounds(395, 328, 46, 14);
		add(lblNewLabel_7);

	}
}
