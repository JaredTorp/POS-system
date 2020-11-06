package HI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import POSPD.Store;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class POSFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void run (Store store)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					POSFrame frame = new POSFrame(store);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public POSFrame(Store store) 
	{
		JFrame currentframe = this;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 450);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMaintenance = new JMenu("Maintenance");
		menuBar.add(mnMaintenance);
		
		JMenuItem mntmStore = new JMenuItem("Store");
		mntmStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				getContentPane().removeAll();
				getContentPane().add(new StoreEditPanel(currentframe, store));
				getContentPane().revalidate();
			}
		});
		mnMaintenance.add(mntmStore);
		
		
		JMenuItem mntmTaxcategory = new JMenuItem("TaxCategory");
		mntmTaxcategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				getContentPane().removeAll();
				getContentPane().add(new TaxCategorySelectorPanel(currentframe, store));
				getContentPane().revalidate();
			}
		});
		mnMaintenance.add(mntmTaxcategory);
		
		JMenuItem mntmRegisters = new JMenuItem("Registers");
		mntmRegisters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				getContentPane().removeAll();
				getContentPane().add(new RegisterSelectionPanel(currentframe, store));
				getContentPane().revalidate();
			}
		});
		mnMaintenance.add(mntmRegisters);
		
		JMenuItem mntmCashiers = new JMenuItem("Cashiers");
		mntmCashiers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(new CashierSelectionPanel(currentframe, store));
				getContentPane().revalidate();
			}
		});
		mnMaintenance.add(mntmCashiers);
		
		JMenuItem mntmItems = new JMenuItem("Items");
		mntmItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(new ItemSelectionPanel(currentframe, store));
				getContentPane().revalidate();
			}
		});
		mnMaintenance.add(mntmItems);
		
		JMenu mnPos = new JMenu("POS");
		menuBar.add(mnPos);
		
		JMenuItem mntmLogin = new JMenuItem("Login");
		mntmLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				getContentPane().removeAll();
				getContentPane().add(new POSLogin(currentframe, store));
				getContentPane().revalidate();
			}
		});
		mnPos.add(mntmLogin);
		
		JMenu mnReports = new JMenu("Reports");
		menuBar.add(mnReports);
		
		JMenuItem mntmCashierReport = new JMenuItem("Cashier Report");
		mntmCashierReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				getContentPane().removeAll();
				getContentPane().add(new CashierSalesReport(currentframe, store));
				getContentPane().revalidate();
			}
		});
		mnReports.add(mntmCashierReport);
		
		JMenuItem mntmItemReport = new JMenuItem("Item Report");
		mntmItemReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(new ItemSales(currentframe, store));
				getContentPane().revalidate();
			}
		});
		mnReports.add(mntmItemReport);
		
		JMenuItem mntmCashierReport_1 = new JMenuItem("Sales Report");
		mntmCashierReport_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(new SalesReport(currentframe, store));
				getContentPane().revalidate();
			}
		});
		mnReports.add(mntmCashierReport_1);
		
		
		
		getContentPane().removeAll();
		getContentPane().add(new POSHome(store));
		getContentPane().revalidate();
		//contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setLayout(new BorderLayout(0, 0));
		//setContentPane(contentPane);
	}

}
