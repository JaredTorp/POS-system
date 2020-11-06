package HI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import POSPD.Cashier;
import POSPD.Item;
import POSPD.Sale;
import POSPD.SaleLineItem;
import POSPD.Session;
import POSPD.Store;
import javax.swing.JLabel;
import com.github.lgooddatepicker.components.CalendarPanel;
import com.github.lgooddatepicker.components.DateTimePicker;
import com.github.lgooddatepicker.components.DatePicker;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class ItemSales extends JPanel {

	private String text;
	private JTextArea textArea;
	DatePicker datePicker;
	/**
	 * Create the panel.
	 */
	public ItemSales(JFrame currentFrame, Store store)
	{
		
			setLayout(null);
			
			JLabel lblCashierSalesReport = new JLabel("Item Report");
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
				
					
					result = "Item Report for : " + date.format(DateTimeFormatter.ofPattern("M/d/yyyy")) + newline + newline;
					
				
					for (Item item : store.getItems().values())
					{
						result = result + (item.toString() + "                           ").substring(0, 20) + tab + tab + item.calcItemsSold(date) + newline;
					}
					
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
