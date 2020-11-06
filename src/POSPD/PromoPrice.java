package POSPD;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * PromoPrice is a child class to price and represents a special price (discount) for an item
 */
public class PromoPrice extends Price
{

	/**
	 * PromoPrice has an endDate for the promotion
	 */
	private LocalDate endDate;

	public LocalDate getEndDate()
	{
		return this.endDate;
	}

	public void setEndDate(LocalDate endDate)
	{
		this.endDate = endDate;
	}

	/**
	 * default constructor for the PromoPrice
	 */
	public PromoPrice()
	{
		super();
		this.endDate = LocalDate.parse(" ", DateTimeFormatter.ofPattern("M/d/yyyy"));
	}
		
		

	/**
	 * PromoPrice constructor with parameters
	 * @param price we pass the price for the promoprice
	 * @param effectiveDate we pass the effective date
	 * @param endDate we pass the endDate to the promoprice
	 */
	public PromoPrice(String price, String effectiveDate, String endDate)
	{
		super(price, effectiveDate);
		this.endDate = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("M/d/yyyy"));
	}

	/**
	 * this method tests to see if the effective date is applicable
	 * @param date we pass the date we want to compare
	 * @return returns a boolean is the date is effective or not
	 */
	public Boolean isEffective(LocalDate date)
	{
		boolean isEffective;
		if (this.getEffectiveDate().isBefore(date) && this.getEndDate().isAfter(date))
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
	 * this method compares the price
	 * @param price we pass the price we want to compare
	 * @return returns an int of (the price difference?)
	 */
	public int compareTo(Price price)
	{
		return super.compareTo(price); //what is the logic here? ask for some help
	}

	/**
	 * toString() of the PromoPrive
	 * @return returns the string of PromoPrice
	 */
	public String toString()
	{
		return this.getPrice().toString() + " " + this.getEffectiveDate() + " " + this.getEndDate();
	}

}