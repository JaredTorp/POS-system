package HI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.github.lgooddatepicker.components.DatePicker;

import POSPD.Cashier;
import POSPD.Sale;
import POSPD.Session;
import POSPD.Store;
import javax.swing.JScrollPane;

public class SalesReport extends JPanel {

	private String text;
	private JTextArea textArea;
	DatePicker datePicker;
	/**
	 * Create the panel.
	 */
	public SalesReport(JFrame currentFrame, Store store) 
	{
		
		setLayout(null);
		
		JLabel lblCashierSalesReport = new JLabel("Cashier Sales Report");
		lblCashierSalesReport.setBounds(148, 11, 122, 14);
		add(lblCashierSalesReport);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 69, 568, 151);
		add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
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
				
				BigDecimal totalCash = new BigDecimal("0.00");
				BigDecimal totalCheck = new BigDecimal("0.00");
				BigDecimal totalCredit = new BigDecimal("0.00");
				BigDecimal totalTotal = new BigDecimal("0.00");
				DateTimeFormatter stf = DateTimeFormatter.ofPattern("HH:mm");
				
				
				result = "Sales Report for: " + date.format(DateTimeFormatter.ofPattern("M/d/yyyy")) + newline +
						"Time" + tab + "Cash" + tab + "Check" + tab + "Credit " + tab + "Total" + newline ;
				
				for (Session session : store.getSessions())
				{
					
					if(date.equals(session.getStartDateTime().toLocalDate()))
					{
						for (Sale sale: session.getSales())
						{
							
							result = result + sale.getDateTime().format(stf) + tab + sale.getTotalCash() + tab + sale.getTotalCheck() + tab + sale.getTotalCredit() + tab + sale.getTotalPayments() + newline;
							 totalCash = totalCash.add(sale.getTotalCash());
							 totalCheck = totalCheck.add(sale.getTotalCheck());
							totalCredit = totalCredit.add(sale.getTotalCredit());
							totalTotal = totalTotal.add(sale.getTotalPayments());
						}
					}
					
				
				}
					
					
				result = result + newline + "Total: " + tab + totalCash.toString() + tab + totalCheck.toString() + tab + totalCredit.toString() + tab + totalTotal.toString()  ;
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
