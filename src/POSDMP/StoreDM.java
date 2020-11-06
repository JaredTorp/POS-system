package POSDMP;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import POSPD.*;

public class StoreDM 
{
	//private String fileName = "StoreData.csv";
	//private String line = null;
	//private String dataType;
	
	

	
	public static void loadstore(Store store)
	{
	String fileName = "file.csv";
	
	String line = null;
	String dataType;
	String result[];
	TaxCategory taxCat = null;
	TaxRate taxRate = null;
	Cashier cashier = null;
	Person person = null;
	Item item = null;
	Register register = null;
	UPC upc = null;
	PromoPrice promoPrice = null;
	Session session = null;
	Sale sale  = null;
	SaleLineItem sli = null;
	Payment payment = null;
	
	
	try {
		FileReader fileReader =
				new FileReader(fileName);
		BufferedReader bufferedReader =
				new BufferedReader(fileReader);
		
		while ((line = bufferedReader.readLine()) != null)
		{
			result = line.split(",");
			
			if (result[0].equals("Store"))
			{
				store.setName(result[1]);
			}
			
			else if (result[0].equals("TaxCategory"))
			{
				taxCat = new TaxCategory(result[1]);
				taxRate = new TaxRate(LocalDate.parse(result[3], DateTimeFormatter.ofPattern("M/d/yyyy")), new BigDecimal(result[2]));
				taxCat.addTaxRate(taxRate);
				store.addTaxCategory(taxCat);
				
			}
			else if (result[0].equals("Cashier"))
			{
				cashier = new Cashier();
				cashier.setNumber(result[1]);
				person = new Person();
				person.setName(result[2]);
				person.setSSN(result[3]);
				person.setAddress(result[4]);
				person.setCity(result[5]);
				person.setState(result[6]);
				person.setZip(result[7]);
				person.setPhone(result[8]);
				cashier.setPassword(result[9]);
				cashier.setPerson(person);
				store.addCashier(cashier);
			}
			else if (result[0].equals("Item"))
			{
				item = new Item();
				item.setNumber(result[1]);
				upc = new UPC();
				upc.setUPC(result[2]);
				item.setDescription(result[3]);
				item.setTaxCategory(store.findTaxCategoryByName(result[4]));
				item.addPrice(new Price(result[5], result[6]));
				
				if (result.length > 7 )
				{
				promoPrice = new PromoPrice(result[7], result[8], result[9]);
				item.addPrice(promoPrice); //add the promo price
				}
				item.addUPC(upc);
				store.addItem(item);
			}	
				
			else if (result[0].equals("Register"))
			{
				register = new Register();
				register.setNumber(result[1]);
				store.addRegister(register);
			}
			
			else if (result[0].equals("Session"))
			{
				session = new Session(store.findCashierForNumber(result[1]), store.findRegisterByNumber(result[2]));
				session.setDifference(new BigDecimal("0.00"));
				store.addSession(session);
				session.setStartDateTime(LocalDateTime.now());
				
				
				
				store.findCashierForNumber(result[1]).addSession(session);
			}
			
			else if (result[0].equals("Sale"))
			{
				sale = new Sale(result[1]);
				
				session.addSale(sale);
				session.setSalesCount(session.getSales().size());
			}
			
			else if (result[0].equals("SaleLineItem"))
			{
				sli = new SaleLineItem(sale, store.findItemForNumber(result[1]), result[2]);
				sale.addSaleLineItem(sli);
			}
			
			else if (result[0].equals("Payment"))
			{
				if (result[1].equals("Cash"))
				{
					payment = new Cash(result[2], new BigDecimal(result[3]));
					sale.addPayment(payment);
				}
				else if (result[1].equals("Check"))
				{
					payment = new Check(result[2], result[4], result[5], result[6]);
					payment.setAmount(new BigDecimal(result[2]));
					payment.setAmtTendered(new BigDecimal(result[3]));
					sale.addPayment(payment);
				}
				else if (result[1].equals("Credit"))
				{
					payment = new Credit(result[4], result[5], result[6]);
					payment.setAmount(new BigDecimal(result[2]));
					payment.setAmtTendered(new BigDecimal(result[3]));
					sale.addPayment(payment);
				}
				
				
			}
		}
		
		bufferedReader.close();
	}
	 catch(FileNotFoundException ex) 
	 {
	   System.out.println( "Unable to open file '" +  fileName + "'");                
	 }
	 catch(IOException ex) 
	 {
	    System.out.println (  "Error reading file '" + fileName + "'") ;   	
	 }

		
		
	}
	
	
	
	
}
