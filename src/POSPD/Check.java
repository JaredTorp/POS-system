package POSPD;

import java.math.BigDecimal;

/**
 * Check class represents payment with a check
 */
public class Check extends AuthorizedPayment
{

	/**
	 * A Check has a routing number
	 */
	private String routingNumber;
	/**
	 * a check has an accounting number
	 */
	private String accountNumber;
	/**
	 * a check has a checknumber
	 */
	private String checkNumber;

	public String getRoutingNumber()
	{
		return this.routingNumber;
	}

	public void setRoutingNumber(String routingNumber)
	{
		this.routingNumber = routingNumber;
	}

	public String getAccountNumber()
	{
		return this.accountNumber;
	}

	public void setAccountNumber(String accountNumber)
	{
		this.accountNumber = accountNumber;
	}

	public String getCheckNumber()
	{
		return this.checkNumber;
	}

	public void setCheckNumber(String checkNumber)
	{
		this.checkNumber = checkNumber;
	}

	/**
	 * The default contructor for a check
	 */
	public Check()
	{
		setAmount(new BigDecimal(0));
		setAmtTendered(new BigDecimal(0));
		setAuthorizationCode("");
		this.routingNumber = "";
		this.accountNumber = "";
		this.checkNumber = "";
		
	
	}

	/**
	 * A constructor for check that has parameters
	 * @param amount We pass the amount  of the check
	 * @param accountingNumber we pass the accounting number
	 * @param checkNumber we pass the check number
	 */
	public Check(String amount, String routingNumber, String accountingNumber, String checkNumber)
	{
		this();
		setAmount(new BigDecimal(amount));
		setAmtTendered(new BigDecimal(amount));
		//super.setAuthorizationCode(authorizationCode);//what is the auth code?
		this.routingNumber = routingNumber;
		this.accountNumber = accountingNumber;
		this.checkNumber = checkNumber;
	}

	/**
	 * This method checks to see if the payment is authorized
	 * @return returns true or false if the check is authorized
	 */
	public Boolean isAuthorized()
	{
		return true;
	}

	/**
	 * This method calculates the charge
	 * @return returns the charge
	 */
	public BigDecimal calcCharge()
	{
		// TODO - implement Check.calcCharge
		throw new UnsupportedOperationException();
	}

	/**
	 * the toString for the check
	 */
	public String toString()
	{
		return this.getAccountNumber() + " " + this.getAuthorizationCode() + " " + this.getCheckNumber() + " " + this.getRoutingNumber();
	}

}