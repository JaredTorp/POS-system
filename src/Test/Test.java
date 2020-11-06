package Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//this class test the code that is inside the POSPD
//we have to find out what kind of things to put here

import POSPD.*;

public class Test
{
	//AC1
	private Store store; //create our store
	
	private TaxCategory taxCat1;
	private TaxCategory taxCat2;
	private TaxCategory taxCat3;
	
	private TaxRate taxRate1;
	private TaxRate taxRate2;
	
	
	
	
	private UPC upc1;
	private UPC upc2;
	private UPC upc3;
	
	private Price price1;
	private Price price2;
	private Price price3;
	
	private Item item1; //our 3 items
	private Item item2;
	private Item item3;
	
	
	//AC2
	private Cashier cashier1;
	private Cashier cashier2;
	private Cashier cashier3;
	
	private Person person1;
	private Person person2;
	private Person person3;
	
	
	//AC3
	private CashDrawer cashdrawer1;
	private CashDrawer cashdrawer2;
	
	private Register register1;
	private Register register2;
	
	
	//AC4
	private Session session;
	private Sale sale;
	private SaleLineItem sli1;
	private SaleLineItem sli2;
	
	
	public Test()
	{
		
		store = new Store();
		store.loadStore();
		
		
	}
	
	public void firstproject()
	{
		//#AC1
		store = new Store();
		
		item1 = new Item("12", "Turkey Sandwich");
		item2 = new Item("34", "Ham Sandwich");
		item3 = new Item("56", "Coke");
		
		taxCat1 = new TaxCategory("Food");
		taxCat2 = new TaxCategory("Food");
		taxCat3 = new TaxCategory("Drink");
		
		
		LocalDate date1 = LocalDate.parse( "10/1/19", DateTimeFormatter.ofPattern("M/d/yy")); 
		LocalDate date2 = LocalDate.parse( "10/5/19", DateTimeFormatter.ofPattern("M/d/yy"));
		
		taxRate1 = new TaxRate(date2, new BigDecimal("0.07"));
		taxRate2 = new TaxRate(date1, new BigDecimal("0.04"));
		//add the taxrates
		taxCat1.addTaxRate(taxRate1);
		taxCat1.addTaxRate(taxRate2);
		taxCat2.addTaxRate(taxRate1);
		taxCat2.addTaxRate(taxRate2);
		taxCat3.addTaxRate(taxRate1);
		taxCat3.addTaxRate(taxRate2);
		
		upc1 = new UPC("1001");
		upc2 = new UPC("1002");
		upc3 = new UPC("1003");
		
		price1 = new Price("2.29", "10/7/19");
		price2 = new Price("2.59", "7/17/19");
		price3 = new Price("0.79", "1/28/19");
		
		item1.addPrice(price1);
		item1.addUPC(upc1);
		item1.setTaxCategory(taxCat1);
		item2.addPrice(price2);
		item2.addUPC(upc2);
		item2.setTaxCategory(taxCat2);
		item3.addPrice(price3);
		item3.addUPC(upc3);
		item3.setTaxCategory(taxCat3);
		
		store.addUPC(upc1);
		store.addUPC(upc2);
		store.addUPC(upc3);
		
		store.addItem(item1);
		store.addItem(item2);
		store.addItem(item3);
		
		//end constructor for Ac1
		
		//AC2
		
		person1 = new Person("David", "1234 Lane", "Greenwood", "Indiana", "46143", "8589858", "702-1029"); 
		person2 = new Person("Sally", "1238 Lane", "Towers", "Alabama", "54932", "6776777", "293-2923");
		person3 = new Person("Susan", "1459 Lane", "Birmingdurg", "Oklahoma", "70713", "3293329", "111-1101");
		
		
		cashier1 = new Cashier("1", person1, "password1234");
		cashier2 = new Cashier("2", person2, "bobby23");
		cashier3 = new Cashier("3", person3, "sunnyside5");
		
		//add the cashiers
		store.addCashier(cashier1);
		store.addCashier(cashier2);
		store.addCashier(cashier3);
		
		
		//AC3
		
		
		cashdrawer1 = new CashDrawer();
		cashdrawer2 = new CashDrawer();
		
		register1 = new Register("1");
		register2 = new Register("2");
		
		register1.setCashDrawer(cashdrawer1);
		register2.setCashDrawer(cashdrawer2);
		
		//add the registers
		
		store.addRegister(register1);
		store.addRegister(register2);
		
		
		
		//AC4
		//use cashier1, register2, a sale with 2 saleLineItems with quantity and item (use item1 and item3)
		session = new Session(cashier1, register2);
		sale = new Sale("y"); //taxfree i guess for now
		//Sale sale, Item item, String quantity
		sli1 = new SaleLineItem(sale, item1, "2");
		sli2 = new SaleLineItem(sale, item3, "1");
		//add the sale line items
		sale.addSaleLineItem(sli1);
		sale.addSaleLineItem(sli2);
	
	}
	
	
	public void TestDisplay()
	{
		//ac2
		System.out.println("===================");
		System.out.println("Cashiers");
		System.out.println("===================");
		for (Cashier cashier : store.getCashiers().values())
		{
			System.out.println(cashier.toString());
		}
		//ac3
		System.out.println("===================");
		System.out.println("Registers");
		System.out.println("===================");
		for (Register register : store.getRegisters().values())
		{
			System.out.println(register.toString());
		}
		//ac1
		System.out.println("===================");
		System.out.println("Items");
		System.out.println("===================");
		for (Item item : store.getItems().values())
		{
			System.out.println(item.toString());
		}
		System.out.println("===================");
		
		
		//ac4
		System.out.println("===================");
		System.out.println("Sessions");
		System.out.println("===================");
		for (Session session: store.getSessions())
		{
			System.out.println(session.toString());
			for (Sale sale : session.getSales())
			{
				System.out.println();
				System.out.println(sale.toString());
				for (SaleLineItem sli : sale.getSaleLineItems())
				{
					System.out.println(sli.toString());
				}
				System.out.println("===================");
				
			}
		
		
		
		}
		
		
		
	}
	
	
	
	
	

	
}
