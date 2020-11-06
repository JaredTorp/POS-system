package POSPD;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * TaxRate class represents the TaxRate and knows about its rate and effective date
 */
public class TaxRate implements Comparable <TaxRate>
{

	/**
	 * TaxRate has a tax rate
	 */
	private BigDecimal taxRate;
	/**
	 * tax rate has an effective date
	 */
	private LocalDate effectiveDate;

	public BigDecimal getTaxRate()
	{
		return this.taxRate;
	}

	public void setTaxRate(BigDecimal taxRate)
	{
		this.taxRate = taxRate;
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
	 * default constructor for the TaxRate class
	 */
	public TaxRate()
	{
		
		this.taxRate = new BigDecimal(0);
	}

	/**
	 * Constuctor with parameters
	 * @param effectiveDate we pass the effetive date to be stored
	 * @param rate we pass the rate to be stored
	 */
	public TaxRate(LocalDate effectiveDate, BigDecimal rate)
	{
		this();
		this.effectiveDate = effectiveDate;
		this.taxRate = rate;
	}

	/**
	 * this method checks to see of the given tax rate is effective
	 * @param date pass the date to see if the rate is effective
	 * @return returns true or false if effective
	 */
	public boolean isEffective(LocalDate date)
	{
		boolean isEffective;
		if (this.getEffectiveDate().isBefore(date) || this.getEffectiveDate().equals(date))
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
	 * this method compares the taxrate
	 * @param taxRate we pas the taxRate to compare to
	 * @return (returns an int of the difference?)
	 */
	public int compareTo(TaxRate taxRate)
	{
		return this.getEffectiveDate().compareTo(taxRate.getEffectiveDate());
	}
	
	public String getDateString()
	{
		if (this.getEffectiveDate() != null)
		{
			DateTimeFormatter format = DateTimeFormatter.ofPattern("M/d/yyyy");
			return this.getEffectiveDate().format(format);
		}
		else 
			return "";
	}

	/**
	 * ToString of the Taxrate class
	 * @return returns the string of info
	 */
	public String toString()
	{
		return this.getTaxRate().toString() + " " + this.getDateString();
	}

}