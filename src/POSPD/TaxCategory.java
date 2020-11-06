package POSPD;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

/**
 * TaxCategory class represents which category of tax and what the TaxRate for that category is
 */
public class TaxCategory 
{

	/**
	 * a category has a string
	 */
	private String category;
	/**
	 * a Tax category has a rate
	 */
	private TreeSet<TaxRate> taxRates;

	public String getCategory()
	{
		return this.category;
	}

	public void setCategory(String category)
	{
		this.category = category;
	}

	public  TreeSet<TaxRate> getTaxRates()
	{
		return this.taxRates;
	}

	/**
	 * default constructor for the TaxCategory class
	 */
	public TaxCategory()
	{
		taxRates = new TreeSet<TaxRate>();
		this.category = "";
	}

	/**
	 * constructor with parameters
	 * @param category we pass the category to be stored
	 */
	public TaxCategory(String category)
	{
		this();
		this.category = category;
	}

	/**
	 * this method gets the tax rate for the date
	 * @param date we pass the date to see the taxrate for that date
	 * @return returns the taxrate
	 */
	public BigDecimal getTaxRateForDate(LocalDate date)
	{
		BigDecimal rate = null;
		for (TaxRate taxRate: this.getTaxRates())
		{
			if(taxRate.isEffective(date))
			{
				rate = taxRate.getTaxRate();
			}
			
		}
		
		return rate;
		
	}

	/**
	 * this method adds a taxrate
	 * @param taxRate we pass the taxrate to be added
	 */
	public void addTaxRate(TaxRate taxRate)
	{
		taxRates.add(taxRate);
	}

	/**
	 * tostring method of the TaxCategory
	 * @return returns the string of info
	 */
	public String toString()
	{
		return category;
	}

	/**
	 * this method removes the taxRate we want
	 * @param taxRate
	 * @param parameter we pass the taxrate to remove
	 */
	public void removeTaxRate(TaxRate taxRate)
	{
		taxRates.remove(taxRate);
	}

	public boolean isTaxRateUsed(TaxRate otherRate) 
	{
		boolean isUsed = false;
		for (TaxRate rate : this.getTaxRates())
		{
			if(rate.equals(otherRate))
			{
				isUsed = true;
			}
			
		}
		
		return isUsed;
	}

}