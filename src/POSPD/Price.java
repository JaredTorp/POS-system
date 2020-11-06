package POSPD;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Price implements Comparable <Price>
{

	private Item item;
	/**
	 * The price has a price
	 */
	private BigDecimal price;
	/**
	 * A price has an effective date
	 */
	private LocalDate effectiveDate;

	public BigDecimal getPrice()
	{
		return this.price;
	}

	public void setPrice(BigDecimal price)
	{
		this.price = price;
	}

	public LocalDate getEffectiveDate()
	{
		return this.effectiveDate;
	}

	public void setEffectiveDate(LocalDate effectiveDate)
	{
		this.effectiveDate = effectiveDate;
	}

	/**
	 * default constructor of the Price Class
	 */
	public Price()
	{
		this.price = new BigDecimal(0);
		this.effectiveDate = LocalDate.parse("1/1/00", DateTimeFormatter.ofPattern("M/d/yy"));
	}

	/**
	 * constructor with parameters
	 * @param price we pass the price to store
	 * @param effectiveDate we pass the effective date to store
	 */
	public Price(String price, String effectiveDate)
	{
		this();
		this.price = new BigDecimal(price);
		this.effectiveDate = LocalDate.parse(effectiveDate, DateTimeFormatter.ofPattern("M/d/yyyy"));
	}

	/**
	 * this method checks if the price is effective
	 * @param date we pass the date we want to compare
	 * @return returns a boolean is the date is effective or not
	 */
	public Boolean isEffective(LocalDate date)
	{
		boolean isEffective;
		if (this.getEffectiveDate().isBefore(date))
		{
			isEffective = true;		
		}
		else
		{
			isEffective = false;
		}
		return isEffective;
	}

	/**
	 * this method calculates the amount for the total quantity
	 * @param quantity we pass the quantity of items
	 * @return returns the total of the quantity of items
	 */
	public BigDecimal calcAmountForQty(int quantity)
	{
		return this.getPrice().multiply(new BigDecimal(quantity)).setScale(2);
	}

	/**
	 * this method compares the price
	 * @param price we pass the price we want to compare
	 * @return returns an int of (the price difference?)
	 */
	public int compareTo(Price price)
	{
		return this.getEffectiveDate().compareTo(price.getEffectiveDate());
	
	}

	/**
	 * tostring Function of the Price Object
	 */
	public String toString()
	{
		return  this.getPrice().toString() + " " + this.getEffectiveDate();
	}

}