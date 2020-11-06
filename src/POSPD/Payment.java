package POSPD;

import java.math.BigDecimal;

/**
 * Payment is a class that represents the payment being made by the person
 */
public class Payment
{

	/**
	 * Payment knows about its amount
	 */
	private BigDecimal amount;
	
	private BigDecimal cashAmount;
	private BigDecimal creditAmount;
	private BigDecimal checkAmount;
	
	
	
	
	
	/**
	 * Payment knows about its amount tendered
	 */
	private BigDecimal amtTendered;

	public BigDecimal getAmount()
	{
		return this.amount;
	}

	public void setAmount(BigDecimal amount)
	{
		this.amount = amount;
	}
	
	public BigDecimal getAmtTendered()
	{
		return this.amtTendered;
	}

	public void setAmtTendered(BigDecimal amtTendered)
	{
		this.amtTendered = amtTendered;
	}

	/**
	 * This function sees whether or not the payment is cash or not
	 * @return returns true or false if it is cash or not
	 */
	public Boolean countsAsCash()
	{
		// TODO - implement Payment.countsAsCash
		throw new UnsupportedOperationException();
	}

	public BigDecimal getCashAmount() {
		return cashAmount;
	}

	public void setCashAmount(BigDecimal cashAmount) {
		this.cashAmount = cashAmount;
	}

	public BigDecimal getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(BigDecimal creditAmount) {
		this.creditAmount = creditAmount;
	}

	public BigDecimal getCheckAmount() {
		return checkAmount;
	}

	public void setCheckAmount(BigDecimal checkAmount) {
		this.checkAmount = checkAmount;
	}

}