package HI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import POSPD.Cashier;
import POSPD.Session;
import POSPD.Store;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import com.github.lgooddatepicker.components.DatePicker;

public class CashierSalesReport extends JPanel {

	
	
	private String text;
	private JTextArea textArea;
	DatePicker datePicker;
	/**
	 * Create the panel.
	 */
	
	
	public CashierSalesReport(JFrame currentFrame, Store store) {
		setLayout(null);
		
		JLabel lblCashierSalesReport = new JLabel("Cashier Sales Report");
		lblCashierSalesReport.setBounds(148, 11, 122, 14);
		add(lblCashierSalesReport);
		
		textArea = new JTextArea();
		textArea.setBounds(20, 69, 568, 151);
		add(textArea);
		
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				LocalDate date = datePicker.getDate();
				text = GenerateText(date, store);
				textArea.setText(text);
			}

			private String GenerateText(LocalDate date, Store store) {
				
				String newline = new String("\n");
				String tab = new String("\t");	
				String result;
				
				int totalSales = 0;
				BigDecimal totalDifference = new BigDecimal("0.00");
				BigDecimal totalAmount = new BigDecimal("0.00");
				
				result = "Cashier Report for: " + date.format(DateTimeFormatter.ofPattern("M/d/yyyy")) + newline +
						"Number" + tab + "Name" + tab + tab + "Count" + tab + "Amount " + tab + "Difference" ;
				//LEFT OFF HERE
				for (Cashier cashier : store.getCashiers().values())
				{
					totalSales = totalSales + cashier.getSalesCountForDate(date);
					totalDifference = totalDifference.add(cashier.getDifferenceForDate(date));
					totalAmount = totalAmount.add(cashier.getSalesForDate(date));
					
					result = result + newline + cashier.getNumber() + tab + cashier.getPerson().getName() + tab + tab + Integer.toString(cashier.getSalesCountForDate(date)) + tab + cashier.getSalesForDate(date).toString() + tab + cashier.getDifferenceForDate(date).toString() ;
				}
				result = result + newline + "Total: " + tab + tab + tab + Integer.toString(totalSales) + tab + totalAmount.toString() + tab + totalDifference.toString();
				
				return result;
			}
		});
		btnGenerate.setBounds(54, 254, 89, 23);
		add(btnGenerate);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new POSHome(store));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnClose.setBounds(265, 254, 89, 23);
		add(btnClose);
		
		datePicker = new DatePicker();
		datePicker.setBounds(148, 38, 139, 20);
		add(datePicker);
		
		JLabel lblDate = new JLabel("Date : ");
		lblDate.setBounds(104, 40, 39, 14);
		add(lblDate);

	}
	
	
}
