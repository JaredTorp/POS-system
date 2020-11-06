package POSPD;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

/**
 * Item class represents an Item in the Store
 */
public class Item
{

	/**
	 * An item has a number bound to the item
	 */
	private String number;
	/**
	 * an item has a description
	 */
	private String description;
	/**
	 * an item knows about its sale line item
	 */
	private ArrayList<SaleLineItem> saleLineItems;
	/**
	 * An item knows about a collection of saleLineItems
	 */
	private TreeSet<Price> prices;
	/**
	 * an item has a upc
	 */
	private TreeMap<String, UPC> uPCs;
	/**
	 * An item has a tax category
	 */
	private TaxCategory taxCategory;

	public String getNumber()
	{
		return this.number;
	}

	public void setNumber(String number)
	{
		this.number = number;
	}

	public String getDescription()
	{
		return this.description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public ArrayList<SaleLineItem> getSaleLineItems()
	{
		return this.saleLineItems;
	}


	public TreeMap<String, UPC> getUPCs()
	{
		return this.uPCs;
	}
	public TreeSet<Price> getPrices()
	{
		return prices;
	}

	public TaxCategory getTaxCategory()
	{
		return this.taxCategory;
	}

	public void setTaxCategory(TaxCategory taxCategory)
	{
		this.taxCategory = taxCategory;
	}

	/**
	 * The default constructor for the Item Class
	 */
	public Item()
	{
		this.number = "";
		this.description = "";
		saleLineItems = new ArrayList <SaleLineItem>();
		prices = new TreeSet <Price>();
		uPCs = new TreeMap <String, UPC>();
		 
		
	}

	/**
	 * the Constructor that has a parameters
	 * @param number we pass the number of the item
	 * @param description we pass the description of the item
	 */
	public Item(String number, String description)
	{
		this();
		this.number = number;
		this.description = description;
	}

	/**
	 * This method adds a price to an item
	 * @param price we pass the price we want to add
	 */
	public void addPrice(Price price)
	{
		prices.add(price);
	}

	/**
	 * This method removes a price from an item
	 * @param price we pass the price we want to remove
	 */
	public void removePrice(Price price)
	{
		prices.remove(price);
	}

	/**
	 * This method adds a upc to the item
	 * @param upc we pass the UPC we want to add
	 */
	public void addUPC(UPC upc)
	{
		uPCs.put(upc.getUPC(), upc);
	}
	
	
	//i think this is what we do?
	
	public void removeUPC(UPC upc)
	{
		uPCs.remove(upc.getUPC());
	}

	/**
	 * This method gets the price for the specific date
	 * @param date we pass the date
	 */
	public Price getPriceForDate(LocalDate date)
	{
		Price lastEffective = null;
		for (Price price : this.getPrices())
		{
			if (price.isEffective(date))
			{
				lastEffective = price;
			}
			
			
		}
		return lastEffective;
	}

	/**
	 * This method gets the tax rate of a specific date
	 * @param date we pass the date to see the tax rate for it
	 */
	public BigDecimal getTaxRateForDate(LocalDate date)
	{
		return this.getTaxCategory().getTaxRateForDate(date);
	}

	/**
	 * This method calculates the amount for the date quantity
	 * @param date we pass the date
	 * @param quantity we pass the quantity
	 */
	public BigDecimal calcAmountForDateQty(LocalDate date, int quantity)
	{
		return this.getPriceForDate(date).calcAmountForQty(quantity);
	}

	public boolean isItemUsed()
	{
		return !this.getSaleLineItems().isEmpty();
	}
	
	
	/**
	 * the toString Function of the Item Class
	 */
	public String toString()
	{ 															
		return this.getNumber() + " " + this.getDescription();
	}

	public void addSaleLineItem(SaleLineItem saleLineItem) 
	{
		saleLineItems.add(saleLineItem);
		
	}

	public int calcItemsSold(LocalDate date) 
	{
		int total = 0;
		
		for (SaleLineItem sli : this.getSaleLineItems())
		{
			if(sli.getSaleDate().equals(date))
			{
				total = total + sli.getQuantity();
			}
		}
		return total;
		
	}

}