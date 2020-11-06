package HI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import POSPD.Sale;
import POSPD.Session;
import POSPD.Store;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class POSPayment extends JPanel {

	/**
	 * Create the panel.
	 */
	private CashPanel cashPanel;
	private CheckPanel checkPanel;
	private CreditPanel creditPanel;
	private JPanel currentPanel ;
	
	
	public POSPayment(JFrame currentFrame, Store store, Session session, Sale sale) {
		setLayout(null);
		
		currentPanel = this;
		
		JLabel lblPayment = new JLabel("Payment");
		lblPayment.setBounds(220, 11, 88, 14);
		add(lblPayment);
		
		JButton btnPaymentComplete = new JButton("Payment Complete");
		btnPaymentComplete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new POSSale(currentFrame, store, session, sale));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnPaymentComplete.setBounds(149, 336, 178, 23);
		add(btnPaymentComplete);
		if(!sale.isPaymentEnough())
		{
			btnPaymentComplete.setEnabled(false);
		}
		else 
		{
			btnPaymentComplete.setEnabled(true);
			
		}
		
		
		JLabel lblPaymentDue = new JLabel("Payment Due : ");
		lblPaymentDue.setBounds(10, 56, 88, 14);
		add(lblPaymentDue);
		
		JLabel lblAmountTendered = new JLabel("Amount Tendered");
		lblAmountTendered.setBounds(10, 125, 101, 14);
		add(lblAmountTendered);
		
		JButton btnCash = new JButton("Cash");
		btnCash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if (checkPanel != null)
				{
					remove(checkPanel);
					checkPanel = null;
				}
				if (creditPanel != null)
				{
					remove(creditPanel);
					creditPanel = null;
				}
				
				cashPanel = new CashPanel(currentFrame, store, session, sale);
				cashPanel.setBounds(200, 40, 233, 157);
				currentPanel.add(cashPanel);
				currentFrame.revalidate();
				currentFrame.repaint();
				
			}
		});
		btnCash.setBounds(10, 205, 89, 23);
		add(btnCash);
		
		JButton btnCheck = new JButton("Check");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if (cashPanel != null)
				{
					remove(cashPanel);
					cashPanel = null;
				}
				if (creditPanel != null)
				{
					remove(creditPanel);
					creditPanel = null;
				}
				
				checkPanel = new CheckPanel(currentFrame, store, session, sale);
				checkPanel.setBounds(100, 40, 362, 263);
				currentPanel.add(checkPanel);
				currentFrame.revalidate();
				currentFrame.repaint();
				
			}
		});
		btnCheck.setBounds(9, 239, 89, 23);
		add(btnCheck);
		
		JButton btnCredit = new JButton("Credit");
		btnCredit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if (cashPanel != null)
				{
					remove(cashPanel);
					cashPanel = null;
				}
				if (checkPanel != null)
				{
					remove(checkPanel);
					checkPanel = null;
				}
				creditPanel = new CreditPanel(currentFrame, store, session, sale);
				creditPanel.setBounds(50, 35, 400, 400);
				currentPanel.add(creditPanel);
				currentFrame.revalidate();
				currentFrame.repaint();
			}
		});
		btnCredit.setBounds(9, 273, 89, 23);
		add(btnCredit);
		
		JLabel lblNewLabel = new JLabel(sale.calcTotal().toString());
		lblNewLabel.setBounds(20, 78, 46, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(sale.calcAmtTendered().toString());
		lblNewLabel_1.setBounds(20, 146, 46, 14);
		add(lblNewLabel_1);
		
	
		


	}
}
