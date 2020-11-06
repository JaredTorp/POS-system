package POSPD;

import java.math.BigDecimal;

/**
 * Cash is a class that represents the cash payment being made
 */
public class Cash extends Payment
{

	/**
	 * The default constructor for cash
	 */
	public Cash()
	{
		//return to this
		setAmount(new BigDecimal(0));
		setAmtTendered(new BigDecimal(0));
	}

	/**
	 * Constructor for cash with parameters
	 * @param amount we pass the amount
	 * @param amtTendered we pass the amount tendered
	 */
	public Cash(String amount, BigDecimal amtTendered)
	{
		setAmount(new BigDecimal(amount));
		setAmtTendered(amtTendered);
	}

	/**
	 * This method will calculate how much change to give back
	 * @return returns the change
	 */
	public BigDecimal calcChange()
	{
		// TODO - implement Cash.calcChange
		throw new UnsupportedOperationException();
	}

	/**
	 * This function sees whether or not the payment is cash or not
	 * @return returns true or false if its cash or not
	 */
	public Boolean countsAsCash()
	{
		// TODO - implement Cash.countsAsCash
		throw new UnsupportedOperationException();
	}

	/**
	 * toString function for Cash
	 */
	public String toString()
	{
		// TODO - implement Cash.countsAsCash
				throw new UnsupportedOperationException();
	}

}