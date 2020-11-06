package POSPD;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class SaleLineItem
{

	private Sale Sale;
	private Item Item;
	/**
	 * a SaleLineItem has an item
	 */
	private Item item;
	/**
	 * A SaleLienItem has a quantity amount
	 */
	private int quantity;
	/**
	 * The SaleLineItem has a specific Sale
	 */
	private Sale sale;

	public Item getItem()
	{
		return this.item;
	}

	public void setItem(Item item)
	{
		this.item = item;
	}

	public int getQuantity()
	{
		return this.quantity;
	}

	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}

	public Sale getSale()
	{
		return this.sale;
	}

	public void setSale(Sale sale)
	{
		this.sale = sale;
	}

	/**
	 * The default constructor for the SaleLineItem
	 */
	public SaleLineItem()
	{
		this.quantity = 0;
	}

	/**
	 * The constuctor for a saleLineItem with parameters
	 * @param sale we pass the specific sale
	 * @param item we pass the item
	 * @param quantity We pass the quantity
	 */
	public SaleLineItem(Sale sale, Item item, String quantity)
	{
		this();
		this.sale = sale;
		this.item = item;
		item.addSaleLineItem(this);;
		this.quantity = Integer.parseInt(quantity) ;
		
	}

	/**
	 * This method calculates the subtotal
	 * @return returns the subtotal
	 */
	public BigDecimal calcSubTotal()
	{
		return this.getItem().calcAmountForDateQty(this.getSale().getDateTime().toLocalDate(), this.getQuantity());
	}

	/**
	 * This method Calculates the tax
	 * @return returns the tax
	 */
	public BigDecimal calcTax()
	{
		return this.getItem().getTaxRateForDate(this.getSale().getDateTime().toLocalDate()).multiply(this.calcSubTotal()).setScale(2, RoundingMode.HALF_UP);
	}

	/**
	 * toString function for the SaleLineItem Class
	 */
	public String toString()
	{
		return item.getNumber() + " " + item.getDescription() + " " + this.getQuantity() + " " + this.calcSubTotal() + " " + this.calcTax(); 
	}

	public LocalDate getSaleDate() 
	{
		return sale.getDateTime().toLocalDate(); 
		
	}

}