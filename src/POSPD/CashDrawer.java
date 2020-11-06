package POSPD;

import java.math.BigDecimal;

public class CashDrawer
{

	/**
	 * A CashDrawer has a cash amount in it
	 */
	private BigDecimal cashAmount;
	/**
	 * A Cashdrawer has a position...
	 */
	private int position;

	public BigDecimal getCashAmount()
	{
		return this.cashAmount;
	}

	public void setCashAmount(BigDecimal cashAmount)
	{
		this.cashAmount = cashAmount;
	}

	/**
	 * The Cashdrawer Default Constructor
	 */
	public CashDrawer()
	{
		//hmmm im not sure here
		super();
		this.position = 0;
		this.cashAmount = new BigDecimal(0);
		
		
	}

	/**
	 * This method adds cash to the drawer
	 * @param cash We pass how much cash we want to put in it
	 */
	public void addCash(BigDecimal cash)
	{
		this.setCashAmount(cashAmount.add(cash));
	}

	/**
	 * This method decreases the amount of the cash in the register
	 * @param cash We pass the amount of cash we are removing
	 */
	public void removeCash(BigDecimal cash)
	{
		this.setCashAmount(cashAmount.subtract(cash));
	}

	/**
	 * toString method of the CashDrawer Class
	 */
	public String toString()
	{
		// TODO - implement CashDrawer.toString
		throw new UnsupportedOperationException();
	}

}